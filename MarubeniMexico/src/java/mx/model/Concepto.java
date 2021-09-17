package mx.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Concepto
        implements Serializable {

    private int idConcepto;
    private String nombreConcepto;
    private BigDecimal importe;
    private BigDecimal iva;
    private BigDecimal tua;
    private String factura;
    private String uuid;
    private String rfc;
    private String nombre;
    private String estatus;
    private BigDecimal totalmxn;
    private BigDecimal totalusd;
    private String comentario;
    private String nombreUsuario;
    private String folioUsuario;
    private Date fecha;
    private String tipo;
    private String estado;
    private String rfcreceptor;
    private String nombreReceptor;
    private String tarjeta;
    private String rutaXml;
    private String rutaImagen;
    private String rutaPdf;
    private String modificarArchivo;
    private BigDecimal propina;
    private BigDecimal ish;
    private String tarjetaGasolina;
    private String departamento;
    private String lugarExpedicion;
    private String descripcion;
    private String selloCfd;
    private String selloSat;
    private String fechaTimbrado;
    private String noCertificadoSat;
    private String veruuid;
    private String noCertificado;
    private BigDecimal tipoCambio;
    private String moneda;
    private String tipoComprobante;
    private String metodoPago;
    private String formaPago;
    private BigDecimal impuestoRetenido;
    private byte[] imagen;
    private Date fechaDocumento;

    public Concepto() {
    }

    public Concepto(int idConcepto, String nombreConcepto, BigDecimal importe, BigDecimal iva, BigDecimal tua, String factura, String uuid, String rfc, String nombre, String estatus, BigDecimal totalmxn, BigDecimal totalusd, String comentario, String nombreUsuario, String folioUsuario, Date fecha, String tipo, String estado, String rfcreceptor, String nombreReceptor, String tarjeta, String rutaXml, String rutaImagen, String rutaPdf, String modificarArchivo, BigDecimal propina, BigDecimal ish, String tarjetaGasolina, String departamento, String lugarExpedicion, String descripcion, String selloCfd, String selloSat, String fechaTimbrado, String noCertificadoSat, String veruuid, String noCertificado, BigDecimal tipoCambio, String moneda, String tipoComprobante, String metodoPago, String formaPago, BigDecimal impuestoRetenido, byte[] imagen, Date fechaDocumento) {
        this.idConcepto = idConcepto;
        this.nombreConcepto = nombreConcepto;
        this.importe = importe;
        this.iva = iva;
        this.tua = tua;
        this.factura = factura;
        this.uuid = uuid;
        this.rfc = rfc;
        this.nombre = nombre;
        this.estatus = estatus;
        this.totalmxn = totalmxn;
        this.totalusd = totalusd;
        this.comentario = comentario;
        this.nombreUsuario = nombreUsuario;
        this.folioUsuario = folioUsuario;
        this.fecha = fecha;
        this.tipo = tipo;
        this.estado = estado;
        this.rfcreceptor = rfcreceptor;
        this.nombreReceptor = nombreReceptor;
        this.tarjeta = tarjeta;
        this.rutaXml = rutaXml;
        this.rutaImagen = rutaImagen;
        this.rutaPdf = rutaPdf;
        this.modificarArchivo = modificarArchivo;
        this.propina = propina;
        this.ish = ish;
        this.tarjetaGasolina = tarjetaGasolina;
        this.departamento = departamento;
        this.lugarExpedicion = lugarExpedicion;
        this.descripcion = descripcion;
        this.selloCfd = selloCfd;
        this.selloSat = selloSat;
        this.fechaTimbrado = fechaTimbrado;
        this.noCertificadoSat = noCertificadoSat;
        this.veruuid = veruuid;
        this.noCertificado = noCertificado;
        this.tipoCambio = tipoCambio;
        this.moneda = moneda;
        this.tipoComprobante = tipoComprobante;
        this.metodoPago = metodoPago;
        this.formaPago = formaPago;
        this.impuestoRetenido = impuestoRetenido;
        this.imagen = imagen;
        this.fechaDocumento = fechaDocumento;
    }

    public int getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(int idConcepto) {
        this.idConcepto = idConcepto;
    }

    public String getNombreConcepto() {
        return nombreConcepto;
    }

    public void setNombreConcepto(String nombreConcepto) {
        this.nombreConcepto = nombreConcepto;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getTua() {
        return tua;
    }

    public void setTua(BigDecimal tua) {
        this.tua = tua;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public BigDecimal getTotalmxn() {
        return totalmxn;
    }

    public void setTotalmxn(BigDecimal totalmxn) {
        this.totalmxn = totalmxn;
    }

    public BigDecimal getTotalusd() {
        return totalusd;
    }

    public void setTotalusd(BigDecimal totalusd) {
        this.totalusd = totalusd;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getFolioUsuario() {
        return folioUsuario;
    }

    public void setFolioUsuario(String folioUsuario) {
        this.folioUsuario = folioUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRfcreceptor() {
        return rfcreceptor;
    }

    public void setRfcreceptor(String rfcreceptor) {
        this.rfcreceptor = rfcreceptor;
    }

    public String getNombreReceptor() {
        return nombreReceptor;
    }

    public void setNombreReceptor(String nombreReceptor) {
        this.nombreReceptor = nombreReceptor;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getRutaXml() {
        return rutaXml;
    }

    public void setRutaXml(String rutaXml) {
        this.rutaXml = rutaXml;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getRutaPdf() {
        return rutaPdf;
    }

    public void setRutaPdf(String rutaPdf) {
        this.rutaPdf = rutaPdf;
    }

    public String getModificarArchivo() {
        return modificarArchivo;
    }

    public void setModificarArchivo(String modificarArchivo) {
        this.modificarArchivo = modificarArchivo;
    }

    public BigDecimal getPropina() {
        return propina;
    }

    public void setPropina(BigDecimal propina) {
        this.propina = propina;
    }

    public BigDecimal getIsh() {
        return ish;
    }

    public void setIsh(BigDecimal ish) {
        this.ish = ish;
    }

    public String getTarjetaGasolina() {
        return tarjetaGasolina;
    }

    public void setTarjetaGasolina(String tarjetaGasolina) {
        this.tarjetaGasolina = tarjetaGasolina;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getLugarExpedicion() {
        return lugarExpedicion;
    }

    public void setLugarExpedicion(String lugarExpedicion) {
        this.lugarExpedicion = lugarExpedicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSelloCfd() {
        return selloCfd;
    }

    public void setSelloCfd(String selloCfd) {
        this.selloCfd = selloCfd;
    }

    public String getSelloSat() {
        return selloSat;
    }

    public void setSelloSat(String selloSat) {
        this.selloSat = selloSat;
    }

    public String getFechaTimbrado() {
        return fechaTimbrado;
    }

    public void setFechaTimbrado(String fechaTimbrado) {
        this.fechaTimbrado = fechaTimbrado;
    }

    public String getNoCertificadoSat() {
        return noCertificadoSat;
    }

    public void setNoCertificadoSat(String noCertificadoSat) {
        this.noCertificadoSat = noCertificadoSat;
    }

    public String getVeruuid() {
        return veruuid;
    }

    public void setVeruuid(String veruuid) {
        this.veruuid = veruuid;
    }

    public String getNoCertificado() {
        return noCertificado;
    }

    public void setNoCertificado(String noCertificado) {
        this.noCertificado = noCertificado;
    }

    public BigDecimal getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(BigDecimal tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public BigDecimal getImpuestoRetenido() {
        return impuestoRetenido;
    }

    public void setImpuestoRetenido(BigDecimal impuestoRetenido) {
        this.impuestoRetenido = impuestoRetenido;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Date getFechaDocumento() {
        return fechaDocumento;
    }

    public void setFechaDocumento(Date fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

}
