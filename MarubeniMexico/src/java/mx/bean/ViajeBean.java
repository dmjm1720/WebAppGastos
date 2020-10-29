package mx.bean;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import mx.conexion.DAO;
import mx.dao.ConceptoDao;
import mx.dao.ViajeDao;
import mx.impl.ConceptoDaoImpl;
import mx.impl.ViajeDaoImpl;
import mx.model.Categoria;
import mx.model.Concepto;
import mx.model.Usuario;
import mx.model.Viaje;
import mx.report.reporteCFDI;
import mx.report.reporteGasto;
import org.primefaces.context.RequestContext;

@javax.inject.Named
@ViewScoped
public class ViajeBean extends DAO implements java.io.Serializable {

    private List<Viaje> listaViaje;
    private List<Viaje> listaViajeConcluidos;

    private Viaje viaje;
    private List<SelectItem> listNombreUsuario;
    private List<SelectItem> listPorDepto;
    private List<Viaje> lisSAT;
    private int dia;
    private int mes;
    private int año;
    private Calendar hoy;
    private String fechaPago;
    private String pathReporte = "";
    private Integer conteo;
    private Integer conteo1;
    private String tipo;
    private String foliador;
    private String folio;
    private String codigo;
    private Usuario usuario;
    private String pwd1;
    private String pwd2;
    private String pwd3;
    private String pwd4;
    private mx.model.Concepto concepto;
    private String uuid;
    private Concepto c;
    private Viaje viajeConcepto;

    private List<Concepto> listaBorrarConcepto;

    private List<Concepto> listaConceptoViaje;

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<SelectItem> getListPorDepto() {
        return this.listPorDepto;
    }

    public void setListPorDepto(List<SelectItem> listPorDepto) {
        this.listPorDepto = listPorDepto;
    }

    public void setListaViaje(List<Viaje> listaViaje) {
        this.listaViaje = listaViaje;
    }

