package mx.bean;

import java.io.Serializable;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import mx.conexion.DAO;
import mx.dao.BancosDao;
import mx.dao.CorreosDao;
import mx.impl.CuenM01DaoImpl;
import org.primefaces.context.RequestContext;
import mx.dao.CuenM01Dao;
import mx.dao.PagosDao;
import mx.dao.VendedorDao;
import mx.impl.BancosDaoImpl;
import mx.impl.CorreosDaoImpl;
import mx.impl.PagosDaoImpl;
import mx.impl.VendedorDaoImpl;
import mx.model.Bancos;
import mx.model.Cuenm01;
import mx.model.Importes;
import mx.model.Pagos;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.RowEditEvent;

@Named("procesoBean")
@ViewScoped
public class FacturaProcesoBean
  extends DAO
  implements Serializable
{
  private List<Cuenm01> lF;
  private List<Cuenm01> listaRep;
  private Cuenm01 f;
  private Boolean pagoParcial;
  private Double nuevoPrecio;
  private List<String> listaCorreos;
  private List<String> listaVendedor;
  private Date fechaHoy;
  private Pagos p;
  private List<String> listaPagos;
  private List<Importes> listaImportes;
  private Boolean mulpitlePago;
  private Double tCambio;
  private Importes importes;
  private Double Impmxn = Double.valueOf(0.0D);
  private Double Impusd = Double.valueOf(0.0D);
  private List<String> listaFacturas;
  private String facturas;
  private List<String> factPagoMult;
  private int folioPago;
  private int dia;
  private int mes;
  private int año;
  private Calendar hoy;
  private String fecPago;
  private List<Cuenm01> listarParciales;
  private String vend;
  private Double tcam;
  private String tipoTrans;
  private int tPago;
  private Boolean pro;
  private Double saldo;
  private String subcta;
  private Bancos bancos;
  private List<SelectItem> listaBancos;
  private String subctabancos;
  private int monedaAnterior;
  private Double montoMXN = Double.valueOf(0.0D);
  private Double montoUSD = Double.valueOf(0.0D);
  private Boolean fechaPago = Boolean.FALSE;
  private Date fechaCierre;
  private Date now;
  private String fechaVar;
  private String tipoMoneda;
  
  public FacturaProcesoBean()
  {
    this.f = new Cuenm01();
    this.p = new Pagos();
    this.importes = new Importes();
    this.bancos = new Bancos();
  }
  
  public Cuenm01 getF()
  {
    return this.f;
  }
  
  public void setF(Cuenm01 f)
  {
    this.f = f;
  }
  
  public List<Cuenm01> getlF()
  {
    return this.lF;
  }
  
  public Pagos getP()
  {
    return this.p;
  }
  
  public void setP(Pagos p)
  {
    this.p = p;
  }
  
  public Importes getImportes()
  {
    return this.importes;
  }
  
  public void setImportes(Importes importes)
  {
    this.importes = importes;
  }
  
  public Boolean getMulpitlePago()
  {
    return this.mulpitlePago;
  }
  
  public void setMulpitlePago(Boolean mulpitlePago)
  {
    this.mulpitlePago = mulpitlePago;
  }
  
  public List<Importes> getListaImportes()
  {
    return this.listaImportes;
  }
  
  public List<Cuenm01> listarFacturas()
    throws SQLException
  {
    revisarFacturas();
    CuenM01Dao fDao = new CuenM01DaoImpl();
    this.lF = fDao.listaFactura();
    return this.lF;
  }
  
  public List<String> getListaPagos()
  {
    return this.listaPagos;
  }
  
  public List<Cuenm01> getListaRep()
  {
    CuenM01Dao fDao = new CuenM01DaoImpl();
    this.listaRep = fDao.listaReporte();
    return this.listaRep;
  }
  
  public Boolean getPagoParcial()
  {
    return this.pagoParcial;
  }
  
  public void setPagoParcial(Boolean pagoParcial)
  {
    this.pagoParcial = pagoParcial;
  }
  
  public Double getNuevoPrecio()
  {
    return this.nuevoPrecio;
  }
  
  public void setNuevoPrecio(Double nuevoPrecio)
  {
    this.nuevoPrecio = nuevoPrecio;
  }
  
  public Date getFechaHoy()
  {
    return this.fechaHoy;
  }
  
  public void setFechaHoy(Date fechaHoy)
  {
    this.fechaHoy = fechaHoy;
  }
  
  public Double gettCambio()
  {
    return this.tCambio;
  }
  
  public void settCambio(Double tCambio)
  {
    this.tCambio = tCambio;
  }
  
  public Double getImpmxn()
  {
    return this.Impmxn;
  }
  
  public void setImpmxn(Double Impmxn)
  {
    this.Impmxn = Impmxn;
  }
  
  public Double getImpusd()
  {
    return this.Impusd;
  }
  
  public void setImpusd(Double Impusd)
  {
    this.Impusd = Impusd;
  }
  
  public String getFacturas()
  {
    return this.facturas;
  }
  
  public void setFacturas(String facturas)
  {
    this.facturas = facturas;
  }
  
  public int getFolioPago()
  {
    return this.folioPago;
  }
  
  public void setFolioPago(int folioPago)
  {
    this.folioPago = folioPago;
  }
  
  public int getDia()
  {
    return this.dia;
  }
  
  public void setDia(int dia)
  {
    this.dia = dia;
  }
  
  public int getAño()
  {
    return this.año;
  }
  
  public void setAño(int año)
  {
    this.año = año;
  }
  
  public Calendar getHoy()
  {
    return this.hoy;
  }
  
  public void setHoy(Calendar hoy)
  {
    this.hoy = hoy;
  }
  
  public String getFecPago()
  {
    return this.fecPago;
  }
  
  public void setFecPago(String fecPago)
  {
    this.fecPago = fecPago;
  }
  
  public String getVend()
  {
    return this.vend;
  }
  
  public void setVend(String vend)
  {
    this.vend = vend;
  }
  
  public Double getTcam()
  {
    return this.tcam;
  }
  
  public void setTcam(Double tcam)
  {
    this.tcam = tcam;
  }
  
  public String getTipoTrans()
  {
    return this.tipoTrans;
  }
  
  public void setTipoTrans(String tipoTrans)
  {
    this.tipoTrans = tipoTrans;
  }
  
  public int gettPago()
  {
    return this.tPago;
  }
  
  public void settPago(int tPago)
  {
    this.tPago = tPago;
  }
  
  public Boolean getPro()
  {
    return this.pro;
  }
  
  public void setPro(Boolean pro)
  {
    this.pro = pro;
  }
  
  public Double getSaldo()
  {
    return this.saldo;
  }
  
  public void setSaldo(Double saldo)
  {
    this.saldo = saldo;
  }
  
  public int getMonedaAnterior()
  {
    return this.monedaAnterior;
  }
  
  public void setMonedaAnterior(int monedaAnterior)
  {
    this.monedaAnterior = monedaAnterior;
  }
  
  public List<Cuenm01> getListarParciales()
  {
    return this.listarParciales;
  }
  
  public List<Cuenm01> listParciales()
  {
    CuenM01Dao cDao = new CuenM01DaoImpl();
    this.listarParciales = cDao.lsitaFacturasParciales();
    return this.listarParciales;
  }
  
  public String getSubcta()
  {
    return this.subcta;
  }
  
  public void setSubcta(String subcta)
  {
    this.subcta = subcta;
  }
  
  public Bancos getBancos()
  {
    return this.bancos;
  }
  
  public void setBancos(Bancos bancos)
  {
    this.bancos = bancos;
  }
  
  public String getSubctabancos()
  {
    return this.subctabancos;
  }
  
  public void setSubctabancos(String subctabancos)
  {
    this.subctabancos = subctabancos;
  }
  
  public Double getMontoMXN()
  {
    return this.montoMXN;
  }
  
  public void setMontoMXN(Double montoMXN)
  {
    this.montoMXN = montoMXN;
  }
  
  public Double getMontoUSD()
  {
    return this.montoUSD;
  }
  
  public void setMontoUSD(Double montoUSD)
  {
    this.montoUSD = montoUSD;
  }
  
  public Boolean getFechaPago()
  {
    return this.fechaPago;
  }
  
  public void setFechaPago(Boolean fechaPago)
  {
    this.fechaPago = fechaPago;
  }
  
  public Date getFechaCierre()
  {
    return this.fechaCierre;
  }
  
  public void setFechaCierre(Date fechaCierre)
  {
    this.fechaCierre = fechaCierre;
  }
  
  public Date getNow()
  {
    return this.now;
  }
  
  public void setNow(Date now)
  {
    this.now = now;
  }
  
  public String getFechaVar()
  {
    return this.fechaVar;
  }
  
  public void setFechaVar(String fechaVar)
  {
    this.fechaVar = fechaVar;
  }
  
  public String getTipoMoneda()
  {
    return this.tipoMoneda;
  }
  
  public void setTipoMoneda(String tipoMoneda)
  {
    this.tipoMoneda = tipoMoneda;
  }
  
  public List<SelectItem> getListaBancos()
  {
    this.listaBancos = new ArrayList();
    BancosDao bDao = new BancosDaoImpl();
    List<Bancos> b = bDao.listaBancos();
    for (Bancos item : b)
    {
      SelectItem nombreItem = new SelectItem(item.getNombre());
      this.listaBancos.add(nombreItem);
    }
    return this.listaBancos;
  }
  
  public void revisarFacturas()
    throws SQLException
  {
    ConectarSAE();
    Statement ps = getCnSAE().createStatement();
    
    ResultSet rs = ps.executeQuery("SELECT CVE_CLIE, NO_FACTURA, IMPORTE, FECHA_APLI, NUM_MONED, TCAMBIO, IMPMON_EXT,STRCVEVEND FROM CUEN_M01 WHERE  FECHA_APLI LIKE'%2018%' AND SIGNO=1");
    if (rs.isBeforeFirst()) {
      while (rs.next())
      {
        this.f.setCveClie(rs.getString(1));
        this.f.setNoFactura(rs.getString(2));
        DecimalFormat imp = new DecimalFormat("#.##");
        imp.setRoundingMode(RoundingMode.CEILING);
        this.f.setImporte(new Double(imp.format(rs.getDouble(3))));
        this.f.setFechaApli(rs.getDate(4));
        this.f.setNumMoned(Integer.valueOf(rs.getInt(5)));
        this.f.setTcambio(Double.valueOf(rs.getDouble(6)));
        DecimalFormat impExt = new DecimalFormat("#.##");
        impExt.setRoundingMode(RoundingMode.CEILING);
        this.f.setImpmonExt(new Double(impExt.format(rs.getDouble(7))));
        this.f.setStrcvevend(rs.getString(8));
        Date fecha = new Date();
        this.f.setFechaIngreso(fecha);
        this.f.setNuevoImporte(new Double(impExt.format(rs.getDouble(7))));
        this.f.setCompletado(Boolean.FALSE);
        this.f.setProcesado(Boolean.FALSE);
        this.f.setPagoParcial(Boolean.FALSE);
        this.f.setTipoPago("Transferencia");
        this.f.setSaldo(new Double(impExt.format(rs.getDouble(7))));
        this.f.setProParcial(Boolean.FALSE);
        Conectar();
        Statement statement = getCn().createStatement();
        ResultSet resultset = statement.executeQuery("SELECT * FROM cuenm01 WHERE  NO_FACTURA='" + this.f.getNoFactura() + "'");
        if (!resultset.isBeforeFirst())
        {
          ConectarSAE();
          Statement stVen = getCnSAE().createStatement();
          ResultSet rsVen = stVen.executeQuery("SELECT NOMBRE FROM VEND01 WHERE CVE_VEND='" + this.f.getStrcvevend() + "'");
          if (rsVen.isBeforeFirst()) {
            while (rsVen.next()) {
              this.f.setNombreVend(rsVen.getString(1));
            }
          }
          Statement stClie = getCnSAE().createStatement();
          ResultSet rsClie = stClie.executeQuery("SELECT NOMBRE, RFC FROM CLIE01 WHERE CLAVE='" + this.f.getCveClie() + "'");
          if (rsClie.isBeforeFirst()) {
            while (rsClie.next())
            {
              this.f.setNombreClie(rsClie.getString(1));
              this.f.setRfc(rsClie.getString(2));
            }
          }
          CerrarSAE();
          CuenM01Dao fDao = new CuenM01DaoImpl();
          fDao.insertFactf01(this.f);
          this.f = new Cuenm01();
        }
        else
        {
          this.f = new Cuenm01();
        }
        Cerrar();
      }
    }
    CerrarSAE();
  }
  
  public void validarDatos()
    throws SQLException
  {
    for (int i = 0; i < this.lF.size(); i++) {
      try
      {
        revisarSaldos(((Cuenm01)this.lF.get(i)).getNoFactura(), ((Cuenm01)this.lF.get(i)).getNuevoMoneda().intValue());
        if (((Cuenm01)this.lF.get(i)).getNuevoImporte().doubleValue() > ((Cuenm01)this.lF.get(i)).getImpmonExt().doubleValue() - this.saldo.doubleValue())
        {
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE PAGOS", "El nuevo importe es superior al importe origen o saldo, favor de verificar"));
          RequestContext.getCurrentInstance().update("frmPrincipal:messages");
          break;
        }
      }
      catch (SQLException e)
      {
        System.out.println(e.getMessage());
      }
    }
  }
  
  public void validar()
  {
    for (int i = 0; i < this.listarParciales.size(); i++) {
      if (((Cuenm01)this.listarParciales.get(i)).getNuevoImporte().doubleValue() - 0.5D > ((Cuenm01)this.listarParciales.get(i)).getSaldo().doubleValue())
      {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE PAGOS", "El nuevo importe es superior al importe al saldo, favor de verificar"));
        RequestContext.getCurrentInstance().update("frmPrincipal:messages");
        break;
      }
    }
  }
  
  public void actualizarProceso2()
    throws SQLException, MessagingException, ParseException
  {
    this.factPagoMult = new ArrayList();
    for (int i = 0; i < this.lF.size(); i++) {
      if ((((Cuenm01)this.lF.get(i)).getProcesado().equals(Boolean.TRUE)) && (this.mulpitlePago.equals(Boolean.TRUE))) {
        this.factPagoMult.add(((Cuenm01)this.lF.get(i)).getNoFactura());
      }
    }
    ConectarSAE();
    Conectar();
    Statement stFolios = getCn().createStatement();
    stFolios.executeUpdate("INSERT INTO fpmultiple VALUES('" + this.factPagoMult.toString() + "')");
    
    Statement stBuscar = getCn().createStatement();
    ResultSet rsBuscar = stBuscar.executeQuery("SELECT ID FROM fpmultiple WHERE FACTURAS='" + this.factPagoMult.toString() + "'");
    if (rsBuscar.isBeforeFirst()) {
      while (rsBuscar.next()) {
        this.folioPago = rsBuscar.getInt(1);
      }
    }
    Statement st = getCnSAE().createStatement();
    PagosDao pDao = new PagosDaoImpl();
    for (int i = 0; i < this.lF.size(); i++) {
      if ((((Cuenm01)this.lF.get(i)).getProcesado().equals(Boolean.TRUE)) && (this.mulpitlePago.equals(Boolean.TRUE)))
      {
        if (((Cuenm01)this.lF.get(i)).getTipoPago().endsWith("Efectivo")) {
          this.tPago = 10;
        } else if (((Cuenm01)this.lF.get(i)).getTipoPago().endsWith("Cheque")) {
          this.tPago = 11;
        } else {
          this.tPago = 25;
        }
        if (Objects.equals(this.fechaPago, Boolean.TRUE))
        {
          this.now = this.fechaCierre;
          SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MMMM-dd");
          this.fechaVar = formateador.format(this.now);
          System.out.println(this.fechaVar);
          if (((Cuenm01)this.lF.get(i)).getNumMoned().equals(Integer.valueOf(2))) {
            st.executeUpdate("INSERT INTO CUEN_DET01 (CVE_CLIE,REFER,ID_MOV,NUM_CPTO,NUM_CARGO,CVE_OBS,NO_FACTURA,DOCTO,IMPORTE,FECHA_APLI,FECHA_VENC,STRCVEVEND,NUM_MONED,TCAMBIO,IMPMON_EXT,FECHAELAB,CTLPOL,TIPO_MOV,SIGNO,USUARIO,NO_PARTIDA,UUID,VERSION_SINC)VALUES ('" + 
            
              ((Cuenm01)this.lF.get(i)).getCveClie() + "', '" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "',1,'" + this.tPago + "',1,0,'" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "','" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "', " + ((Cuenm01)this.lF.get(i)).getNuevoImporte().doubleValue() * ((Cuenm01)this.lF.get(i)).getNuevoTcambio().doubleValue() + ",'" + this.fechaVar + "','" + this.fechaVar + "','" + ((Cuenm01)this.lF.get(i)).getStrcvevend() + "','" + ((Cuenm01)this.lF.get(i)).getNumMoned() + "'," + ((Cuenm01)this.lF.get(i)).getNuevoTcambio() + "," + 
              ((Cuenm01)this.lF.get(i)).getNuevoImporte() + ",'" + this.fechaVar + "',0,'A',-1,0,1,'UUID','" + this.fechaVar + "')");
          } else {
            st.executeUpdate("INSERT INTO CUEN_DET01 (CVE_CLIE,REFER,ID_MOV,NUM_CPTO,NUM_CARGO,CVE_OBS,NO_FACTURA,DOCTO,IMPORTE,FECHA_APLI,FECHA_VENC,STRCVEVEND,NUM_MONED,TCAMBIO,IMPMON_EXT,FECHAELAB,CTLPOL,TIPO_MOV,SIGNO,USUARIO,NO_PARTIDA,UUID,VERSION_SINC)VALUES ('" + 
            
              ((Cuenm01)this.lF.get(i)).getCveClie() + "', '" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "',1,'" + this.tPago + "',1,0,'" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "','" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "', " + ((Cuenm01)this.lF.get(i)).getNuevoImporte() + ",'" + this.fechaVar + "','" + this.fechaVar + "','" + ((Cuenm01)this.lF.get(i)).getStrcvevend() + "','" + ((Cuenm01)this.lF.get(i)).getNumMoned() + "'," + ((Cuenm01)this.lF.get(i)).getNuevoTcambio() + "," + 
              ((Cuenm01)this.lF.get(i)).getNuevoImporte() + ",'" + this.fechaVar + "',0,'A',-1,0,1,'UUID','" + this.fechaVar + "')");
          }
        }
        else if (((Cuenm01)this.lF.get(i)).getNumMoned().equals(Integer.valueOf(2)))
        {
          st.executeUpdate("INSERT INTO CUEN_DET01 (CVE_CLIE,REFER,ID_MOV,NUM_CPTO,NUM_CARGO,CVE_OBS,NO_FACTURA,DOCTO,IMPORTE,FECHA_APLI,FECHA_VENC,STRCVEVEND,NUM_MONED,TCAMBIO,IMPMON_EXT,FECHAELAB,CTLPOL,TIPO_MOV,SIGNO,USUARIO,NO_PARTIDA,UUID,VERSION_SINC)VALUES ('" + 
          
            ((Cuenm01)this.lF.get(i)).getCveClie() + "', '" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "',1,'" + this.tPago + "',1,0,'" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "','" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "', " + ((Cuenm01)this.lF.get(i)).getNuevoImporte().doubleValue() * ((Cuenm01)this.lF.get(i)).getNuevoTcambio().doubleValue() + ",GETDATE(),GETDATE(),'" + ((Cuenm01)this.lF.get(i)).getStrcvevend() + "','" + ((Cuenm01)this.lF.get(i)).getNumMoned() + "'," + ((Cuenm01)this.lF.get(i)).getNuevoTcambio() + "," + 
            ((Cuenm01)this.lF.get(i)).getNuevoImporte() + ",GETDATE(),0,'A',-1,0,1,'UUID',GETDATE())");
        }
        else
        {
          st.executeUpdate("INSERT INTO CUEN_DET01 (CVE_CLIE,REFER,ID_MOV,NUM_CPTO,NUM_CARGO,CVE_OBS,NO_FACTURA,DOCTO,IMPORTE,FECHA_APLI,FECHA_VENC,STRCVEVEND,NUM_MONED,TCAMBIO,IMPMON_EXT,FECHAELAB,CTLPOL,TIPO_MOV,SIGNO,USUARIO,NO_PARTIDA,UUID,VERSION_SINC)VALUES ('" + 
          
            ((Cuenm01)this.lF.get(i)).getCveClie() + "', '" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "',1,'" + this.tPago + "',1,0,'" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "','" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "', " + ((Cuenm01)this.lF.get(i)).getNuevoImporte() + ",GETDATE(),GETDATE(),'" + ((Cuenm01)this.lF.get(i)).getStrcvevend() + "','" + ((Cuenm01)this.lF.get(i)).getNumMoned() + "'," + ((Cuenm01)this.lF.get(i)).getNuevoTcambio() + "," + 
            ((Cuenm01)this.lF.get(i)).getNuevoImporte() + ",GETDATE(),0,'A',-1,0,1,'UUID',GETDATE())");
        }
        this.p.setNoFactura(((Cuenm01)this.lF.get(i)).getNoFactura());
        
        buscarMonedaAnterior(((Cuenm01)this.lF.get(i)).getNoFactura());
        if ((this.monedaAnterior == 2) && (((Cuenm01)this.lF.get(i)).getNumMoned().equals(Integer.valueOf(2)))) {
          this.p.setImporte(Double.valueOf(((Cuenm01)this.lF.get(i)).getNuevoImporte().doubleValue() * ((Cuenm01)this.lF.get(i)).getNuevoTcambio().doubleValue()));
        } else if ((this.monedaAnterior == 1) && (((Cuenm01)this.lF.get(i)).getNumMoned().equals(Integer.valueOf(2)))) {
          this.p.setImporte(Double.valueOf(((Cuenm01)this.lF.get(i)).getNuevoImporte().doubleValue() * ((Cuenm01)this.lF.get(i)).getNuevoTcambio().doubleValue()));
        } else if ((this.monedaAnterior == 2) && (((Cuenm01)this.lF.get(i)).getNumMoned().equals(Integer.valueOf(1)))) {
          this.p.setImporte(((Cuenm01)this.lF.get(i)).getNuevoImporte());
        } else if ((this.monedaAnterior == 1) && (((Cuenm01)this.lF.get(i)).getNumMoned().equals(Integer.valueOf(1)))) {
          this.p.setImporte(((Cuenm01)this.lF.get(i)).getNuevoImporte());
        }
        this.p.setTcambio(((Cuenm01)this.lF.get(i)).getNuevoTcambio());
        this.p.setMoneda(((Cuenm01)this.lF.get(i)).getNumMoned());
        if (Objects.equals(this.fechaPago, Boolean.TRUE)) {
          this.p.setFechaPago(this.fechaCierre);
        } else {
          this.p.setFechaPago(((Cuenm01)this.lF.get(i)).getFechaPago());
        }
        this.p.setPagoMultiple(Integer.valueOf(this.folioPago));
        this.p.setProcesado(Boolean.FALSE);
        this.p.setBanco(this.f.getBanco());
        this.p.setDepto(((Cuenm01)this.lF.get(i)).getDepto());
        this.p.setEstado("P");
        buscarSubCuenta(((Cuenm01)this.lF.get(i)).getNombreClie().toUpperCase());
        this.p.setSubcuenta(this.subcta);
        this.p.setCtaclientesap("");
        if ((this.monedaAnterior == 2) && (((Cuenm01)this.lF.get(i)).getNumMoned().equals(Integer.valueOf(2)))) {
          this.p.setImporteusd(((Cuenm01)this.lF.get(i)).getNuevoImporte());
        } else if ((this.monedaAnterior == 1) && (((Cuenm01)this.lF.get(i)).getNumMoned().equals(Integer.valueOf(2)))) {
          this.p.setImporteusd(((Cuenm01)this.lF.get(i)).getNuevoImporte());
        } else if ((this.monedaAnterior == 2) && (((Cuenm01)this.lF.get(i)).getNumMoned().equals(Integer.valueOf(1)))) {
          this.p.setImporteusd(Double.valueOf(((Cuenm01)this.lF.get(i)).getNuevoImporte().doubleValue() / ((Cuenm01)this.lF.get(i)).getNuevoTcambio().doubleValue()));
        } else if ((this.monedaAnterior == 1) && (((Cuenm01)this.lF.get(i)).getNumMoned().equals(Integer.valueOf(1)))) {
          this.p.setImporteusd(Double.valueOf(((Cuenm01)this.lF.get(i)).getNuevoImporte().doubleValue() / ((Cuenm01)this.lF.get(i)).getNuevoTcambio().doubleValue()));
        }
        this.p.setPagoMultiple(Integer.valueOf(this.folioPago));
        this.p.setCliente(((Cuenm01)this.lF.get(i)).getNombreClie());
        buscarSubCtaBancos();
        this.p.setSubctabancos(this.subctabancos);
        this.p.setStrcvevend(((Cuenm01)this.lF.get(i)).getStrcvevend());
        this.p.setTipopago(this.tPago);
        pDao.insertFactf01(this.p);
        if (!((Cuenm01)this.lF.get(i)).getNuevoImporte().equals(((Cuenm01)this.lF.get(i)).getImpmonExt())) {
          this.pagoParcial = Boolean.TRUE;
        } else {
          this.pagoParcial = Boolean.FALSE;
        }
        if (Objects.equals(this.fechaPago, Boolean.TRUE)) {
          this.now = this.fechaCierre;
        } else {
          this.now = ((Cuenm01)this.lF.get(i)).getFechaPago();
        }
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        this.fechaVar = formateador.format(this.now);
        
        this.vend = ((Cuenm01)this.lF.get(i)).getStrcvevend();
        this.tcam = ((Cuenm01)this.lF.get(i)).getNuevoTcambio();
        this.tipoTrans = ((Cuenm01)this.lF.get(i)).getTipoPago();
        
        this.saldo = Double.valueOf(0.0D);
        revisarSaldos(((Cuenm01)this.lF.get(i)).getNoFactura(), ((Cuenm01)this.lF.get(i)).getNumMoned().intValue());
        if (((Cuenm01)this.lF.get(i)).getImpmonExt().equals(this.saldo)) {
          this.pro = Boolean.TRUE;
        } else {
          this.pro = Boolean.FALSE;
        }
        if (this.monedaAnterior == 2)
        {
          PreparedStatement ps = getCn().prepareStatement("UPDATE cuenm01 SET PROCESADO='" + this.pro + "', PAGO_PARCIAL='" + this.pagoParcial + "', NUEVO_IMPORTE='" + ((Cuenm01)this.lF.get(i)).getNuevoImporte() + "', NUEVO_TCAMBIO='" + ((Cuenm01)this.lF.get(i)).getNuevoTcambio() + "', FECHA_ENVIO=GETDATE(), AVISO=2, BANCO='" + this.f.getBanco() + "', PAGO_MULTIPLE='" + this.folioPago + "', DEPTO='" + ((Cuenm01)this.lF.get(i)).getDepto() + "',SALDO='" + (((Cuenm01)this.lF.get(i)).getImpmonExt().doubleValue() - this.saldo.doubleValue()) + "', FECHA_PAGO=CONVERT(VARCHAR,'" + this.fechaVar + "',103) WHERE NO_FACTURA='" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "'");
          ps.executeUpdate();
        }
        else
        {
          PreparedStatement ps = getCn().prepareStatement("UPDATE cuenm01 SET PROCESADO='" + this.pro + "', PAGO_PARCIAL='" + this.pagoParcial + "', NUEVO_IMPORTE='" + ((Cuenm01)this.lF.get(i)).getNuevoImporte() + "', NUEVO_TCAMBIO='" + ((Cuenm01)this.lF.get(i)).getNuevoTcambio() + "', FECHA_ENVIO=GETDATE(), AVISO=2, BANCO='" + this.f.getBanco() + "', PAGO_MULTIPLE='" + this.folioPago + "', DEPTO='" + ((Cuenm01)this.lF.get(i)).getDepto() + "',SALDO='" + (((Cuenm01)this.lF.get(i)).getImporte().doubleValue() - this.saldo.doubleValue()) + "', FECHA_PAGO=CONVERT(VARCHAR,'" + this.fechaVar + "',103) WHERE NO_FACTURA='" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "'");
          ps.executeUpdate();
        }
      }
    }
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE PAGOS", "REGISTRO DE PAGOS COMPLETADO"));
    RequestContext.getCurrentInstance().update("frmPrincipal:mensaje");
    resetearTabla();
    RequestContext.getCurrentInstance().update("@all");
    listarFacturas();
    RequestContext.getCurrentInstance().update("frmPrincipal:tblPagos");
    CerrarSAE();
    Cerrar();
  }
  
  public void actualizarProceso()
    throws SQLException, MessagingException
  {
    if (this.mulpitlePago.equals(Boolean.TRUE))
    {
      this.Impmxn = Double.valueOf(0.0D);
      this.Impusd = Double.valueOf(0.0D);
      this.listaFacturas = new ArrayList();
      for (int i = 0; i < this.lF.size(); i++) {
        if ((((Cuenm01)this.lF.get(i)).getProcesado().equals(Boolean.TRUE)) && (this.mulpitlePago.equals(Boolean.TRUE)) && (((Cuenm01)this.lF.get(i)).getNuevoTcambio() != null))
        {
          FacturaProcesoBean localFacturaProcesoBean;
          if (((Cuenm01)this.lF.get(i)).getNumMoned().equals(Integer.valueOf(1)))
          {
            localFacturaProcesoBean = this;
            localFacturaProcesoBean.Impmxn = Double.valueOf(localFacturaProcesoBean.Impmxn.doubleValue() + ((Cuenm01)this.lF.get(i)).getNuevoImporte().doubleValue());
          }
          else
          {
            localFacturaProcesoBean = this;
            localFacturaProcesoBean.Impmxn = Double.valueOf(localFacturaProcesoBean.Impmxn.doubleValue() + ((Cuenm01)this.lF.get(i)).getNuevoImporte().doubleValue() * ((Cuenm01)this.lF.get(i)).getNuevoTcambio().doubleValue());
          }
          if (((Cuenm01)this.lF.get(i)).getNumMoned().equals(Integer.valueOf(2)))
          {
            localFacturaProcesoBean = this;
            localFacturaProcesoBean.Impusd = Double.valueOf(localFacturaProcesoBean.Impusd.doubleValue() + ((Cuenm01)this.lF.get(i)).getNuevoImporte().doubleValue());
          }
          else
          {
            localFacturaProcesoBean = this;
            localFacturaProcesoBean.Impusd = Double.valueOf(localFacturaProcesoBean.Impusd.doubleValue() + ((Cuenm01)this.lF.get(i)).getNuevoImporte().doubleValue() / ((Cuenm01)this.lF.get(i)).getNuevoTcambio().doubleValue());
          }
          this.listaFacturas.add(((Cuenm01)this.lF.get(i)).getNoFactura());
        }
      }
      this.facturas = this.listaFacturas.toString();
      RequestContext.getCurrentInstance().update("frmPrincipal:dlg");
      RequestContext.getCurrentInstance().execute("PF('dlg1').show()");
    }
    else if (this.f.getBanco() == null)
    {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE PAGOS", "Por favor selecciona un banco"));
    }
    else
    {
      this.factPagoMult = new ArrayList();
      
      PagosDao pDao = new PagosDaoImpl();
      for (int i = 0; i < this.lF.size(); i++) {
        if (((Cuenm01)this.lF.get(i)).getProcesado().equals(Boolean.TRUE))
        {
          Conectar();
          if (!((Cuenm01)this.lF.get(i)).getNuevoImporte().equals(((Cuenm01)this.lF.get(i)).getImpmonExt())) {
            this.pagoParcial = Boolean.TRUE;
          } else {
            this.pagoParcial = Boolean.FALSE;
          }
          if (((Cuenm01)this.lF.get(i)).getTipoPago().endsWith("Efectivo")) {
            this.tPago = 10;
          } else if (((Cuenm01)this.lF.get(i)).getTipoPago().endsWith("Cheque")) {
            this.tPago = 11;
          } else {
            this.tPago = 25;
          }
          ConectarSAE();
          Conectar();
          Statement stFolios = getCn().createStatement();
          stFolios.executeUpdate("INSERT INTO fpmultiple VALUES('" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "')");
          Statement stBuscar = getCn().createStatement();
          ResultSet rsBuscar = stBuscar.executeQuery("SELECT ID FROM fpmultiple WHERE FACTURAS='" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "'");
          if (rsBuscar.isBeforeFirst()) {
            while (rsBuscar.next()) {
              this.folioPago = rsBuscar.getInt(1);
            }
          }
          this.p.setNoFactura(((Cuenm01)this.lF.get(i)).getNoFactura());
          
          buscarMonedaAnterior(((Cuenm01)this.lF.get(i)).getNoFactura());
          if ((this.monedaAnterior == 2) && (((Cuenm01)this.lF.get(i)).getNumMoned().equals(Integer.valueOf(2)))) {
            this.p.setImporte(Double.valueOf(((Cuenm01)this.lF.get(i)).getNuevoImporte().doubleValue() * ((Cuenm01)this.lF.get(i)).getNuevoTcambio().doubleValue()));
          } else if ((this.monedaAnterior == 1) && (((Cuenm01)this.lF.get(i)).getNumMoned().equals(Integer.valueOf(2)))) {
            this.p.setImporte(Double.valueOf(((Cuenm01)this.lF.get(i)).getNuevoImporte().doubleValue() * ((Cuenm01)this.lF.get(i)).getNuevoTcambio().doubleValue()));
          } else if ((this.monedaAnterior == 2) && (((Cuenm01)this.lF.get(i)).getNumMoned().equals(Integer.valueOf(1)))) {
            this.p.setImporte(((Cuenm01)this.lF.get(i)).getNuevoImporte());
          } else if ((this.monedaAnterior == 1) && (((Cuenm01)this.lF.get(i)).getNumMoned().equals(Integer.valueOf(1)))) {
            this.p.setImporte(((Cuenm01)this.lF.get(i)).getNuevoImporte());
          }
          this.montoMXN = this.p.getImporte();
          
          this.p.setTcambio(((Cuenm01)this.lF.get(i)).getNuevoTcambio());
          this.p.setMoneda(((Cuenm01)this.lF.get(i)).getNumMoned());
          if (Objects.equals(this.fechaPago, Boolean.TRUE)) {
            this.p.setFechaPago(this.fechaCierre);
          } else {
            this.p.setFechaPago(((Cuenm01)this.lF.get(i)).getFechaPago());
          }
          this.p.setProcesado(Boolean.FALSE);
          this.p.setBanco(this.f.getBanco());
          this.p.setDepto(((Cuenm01)this.lF.get(i)).getDepto());
          this.p.setEstado("P");
          buscarSubCuenta(((Cuenm01)this.lF.get(i)).getNombreClie().toUpperCase());
          this.p.setSubcuenta(this.subcta);
          this.p.setCtaclientesap("");
          if ((this.monedaAnterior == 2) && (((Cuenm01)this.lF.get(i)).getNumMoned().equals(Integer.valueOf(2)))) {
            this.p.setImporteusd(((Cuenm01)this.lF.get(i)).getNuevoImporte());
          } else if ((this.monedaAnterior == 1) && (((Cuenm01)this.lF.get(i)).getNumMoned().equals(Integer.valueOf(2)))) {
            this.p.setImporteusd(((Cuenm01)this.lF.get(i)).getNuevoImporte());
          } else if ((this.monedaAnterior == 2) && (((Cuenm01)this.lF.get(i)).getNumMoned().equals(Integer.valueOf(1)))) {
            this.p.setImporteusd(Double.valueOf(((Cuenm01)this.lF.get(i)).getNuevoImporte().doubleValue() / ((Cuenm01)this.lF.get(i)).getNuevoTcambio().doubleValue()));
          } else if ((this.monedaAnterior == 1) && (((Cuenm01)this.lF.get(i)).getNumMoned().equals(Integer.valueOf(1)))) {
            this.p.setImporteusd(Double.valueOf(((Cuenm01)this.lF.get(i)).getNuevoImporte().doubleValue() / ((Cuenm01)this.lF.get(i)).getNuevoTcambio().doubleValue()));
          }
          this.montoUSD = this.p.getImporteusd();
          
          this.p.setPagoMultiple(Integer.valueOf(this.folioPago));
          this.p.setCliente(((Cuenm01)this.lF.get(i)).getNombreClie());
          buscarSubCtaBancos();
          this.p.setSubctabancos(this.subctabancos);
          this.p.setStrcvevend(((Cuenm01)this.lF.get(i)).getStrcvevend());
          this.p.setTipopago(this.tPago);
          pDao.insertFactf01(this.p);
          if (Objects.equals(this.fechaPago, Boolean.TRUE)) {
            this.now = this.fechaCierre;
          } else {
            this.now = ((Cuenm01)this.lF.get(i)).getFechaPago();
          }
          SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
          this.fechaVar = formateador.format(this.now);
          
          revisarSaldos(((Cuenm01)this.lF.get(i)).getNoFactura(), ((Cuenm01)this.lF.get(i)).getNumMoned().intValue());
          if (((Cuenm01)this.lF.get(i)).getImpmonExt().equals(this.saldo)) {
            this.pro = Boolean.TRUE;
          } else {
            this.pro = Boolean.FALSE;
          }
          if (this.monedaAnterior == 1)
          {
            PreparedStatement ps = getCn().prepareStatement("UPDATE cuenm01 SET PROCESADO='" + this.pro + "', PAGO_PARCIAL='" + this.pagoParcial + "', NUEVO_IMPORTE='" + ((Cuenm01)this.lF.get(i)).getNuevoImporte() + "', NUEVO_TCAMBIO='" + ((Cuenm01)this.lF.get(i)).getNuevoTcambio() + "', FECHA_ENVIO=GETDATE(), AVISO=2, BANCO='" + this.f.getBanco() + "', PAGO_MULTIPLE='" + this.folioPago + "', DEPTO='" + ((Cuenm01)this.lF.get(i)).getDepto() + "',SALDO='" + (((Cuenm01)this.lF.get(i)).getImporte().doubleValue() - this.saldo.doubleValue()) + "', FECHA_PAGO=CONVERT(VARCHAR,'" + this.fechaVar + "',103) WHERE NO_FACTURA='" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "'");
            ps.executeUpdate();
          }
          else
          {
            PreparedStatement ps = getCn().prepareStatement("UPDATE cuenm01 SET PROCESADO='" + this.pro + "', PAGO_PARCIAL='" + this.pagoParcial + "', NUEVO_IMPORTE='" + ((Cuenm01)this.lF.get(i)).getNuevoImporte() + "', NUEVO_TCAMBIO='" + ((Cuenm01)this.lF.get(i)).getNuevoTcambio() + "', FECHA_ENVIO=GETDATE(), AVISO=2, BANCO='" + this.f.getBanco() + "', PAGO_MULTIPLE='" + this.folioPago + "', DEPTO='" + ((Cuenm01)this.lF.get(i)).getDepto() + "',SALDO='" + (((Cuenm01)this.lF.get(i)).getImpmonExt().doubleValue() - this.saldo.doubleValue()) + "', FECHA_PAGO=CONVERT(VARCHAR,'" + this.fechaVar + "',103) WHERE NO_FACTURA='" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "'");
            ps.executeUpdate();
          }
          ConectarSAE();
          Statement stCue = getCnSAE().createStatement();
          if (Objects.equals(this.fechaPago, Boolean.TRUE))
          {
            this.now = this.fechaCierre;
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MMMM-dd");
            this.fechaVar = formato.format(this.now);
            System.out.println(this.fechaVar);
            if (((Cuenm01)this.lF.get(i)).getNumMoned().equals(Integer.valueOf(2))) {
              stCue.executeUpdate("INSERT INTO CUEN_DET01 (CVE_CLIE,REFER,ID_MOV,NUM_CPTO,NUM_CARGO,CVE_OBS,NO_FACTURA,DOCTO,IMPORTE,FECHA_APLI,FECHA_VENC,STRCVEVEND,NUM_MONED,TCAMBIO,IMPMON_EXT,FECHAELAB,CTLPOL,TIPO_MOV,SIGNO,USUARIO,NO_PARTIDA,UUID,VERSION_SINC)VALUES ('" + 
              
                ((Cuenm01)this.lF.get(i)).getCveClie() + "', '" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "',1,'" + this.tPago + "',1,0,'" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "','" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "', " + ((Cuenm01)this.lF.get(i)).getNuevoImporte().doubleValue() * ((Cuenm01)this.lF.get(i)).getNuevoTcambio().doubleValue() + ",'" + this.fechaVar + "','" + this.fechaVar + "','" + ((Cuenm01)this.lF.get(i)).getStrcvevend() + "','" + ((Cuenm01)this.lF.get(i)).getNumMoned() + "'," + ((Cuenm01)this.lF.get(i)).getNuevoTcambio() + "," + 
                ((Cuenm01)this.lF.get(i)).getNuevoImporte() + ",'" + this.fechaVar + "',0,'A',-1,0,1,'UUID','" + this.fechaVar + "')");
            } else {
              stCue.executeUpdate("INSERT INTO CUEN_DET01 (CVE_CLIE,REFER,ID_MOV,NUM_CPTO,NUM_CARGO,CVE_OBS,NO_FACTURA,DOCTO,IMPORTE,FECHA_APLI,FECHA_VENC,STRCVEVEND,NUM_MONED,TCAMBIO,IMPMON_EXT,FECHAELAB,CTLPOL,TIPO_MOV,SIGNO,USUARIO,NO_PARTIDA,UUID,VERSION_SINC)VALUES ('" + 
              
                ((Cuenm01)this.lF.get(i)).getCveClie() + "', '" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "',1,'" + this.tPago + "',1,0,'" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "','" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "', " + ((Cuenm01)this.lF.get(i)).getNuevoImporte() + ",'" + this.fechaVar + "','" + this.fechaVar + "','" + ((Cuenm01)this.lF.get(i)).getStrcvevend() + "','" + ((Cuenm01)this.lF.get(i)).getNumMoned() + "'," + ((Cuenm01)this.lF.get(i)).getNuevoTcambio() + "," + 
                ((Cuenm01)this.lF.get(i)).getNuevoImporte() + ",'" + this.fechaVar + "',0,'A',-1,0,1,'UUID','" + this.fechaVar + "')");
            }
          }
          else if (((Cuenm01)this.lF.get(i)).getNumMoned().equals(Integer.valueOf(2)))
          {
            stCue.executeUpdate("INSERT INTO CUEN_DET01 (CVE_CLIE,REFER,ID_MOV,NUM_CPTO,NUM_CARGO,CVE_OBS,NO_FACTURA,DOCTO,IMPORTE,FECHA_APLI,FECHA_VENC,STRCVEVEND,NUM_MONED,TCAMBIO,IMPMON_EXT,FECHAELAB,CTLPOL,TIPO_MOV,SIGNO,USUARIO,NO_PARTIDA,UUID,VERSION_SINC)VALUES ('" + 
            
              ((Cuenm01)this.lF.get(i)).getCveClie() + "', '" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "',1,'" + this.tPago + "',1,0,'" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "','" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "', " + ((Cuenm01)this.lF.get(i)).getNuevoImporte().doubleValue() * ((Cuenm01)this.lF.get(i)).getNuevoTcambio().doubleValue() + ",GETDATE(),GETDATE(),'" + ((Cuenm01)this.lF.get(i)).getStrcvevend() + "','" + ((Cuenm01)this.lF.get(i)).getNumMoned() + "'," + ((Cuenm01)this.lF.get(i)).getNuevoTcambio() + "," + 
              ((Cuenm01)this.lF.get(i)).getNuevoImporte() + ",GETDATE(),0,'A',-1,0,1,'UUID',GETDATE())");
          }
          else
          {
            stCue.executeUpdate("INSERT INTO CUEN_DET01 (CVE_CLIE,REFER,ID_MOV,NUM_CPTO,NUM_CARGO,CVE_OBS,NO_FACTURA,DOCTO,IMPORTE,FECHA_APLI,FECHA_VENC,STRCVEVEND,NUM_MONED,TCAMBIO,IMPMON_EXT,FECHAELAB,CTLPOL,TIPO_MOV,SIGNO,USUARIO,NO_PARTIDA,UUID,VERSION_SINC)VALUES ('" + 
            
              ((Cuenm01)this.lF.get(i)).getCveClie() + "', '" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "',1,'" + this.tPago + "',1,0,'" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "','" + ((Cuenm01)this.lF.get(i)).getNoFactura() + "', " + ((Cuenm01)this.lF.get(i)).getNuevoImporte() + ",GETDATE(),GETDATE(),'" + ((Cuenm01)this.lF.get(i)).getStrcvevend() + "','" + ((Cuenm01)this.lF.get(i)).getNumMoned() + "'," + ((Cuenm01)this.lF.get(i)).getNuevoTcambio() + "," + 
              ((Cuenm01)this.lF.get(i)).getNuevoImporte() + ",GETDATE(),0,'A',-1,0,1,'UUID',GETDATE())");
          }
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE PAGOS", "REGISTRO DE PAGOS COMPLETADO"));
          RequestContext.getCurrentInstance().update("frmPrincipal:mensaje");
        }
      }
      resetearTabla();
      RequestContext.getCurrentInstance().update("@all");
      listarFacturas();
      RequestContext.getCurrentInstance().update("frmPrincipal:tblPagos");
      Cerrar();
      CerrarSAE();
    }
  }
  
  public void sumarImportes()
    throws InterruptedException
  {
    this.listaImportes = new ArrayList();
    
    RequestContext.getCurrentInstance().update("importes:dlg");
  }
  
  public void enviarCorreo(String factura, Double montomxn, String banco, String clave, Double montousd, Double tipCam, String metodo)
    throws MessagingException
  {
    this.listaCorreos = new ArrayList();
    this.listaVendedor = new ArrayList();
    
    CorreosDao cDao = new CorreosDaoImpl();
    this.listaCorreos = cDao.listaCorreos(clave);
    
    VendedorDao vDao = new VendedorDaoImpl();
    this.listaVendedor = vDao.listaVendedor(clave);
    this.hoy = Calendar.getInstance();
    this.dia = this.hoy.get(7);
    this.hoy.add(5, 10);
    SimpleDateFormat formateador = new SimpleDateFormat("dd-MMMM-yyyy");
    this.fecPago = formateador.format(this.hoy.getTime());
    Properties props = new Properties();
    props.put("mail.smtp.host", "p3plcpnl0612.prod.phx3.secureserver.net");
    props.setProperty("mail.smtp.starttls.enable", "true");
    props.setProperty("mail.smtp.port", "587");
    props.setProperty("mail.smtp.user", "alertas1@insoftec.com");
    props.setProperty("mail.smtp.auth", "true");
    Session session = Session.getDefaultInstance(props, null);
    session.setDebug(false);
    DecimalFormat formatterMXN = new DecimalFormat("####,###,###.00");
    DecimalFormat formatterUSD = new DecimalFormat("####,###,###.00");
    
    BodyPart texto = new MimeBodyPart();
    texto.setContent("<html><head><title></title></head><body><table width='678' height='315' border='0' bordercolor='#0000FF' bgcolor='#FFFFFF'><tr><td height='10' colspan='3' bordercolor='#FFFFFF'><img src='cid:azul' width='20%'/></td></tr><tr><td colspan='3' bordercolor='#FFFFFF'><p align='left' style='font-family:calibri; font-size:17px'><font color='#086A87'>Se ha registrado el pago de la siguiente factura: </font><br><br><font color='#17202a'>Factura no: </font><i><font color='#086A87'>" + factura + " </font></i> <br><font color='#17202a'>Monto pagado MXN:</font> <font color='#086A87'><i>$" + formatterMXN
    
      .format(montomxn) + " </i></font><br><font color='#17202a'>Monto pagado USD:</font> <font color='#086A87'><i>$" + formatterUSD
      .format(montousd) + " </i></font><br><font color='#17202a'>Tipo de cambio:</font> <font color='#086A87'><i>$" + tipCam + " </i></font><br><font color='#17202a'>Método de pago:</font> <font color='#086A87'><i>" + metodo + " </i></font><br><font color='#17202a'>Banco:</font> <font color='#086A87'><i>" + banco + "</i></font><br><br><b><font color='#000000'>Emitir el complemento de pago antes de: " + this.fecPago + ". </font></b><br></tr><tr><td width='425' bordercolor='#FFFFFF'><p align='left' style='font-family:calibri; font-size:17px'><br><font color='#17202a'>Sistema de Gastos | </font><font color='#E60013'>Marubeni M&eacute;xico, S.A. de C.V.</font><br><a href='https://portal.marubeni.com.mx' target='_blank'><img src='cid:image' width='45%'/></a></td><td width='122' bordercolor='#FFFFFF'></td><td width='222' rowspan='2' bordercolor='#FFFFFF'></td></tr><tr><td colspan='2' bordercolor='#17202a'><br><br><p align='center' style='font-family:calibri; font-size:15px'><font color='#086A87'><br> Mensaje enviado desde el Sistema de Pagos Marubeni.</font></p></td></tr></table></body></html>", "text/html");
    
    MimeMultipart multiParte = new MimeMultipart();
    BodyPart imagen = new MimeBodyPart();
    BodyPart imagen2 = new MimeBodyPart();
    DataSource fds = new FileDataSource("C:\\img\\marubeni-logo.png");
    DataSource fds1 = new FileDataSource("C:\\img\\azul.png");
    imagen.setDataHandler(new DataHandler(fds));
    imagen2.setDataHandler(new DataHandler(fds1));
    imagen.setHeader("Content-ID", "<image>");
    imagen2.setHeader("Content-ID", "<azul>");
    
    multiParte.addBodyPart(texto);
    
    multiParte.addBodyPart(imagen);
    multiParte.addBodyPart(imagen2);
    
    MimeMessage message = new MimeMessage(session);
    
    message.setFrom(new InternetAddress("alertas1@insoftec.com"));
    for (int i = 0; i < this.listaVendedor.size(); i++) {
      message.addRecipient(Message.RecipientType.TO, new InternetAddress((String)this.listaVendedor.get(i)));
    }
    String address = this.listaCorreos.toString();
    String addressA = address.replace("[", "");
    String addressB = addressA.replace("]", "");
    String[] recipientList = addressB.split(",");
    InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
    int counter = 0;
    for (String recipient : recipientList)
    {
      recipientAddress[counter] = new InternetAddress(recipient.trim());
      counter++;
    }
    message.addRecipients(Message.RecipientType.CC, recipientAddress);
    message.addRecipients(Message.RecipientType.BCC, "alertas1@insoftec.com");
    
    message.setSubject("Sistema de Pagos Marubeni");
    
    message.setContent(multiParte);
    
    Transport t = session.getTransport("smtp");
    t.connect("alertas1@insoftec.com", "Pw*Tf+56");
    t.sendMessage(message, message.getAllRecipients());
    t.close();
    this.montoMXN = Double.valueOf(0.0D);
    this.montoUSD = Double.valueOf(0.0D);
  }
  
  public void onRowEdit(RowEditEvent event)
  {
    Cuenm01 dato = (Cuenm01)event.getObject();
    if (dato.getNuevoImporte().doubleValue() > dato.getImporte().doubleValue()) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE PAGOS", "Importe incorrecto"));
    }
  }
  
  public void onRowCancel(RowEditEvent event)
  {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE PAGOS", "Actualización cancelada"));
  }
  
  public void revisarSaldos(String factura, int moneda)
    throws SQLException
  {
    Conectar();
    Statement st = getCn().createStatement();
    ResultSet rs = st.executeQuery("SELECT SUM(IMPORTEUSD) AS IMPORTEUSD, SUM(IMPORTE) AS IMPORTE FROM pagos WHERE NO_FACTURA='" + factura + "'");
    if (!rs.isBeforeFirst())
    {
      this.saldo = Double.valueOf(0.0D);
    }
    else
    {
      if (this.monedaAnterior == 1) {
        while (rs.next()) {
          this.saldo = Double.valueOf(rs.getDouble("IMPORTE"));
        }
      }
      while (rs.next()) {
        this.saldo = Double.valueOf(rs.getDouble("IMPORTEUSD"));
      }
    }
  }
  
  public void buscarSubCuenta(String cliente)
    throws SQLException
  {
    Conectar();
    PreparedStatement ps = getCn().prepareStatement("SELECT SUBCUENTA FROM catalogo WHERE CLIENTE='" + cliente + "'");
    ResultSet rs = ps.executeQuery();
    if (!rs.isBeforeFirst()) {
      this.subcta = "No econtrada";
    } else {
      while (rs.next()) {
        this.subcta = rs.getString("SUBCUENTA");
      }
    }
  }
  
  public void buscarSubCtaBancos()
    throws SQLException
  {
    Conectar();
    PreparedStatement ps = getCn().prepareStatement("SELECT SUBCUENTA FROM bancos WHERE NOMBRE LIKE '%" + this.f.getBanco() + "%'");
    ResultSet rs = ps.executeQuery();
    if (!rs.isBeforeFirst()) {
      this.subctabancos = "No encontrada";
    } else {
      while (rs.next()) {
        this.subctabancos = rs.getString("SUBCUENTA");
      }
    }
  }
  
  public void buscarMonedaAnterior(String factura)
    throws SQLException
  {
    Conectar();
    PreparedStatement ps = getCn().prepareStatement("SELECT NUM_MONED FROM cuenm01 WHERE NO_FACTURA='" + factura + "'");
    ResultSet rs = ps.executeQuery();
    if (rs.isBeforeFirst()) {
      while (rs.next()) {
        this.monedaAnterior = rs.getInt("NUM_MONED");
      }
    }
  }
  
  public void resetearTabla()
  {
    DataTable datatable = (DataTable)FacesContext.getCurrentInstance().getViewRoot().findComponent("frmPrincipal:tblPagos");
    datatable.reset();
  }
}
