package mx.bean;

import java.io.IOException;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import mx.bean.img.subirImagenBean;
import mx.conexion.DAO;
import mx.dao.ConceptoDao;
import mx.dao.ViajeDao;
import mx.impl.ConceptoDaoImpl;
import mx.impl.ViajeDaoImpl;
import mx.model.Concepto;
import mx.model.Usuario;
import mx.model.Viaje;
import org.primefaces.context.RequestContext;
import org.primefaces.model.UploadedFile;

@Named("conceptoBean")
@ViewScoped
public class conceptoBean
        extends DAO
        implements Serializable {

    private List<Concepto> listaConcepto;
    private List<Concepto> listaConceptoUSD;
    private List<SelectItem> listaFolio;
    private List<SelectItem> listNombreUsuario;
    private List<Concepto> listaRFC;
    private subirImagenBean procesarImagen;
    private Concepto concepto;
    private UploadedFile file;

    public List<Concepto> getListaConceptoUSD() {
        ConceptoDao cDao = new ConceptoDaoImpl();
        this.listaConceptoUSD = cDao.listaConceptoUSD();
        return this.listaConceptoUSD;
    }

    public void setListaConceptoUSD(List<Concepto> listaConceptoUSD) {
        this.listaConceptoUSD = listaConceptoUSD;
    }

    public void setListaViaje(List<Concepto> listaConcepto) {
        this.listaConcepto = listaConcepto;
    }

    public Concepto getConcepto() {
        return this.concepto;
    }

    public void setConcepto(Concepto concepto) {
        this.concepto = concepto;
    }

    public List<Concepto> getListaConcepto() {
        ConceptoDao cDao = new ConceptoDaoImpl();
        this.listaConcepto = cDao.listaConcepto();
        return this.listaConcepto;
    }

    public void prepararNuevoConcepto() {
        this.concepto = new Concepto();
    }

    public subirImagenBean getProcesarImagen() {
        return this.procesarImagen;
    }

    public void setProcesarImagen(subirImagenBean procesarImagen) {
        this.procesarImagen = procesarImagen;
    }

    public UploadedFile getFile() {
        return this.file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void nuevoConcepto() {
        ConceptoDao cDao = new ConceptoDaoImpl();
        this.concepto.setModificarArchivo("NN");
        cDao.nuevoConcepto(this.concepto);

        if (this.concepto.getTipo().equals("Nacional")) {
            RequestContext.getCurrentInstance().execute("PF('dialogNuevoConTCoorp').hide();PF('dialogNuevoConcepto').hide();PF('dlgSubirImagen').show();");
        } else {
            RequestContext.getCurrentInstance().execute("PF('dialogNuevoConTCoorp').hide();PF('dialogNuevoConcepto').hide();PF('dlgDolaresSTC').hide();PF('dlgNewDolares').hide();PF('dlgSubirImagen').show();");
        }
    }

    public void upload() {
        try {
            if (this.file != null) {
                Conectar();
                PreparedStatement ps = getCn().prepareStatement("UPDATE concepto  SET imagen=?, modificarArchivo=NULL WHERE nombreConcepto='" + this.concepto.getNombreConcepto() + "' AND nombreUsuario='" + this.concepto.getNombreUsuario() + "' AND folioUsuario='" + this.concepto.getFolioUsuario() + "'AND estado='Agregar' AND modificarArchivo='NN'");

                ps.setBinaryStream(1, this.file.getInputstream());
                ps.executeUpdate();
                Cerrar();
            }
        } catch (IOException | SQLException e) {
        }
    }

    public void verImagen() throws IOException {
        try {
            byte[] bytes = null;
            Conectar();
            PreparedStatement ps = getCn().prepareStatement("SELECT imagen FROM concepto WHERE idConcepto='" + this.concepto.getIdConcepto() + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                bytes = rs.getBytes("imagen");
            }
            Cerrar();
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            response.getOutputStream().write(bytes);
            response.getOutputStream().close();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (SQLException ex) {
        }
    }

    public void modificarConcepto() {
        ConceptoDao cDao = new ConceptoDaoImpl();
        cDao.updateConcepto(this.concepto);
        this.concepto = new Concepto();
    }

    public void eliminarConcepto() {
        ConceptoDao cDao = new ConceptoDaoImpl();
        cDao.deleteConcepto(this.concepto);
        this.concepto = new Concepto();
    }

    public List<SelectItem> getListaFolio() {
        this.listaFolio = new ArrayList();
        ViajeDao fDao = new ViajeDaoImpl();
        List<Viaje> f = fDao.listaPorFolio();
        for (Viaje folio : f) {
            SelectItem nombreItem = new SelectItem(folio.getFolioUsuario());
            this.listaFolio.add(nombreItem);
        }
        return this.listaFolio;
    }

    public List<SelectItem> getListNombreUsuario() {
        this.listNombreUsuario = new ArrayList();
        ConceptoDao uDao = new ConceptoDaoImpl();
        List<Usuario> u = uDao.listaporNombre();
        this.listNombreUsuario.clear();

        for (Usuario nombre : u) {
            SelectItem nombreItem = new SelectItem(nombre.getCodigoSap());
            this.listNombreUsuario.add(nombreItem);
        }
        return this.listNombreUsuario;
    }

    public List<Concepto> getListaRFC() {
        ConceptoDao cDao = new ConceptoDaoImpl();
        this.listaRFC = cDao.listaSAT();
        FacesMessage message = null;
        if (this.listaRFC.equals("RFC INVALIDO, NO CORRESPONDE A MARUBENI MEXICO")) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", "Hola");
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", "Hola");
        }
        return this.listaRFC;
    }
}