    public Viaje getViaje() {
        return this.viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    public List<Viaje> getListaViaje() {
        ViajeDao vDao = new ViajeDaoImpl();
        this.listaViaje = vDao.listaViajes();
        return this.listaViaje;
    }

    public void prepararNuevoViaje() {
        this.viaje = new Viaje();
    }

    public int getDia() {
        return this.dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return this.mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return this.año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public Calendar getHoy() {
        return this.hoy;
    }

    public void setHoy(Calendar hoy) {
        this.hoy = hoy;
    }

    public String getFechaPago() {
        return this.fechaPago;
    }

    public void setFechaPAgo(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFoliador() {
        return this.foliador;
    }

    public void setFoliador(String foliador) {
        this.foliador = foliador;
    }

    public String getPathReporte() {
        return this.pathReporte;
    }

    public void setPathReporte(String pathReporte) {
        this.pathReporte = pathReporte;
    }

    public Integer getConteo() {
        return this.conteo;
    }

    public void setConteo(Integer conteo) {
        this.conteo = conteo;
    }

    public String getFolio() {
        return this.folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public Integer getConteo1() {
        return this.conteo1;
    }

    public void setConteo1(Integer conteo1) {
        this.conteo1 = conteo1;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getPwd1() {
        return this.pwd1;
    }

    public void setPwd1(String pwd1) {
        this.pwd1 = pwd1;
    }

    public String getPwd2() {
        return this.pwd2;
    }

    public void setPwd2(String pwd2) {
        this.pwd2 = pwd2;
    }

    public String getPwd3() {
        return this.pwd3;
    }

    public void setPwd3(String pwd3) {
        this.pwd3 = pwd3;
    }

    public String getPwd4() {
        return this.pwd4;
    }

    public void setPwd4(String pwd4) {
        this.pwd4 = pwd4;
    }

    public List<Concepto> getListaBorrarConcepto() {
        return listaBorrarConcepto;
    }

    public List<Viaje> getListaViajeConcluidos() {
        ViajeDao vDao = new ViajeDaoImpl();
        this.listaViajeConcluidos = vDao.listaViajesConcluidos();
        return this.listaViajeConcluidos;
    }

    public void setListaViajeConcluidos(List<Viaje> listaViajeConcluidos) {
        this.listaViajeConcluidos = listaViajeConcluidos;
    }

    public Concepto getC() {
        return c;
    }

    public void setC(Concepto c) {
        this.c = c;
    }

    public Viaje getViajeConcepto() {
        return viajeConcepto;
    }

    public void setViajeConcepto(Viaje viajeConcepto) {
        this.viajeConcepto = viajeConcepto;
    }

    public List<Concepto> getListaConceptoViaje() {
        return listaConceptoViaje;
    }

    public void nuevoViaje() {
        if ((this.viaje.getTipoViaje().equals("Nacional"))
                && (this.viaje.getMutual().equals("Si"))) {
            if (((this.viaje.getSeccion().isEmpty()) && (this.viaje.getComentario().isEmpty())) || (this.viaje.getSeccion().isEmpty()) || (this.viaje.getComentario().isEmpty())) {
                if (this.viaje.getSeccion().isEmpty()) {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE GASTOS", "Ingrese Sección");
                    FacesContext.getCurrentInstance().addMessage(null, message);
                }
                if (this.viaje.getComentario().isEmpty()) {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE GASTOS", "Ingrese comentario");
                    FacesContext.getCurrentInstance().addMessage(null, message);
                }
            } else {
                ViajeDao vDao = new ViajeDaoImpl();
                vDao.newViaje(this.viaje);
                RequestContext.getCurrentInstance().execute("PF('dialogNuevoViaje').hide();");
            }
        }

        if ((this.viaje.getTipoViaje().equals("Extranjero"))
                && (this.viaje.getMutual().equals("Si"))) {
            if (((this.viaje.getSeccion().isEmpty()) && (this.viaje.getComentario().isEmpty())) || (this.viaje.getSeccion().isEmpty()) || (this.viaje.getComentario().isEmpty())) {
                if (this.viaje.getSeccion().isEmpty()) {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE GASTOS", "Ingrese Sección");
                    FacesContext.getCurrentInstance().addMessage(null, message);
                }
                if (this.viaje.getComentario().isEmpty()) {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE GASTOS", "Ingrese comentario");
                    FacesContext.getCurrentInstance().addMessage(null, message);
                }
            } else {
                ViajeDao vDao = new ViajeDaoImpl();
                vDao.newViaje(this.viaje);
                RequestContext.getCurrentInstance().execute("PF('dialogNuevoExtra').hide();");
            }
        }

        if (((this.viaje.getTipoViaje().equals("Nacional")) || (this.viaje.getTipoViaje().equals("Extranjero")))
                && (this.viaje.getMutual().equals("No"))) {
            ViajeDao vDao = new ViajeDaoImpl();
            vDao.newViaje(this.viaje);
            RequestContext.getCurrentInstance().execute("PF('dialogNuevoViaje').hide();PF('dialogNuevoExtra').hide()");
        }
    }

    public void modificarViaje()
            throws MessagingException, NoSuchProviderException, IOException, InterruptedException {
        if (this.viaje.getStatus().equals("Cerrar")) {
            ViajeDao vDao = new ViajeDaoImpl();
            vDao.updateViaje(viaje);
            enviarCorreo();
//            verificarcorreo correop = new verificarcorreo();
//
//            if (correop.verificarcorreo(viaje) == 1) {
//                ViajeDao vDao = new ViajeDaoImpl();
//                vDao.updateViaje(viaje);
//                enviarCorreo();
//                viaje = new Viaje();
//
//            }
        } else {
            ViajeDao vDao = new ViajeDaoImpl();
            vDao.updateViaje(viaje);
        }
    }

    public void eliminarViaje() {
        ViajeDao vDao = new ViajeDaoImpl();
        vDao.deleteViaje(this.viaje);
        this.viaje = new Viaje();
    }

    public List<SelectItem> getListNombreUsuario() {
        this.listNombreUsuario = new ArrayList();
        ViajeDao uDao = new ViajeDaoImpl();
        List<Usuario> u = uDao.listaporNombre();
        this.listNombreUsuario.clear();

        for (Usuario nombre : u) {
            SelectItem nombreItem = new SelectItem(nombre.getCodigoSap());
            this.listNombreUsuario.add(nombreItem);
        }
        return this.listNombreUsuario;
    }

    public List<Viaje> getLisSAT() {
        return this.lisSAT;
    }

    public List<SelectItem> getlistPorDepto() {
        this.listPorDepto = new ArrayList();
        ViajeDao uDao = new ViajeDaoImpl();
        List<Categoria> u = uDao.listaDepto();
        this.listPorDepto.clear();

        for (Categoria nombre : u) {
            SelectItem nombreItem = new SelectItem(nombre.getSubDepartamento());
            this.listPorDepto.add(nombreItem);
        }

        return this.listPorDepto;
    }

    public void mostrarDialogo() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        if (us.getTarjetaCoorporativa().equals("Si")) {
            RequestContext req = RequestContext.getCurrentInstance();
            req.execute("PF('dlgTarjeta').show();PF('dlgTarjetaGasolina').hide();");
        } else {
            RequestContext req = RequestContext.getCurrentInstance();
            req.execute("PF('dlg2').show();PF('dlgTarjetaGasolina').hide();");
        }
    }

    public void mostrarDialogoGasolina() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        if (us.getTarjetaGasolina().equals("Si")) {
            RequestContext req = RequestContext.getCurrentInstance();
            req.execute("PF('dlgTarjetaGasolina').show();");
        } else if (us.getTarjetaCoorporativa().equals("Si")) {
            RequestContext req = RequestContext.getCurrentInstance();
            req.execute("PF('dlgTarjeta').show();");
        } else {
            RequestContext req = RequestContext.getCurrentInstance();
            req.execute("PF('dlg2').show();");
        }
    }

    public void Dialogo() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        if (us.getTarjetaCoorporativa().equals("Si")) {
            RequestContext req = RequestContext.getCurrentInstance();
            req.execute("PF('dlgTarjeta').show();");
        } else {
            RequestContext req = RequestContext.getCurrentInstance();

            req.execute("PF('dlgTarjeta').show();");
        }
    }

    public void tipoNE() throws SQLException {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        this.tipo = request.getParameter("frmAgregar:tipo");
        this.foliador = request.getParameter("frmAgregar:foliador");
        String[] miFolio = this.foliador.split("-");
        this.foliador = miFolio[3];
        Conectar();
        PreparedStatement ps = getCn().prepareStatement("UPDATE viaje SET status=? WHERE nombreViajero='" + us.getCodigoSap() + "' AND status='Agregar'");
        ps.setString(1, "Pendiente");
        ps.executeUpdate();
        PreparedStatement ps1 = getCn().prepareStatement("UPDATE viaje SET status=? WHERE nombreViajero='" + us.getCodigoSap() + "' AND folioUsuario='" + this.foliador + "' AND status='Pendiente'");
        ps1.setString(1, "Agregar");
        ps1.executeUpdate();
        Cerrar();
        if (this.tipo.equals("Nacional")) {
            RequestContext.getCurrentInstance().execute("PF('dlgNacional').show();PF('dlgAgregar').hide()");
        } else {
            RequestContext.getCurrentInstance().execute("PF('dlgExtranjero').show();PF('dlgAgregar').hide()");
        }
    }

    public void DialogoViaticos() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        RequestContext req = RequestContext.getCurrentInstance();
        req.execute("PF('dlg2').show()");
    }

    public void mostrarDialogoUSD() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        if (us.getTarjetaCoorporativa().equals("Si")) {
            RequestContext req = RequestContext.getCurrentInstance();
            req.execute("PF('dlgTarjeta').show()");
        } else {
            RequestContext req = RequestContext.getCurrentInstance();
            req.execute("PF('dlgPesos').show()");
        }
    }

