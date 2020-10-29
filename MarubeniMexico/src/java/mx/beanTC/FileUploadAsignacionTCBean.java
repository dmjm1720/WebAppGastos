package mx.beanTC;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import mx.bean.MakeFile;
import mx.bean.correodigibox;
import mx.conexion.DAO;
import mx.model.Concepto;
import mx.model.Usuario;
import org.jdom2.JDOMException;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;

@javax.faces.bean.ManagedBean(name = "FileUploadAsignacionTCBean")
public class FileUploadAsignacionTCBean extends DAO implements java.io.Serializable {

    private Concepto concepto = new Concepto();

    public Concepto getConcepto() {
        return this.concepto;
    }

    public void setConcepto(Concepto concepto) {
        this.concepto = concepto;
    }
    
    ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    public final String path = ctx.getRealPath("/") + "/resources/upload/";

    public void upload(FileUploadEvent event) throws JDOMException, SQLException, MessagingException {
        try {

            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());

        } catch (IOException e) {
        }
    }

    public void copyFile(String fileName, InputStream in) throws SQLException, MessagingException {
        try {
            File directorio = new File(path);
            if (!directorio.exists()) {
                directorio.mkdir();
            }

            if (fileName.endsWith(".pdf") || fileName.endsWith(".PDF")) {
                try (OutputStream dirPDF = new FileOutputStream(new File(path + fileName))) {
                    MakeFile mk = new MakeFile();
                    mk.txt(path, fileName);
                    int read = 0;
                    byte[] bytes = new byte[51200];
                    while ((read = in.read(bytes)) != -1) {
                        dirPDF.write(bytes, 0, read);
                    }
                    in.close();
                    dirPDF.flush();
                } catch (IOException e) {

                }
            } else {

                try (OutputStream dir = new FileOutputStream(new File(path + fileName))) {
                    int read = 0;
                    byte[] bytes = new byte[51200];
                    while ((read = in.read(bytes)) != -1) {
                        dir.write(bytes, 0, read);
                    }
                    setNombreCFDI(fileName);
                    if ((getNombreCFDI().contains(".xml")) || (getNombreCFDI().contains(".XML"))) {
                        leerCFDI();
                        buscarFolioAbierto();
                        setUuidConcepto(getUUIDTF());
                        buscarUUID();

                        if ((getRecuperarUUID().equals("NO EXISTE")) && (getRfcR().equals("MME720117483"))) {
                            correodigibox correo = new correodigibox();
                            correo.correo(fileName);
                            String filename = fileName;
                            String UUID = this.getUuidConcepto();
                            Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
                            String Codigosap = usuario.getCodigoSap();
                            DAO dao = new DAO();
                            dao.insertarxmls(filename, UUID, Codigosap);
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Proceso", "Comprobando XML."));
                           // insertarPartidas();
                            setTipoViaje("Extranjero");
                            setDirXML("/resources/upload/" + fileName);
                            setCard("Si");
                            setMiprop(this.concepto.getPropina());
                            setConceptName("Viáticos");
                            insertarConcepto();

                            MakeFile mk = new MakeFile();
                            mk.buscarArchivo(new File(path));

                            limpiarLista();
                            limpiarVariables();
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Comprobante subido correctamente"));
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "SISTEMA DE GASTOS", "Validando en el SAT, Si tu XML es rechazado por el SAT recibiras un correo"));
                            Cerrar();
                        } else if (!getRfcR().equals("MME720117483")) {
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE GASTOS", "Tu XML ingresado no corresponde a Marubeni México, favor de verificarlo."));
                            limpiarLista();
                            limpiarVariables();
                            Cerrar();

                        } else {

                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE GASTOS", "El XML ya fue ingresado en el reporte del usuario: " + getnUsario() + " Folio: " + getfUsuario()));
                            Cerrar();
                            limpiarLista();
                            limpiarVariables();
                        }
                    }

                    setNombreCFDI(null);
                    in.close();
                    dir.flush();
                    dir.close();
                }
            }
        } catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Sistema de Gastos Marubeni", "El XML tiene problemas que impiden procesarlo. Error: " + e.getMessage() + " Por favor revisa tu XML"));
        } catch (JDOMException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Sistema de Gastos Marubeni", "El XML tiene problemas que impiden procesarlo. Error: " + ex.getMessage().replace("file:/C:/xampp/htdocs/files/", "") + " Por favor revisa tu XML"));
        }
    }

    public void mipropina() throws IOException {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        try {
            Conectar();
            if (this.concepto.getPropina() != null) {
                PreparedStatement ps = getCn().prepareStatement("UPDATE concepto SET propina='" + this.concepto.getPropina() + "' WHERE nombreConcepto='Viáticos' AND uuid <>''  AND propina IS NULL AND nombreUsuario='" + us.getCodigoSap() + "'");
                ps.executeUpdate();
            } else {
                PreparedStatement ps = getCn().prepareStatement("UPDATE concepto SET propina='0' WHERE nombreConcepto='Viáticos' AND uuid <>''  AND propina IS NULL AND nombreUsuario='" + us.getCodigoSap() + "'");
                ps.executeUpdate();
            }
            RequestContext.getCurrentInstance().execute("PF('dlg3').hide()");
            submit();
            Cerrar();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/MarubeniMexico/Views/Gastos/ConceptoAsigna.jsf");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String submit() {
        return "/USDConceptoAsigna.xhtml?faces-redirect=true";
    }
}