    public void dlgViaticosExt() {
        RequestContext req = RequestContext.getCurrentInstance();

        req.execute("PF('dlgPesos').show()");
    }

    public void reporteViajeBean() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        this.folio = request.getParameter("frmViewPol:folio");
        this.codigo = request.getParameter("frmViewPol:codigo");
        this.tipo = request.getParameter("frmViewPol:tipo");
        Conectar();
        Statement st = getCn().createStatement();
        ResultSet rs = st.executeQuery("SELECT COUNT(nombreConcepto) as conteo  FROM concepto WHERE nombreUsuario='" + this.codigo + "' AND folioUsuario='" + this.folio + "'");
        while (rs.next()) {
            this.conteo1 = Integer.valueOf(rs.getInt("conteo"));
            if (this.tipo.equals("Nacional")) {
                if (this.conteo1.intValue() > 0) {
                    this.pathReporte = "/Report/reporte.jasper";
                } else {
                    this.pathReporte = "/Report/reporteDayAllowance.jasper";
                }
            } else if (this.conteo1.intValue() > 0) {
                this.pathReporte = "/Report/reporteExt.jasper";
            } else {
                this.pathReporte = "/Report/reporteExtDayAllowance.jasper";
            }
        }

        reporteGasto rCliente = new reporteGasto();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath(this.pathReporte);

        rCliente.getReporte(ruta, this.codigo, this.folio);
        FacesContext.getCurrentInstance().responseComplete();
        Cerrar();
    }

    public void enviarCorreo() throws MessagingException {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        this.hoy = Calendar.getInstance();
        this.dia = this.hoy.get(7);
        switch (this.dia) {
            case 1:
                this.hoy.add(5, 5);
                break;
            case 2:
                this.hoy.add(5, 4);
                break;
            case 3:
                this.hoy.add(5, 3);
                break;
            case 4:
                this.hoy.add(5, 2);
                break;
            case 5:
                this.hoy.add(5, 8);
                break;
            case 6:
                this.hoy.add(5, 7);
                break;
            default:
                this.hoy.add(5, 6);
        }

        SimpleDateFormat formateador = new SimpleDateFormat("dd-MMMM-yyyy");
        this.fechaPago = formateador.format(this.hoy.getTime());
        Properties props = new Properties();
        props.put("mail.smtp.host", "mail.grupocomercialtria.com.mx");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", "validaciones@grupocomercialtria.com.mx");
        props.setProperty("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props, null);
        session.setDebug(false);

        BodyPart texto = new MimeBodyPart();
        texto.setContent("<html><head><title></title></head><body><table width='678' height='315' border='0' bordercolor='#0000FF' bgcolor='#FFFFFF'><tr><td height='50' colspan='3' bordercolor='#FFFFFF'><br><br></td></tr><tr><td colspan='3' bordercolor='#FFFFFF'><p align='left' style='font-family:calibri; font-size:17px'><font color='#086A87'>El usuario ha concluido la captura de gastos de viaje para su proceso de revisi&oacute;n: </font><br><br><font color='#17202a'>Folio Usuario: </font><i><font color='#086A87'> " + this.viaje
                .getDepartamento().substring(0, 2) + "-" + this.viaje.getNombreViajero() + "-" + this.viaje.getFechaAno().toString().trim() + "-" + this.viaje.getFolioUsuario() + "</font></i> <br><font color='#17202a'>Tipo de Viaje:</font> <font color='#086A87'><i> " + this.viaje
                .getTipoViaje() + "</i></font><br><font color='#17202a'>Origen:</font> <font color='#086A87'><i> " + this.viaje
                        .getOrigen() + " </i></font><br><font color='#17202a'>Destino:</font> <font color='#086A87'><i> " + this.viaje
                        .getDestino() + " </i></font><br><font color='#17202a'>Prop&oacute;sito:</font> <font color='#086A87'><i> " + this.viaje
                        .getProposito() + " </i></font><br><font color='#17202a'>Fecha de Salida:</font> <font color='#086A87'><i> " + this.viaje
                        .getFechaOrigen() + " </i></font><br><font color='#17202a'>Fecha de Llegada:</font> <font color='#086A87'><i> " + this.viaje
                        .getFechaLlegada() + " </i></font><br><font color='#17202a'>D&iacute;as del Viaje:</font> <font color='#086A87'><i> " + this.viaje
                        .getDias() + " </i></font><br><font color='black'><b>Fecha probable de pago: " + this.fechaPago.toUpperCase() + "</b></font><br></td></tr><tr><td width='425' bordercolor='#FFFFFF'><p align='left' style='font-family:calibri; font-size:17px'><br><font color='#17202a'>Sistema de Gastos | </font><font color='#E60013'>Marubeni M&eacute;xico, S.A. de C.V.</font><br><a href='https://portal.marubeni.com.mx' target='_blank'><img src='cid:image' width='45%'/></a></td><td width='122' bordercolor='#FFFFFF'></td><td width='222' rowspan='2' bordercolor='#FFFFFF'></td></tr><tr><td colspan='2' bordercolor='#17202a'><br><br><p align='center' style='font-family:calibri; font-size:15px'><font color='#086A87'><br> Mensaje enviado desde el Sistema de Gastos de Viaje Marubeni.</font></p></td></tr></table></body></html>", "text/html");

        MimeMultipart multiParte = new MimeMultipart();
        BodyPart imagen = new MimeBodyPart();
        DataSource fds = new FileDataSource("C:\\img\\marubeni-logo.png");
        imagen.setDataHandler(new DataHandler(fds));
        imagen.setHeader("Content-ID", "<image>");

        multiParte.addBodyPart(texto);

        multiParte.addBodyPart(imagen);

        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress("validaciones@grupocomercialtria.com.mx"));

        //message.addRecipients(Message.RecipientType.CC, "desarrollo1@grupocomercialtria.com.mx");
        message.addRecipients(Message.RecipientType.TO, us.getCorreo());
        message.addRecipient(Message.RecipientType.CC, new InternetAddress("Solano-H@marubeni.com"));
        message.addRecipient(Message.RecipientType.CC, new InternetAddress("Martinez-R@marubeni.com"));
        message.addRecipient(Message.RecipientType.BCC, new InternetAddress("alertas@grupocomercialtria.com.mx"));

        message.setSubject("Gastos de Viaje Marubeni");

        message.setContent(multiParte);

        Transport t = session.getTransport("smtp");
        t.connect("validaciones@grupocomercialtria.com.mx", "WK4iaKFhAj");
        t.sendMessage(message, message.getAllRecipients());
        aviso();
        t.close();
    }

    public void aviso() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Se ha enviado un correo electrónico de captura de Gasto cerrado");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void actualizarContraseña() throws SQLException {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        Conectar();
        Statement st = getCn().createStatement();
        ResultSet rs = st.executeQuery("SELECT clave FROM usuario WHERE codigoSap='" + us.getCodigoSap() + "'");
        while (rs.next()) {
            this.pwd4 = rs.getString("clave");
            if ((this.pwd4.equals(this.pwd1)) && (this.pwd2.equals(this.pwd3))) {
                if (this.pwd3.equals(this.pwd4)) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "SISTEMA DE GASTOS", "Tu contraseña se ha cambiado correctamente..."));
                }

            } else if (this.pwd4 == null ? this.pwd1 != null : !this.pwd4.equals(this.pwd1)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "SISTEMA DE GASTOS", "Tu contraseña no es igual a la"));
            }
        }
    }

    public void visualizarCFDI_PDF()
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        this.uuid = request.getParameter("frmVerXML:uuid");
        reporteCFDI rCliente = new reporteCFDI();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/Report/facturaPDF.jasper");

        rCliente.getReporte(ruta, this.uuid);

        FacesContext.getCurrentInstance().responseComplete();
    }

    public void borrarViaje() {
        ViajeDao vDao = new ViajeDaoImpl();
        vDao.deleteViaje(viaje);//Borramos el registro de la tabla viaje
        this.listaBorrarConcepto = new ArrayList<>();
        ConceptoDao listaDao = new ConceptoDaoImpl();
        this.listaBorrarConcepto = listaDao.listaConceptoBorrar(viaje.getNombreViajero(), viaje.getFolioUsuario());
        for (int i = 0; i < listaBorrarConcepto.size(); i++) {
            this.c = new Concepto();
            this.c.setIdConcepto(listaBorrarConcepto.get(i).getIdConcepto());
            ConceptoDao cDao = new ConceptoDaoImpl();
            cDao.deleteConceptoViaje(this.c.getIdConcepto());//Borramos el registro de la tabla concepto
        }
    }

    public void listarViajeConcepto(String nombre, String folio) {
        this.listaConceptoViaje = new ArrayList<>();
        ConceptoDao listaDao = new ConceptoDaoImpl();
        this.listaConceptoViaje = listaDao.listaConceptoViaje(nombre, folio);
    }

    public void xmlPdf(String uuidXML) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        reporteCFDI rCliente = new reporteCFDI();
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
        String ruta = servletContext.getRealPath("/Report/facturaPDF.jasper");
        
        rCliente.getReporte(ruta, uuidXML);

        FacesContext.getCurrentInstance().responseComplete();
    }
}
