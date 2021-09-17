package mx.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Concept
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

    public int getIdConcepto() {
        return this.idConcepto;
    }

    public void setIdConcepto(int idConcepto) {
        this.idConcepto = idConcepto;
    }

    public String getNombreConcepto() {
        return this.nombreConcepto;
    }

    public void setNombreConcepto(String nombreConcepto) {
        this.nombreConcepto = nombreConcepto;
    }

    public BigDecimal getImporte() {
        return this.importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public BigDecimal getIva() {
        return this.iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getTua() {
        return this.tua;
    }

    public void setTua(BigDecimal tua) {
        this.tua = tua;
    }

    public String getFactura() {
        return this.factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRfc() {
        return this.rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstatus() {
        return this.estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public BigDecimal getTotalmxn() {
        return this.totalmxn;
    }

    public void setTotalmxn(BigDecimal totalmxn) {
        this.totalmxn = totalmxn;
    }

    public BigDecimal getTotalusd() {
        return this.totalusd;
    }

    public void setTotalusd(BigDecimal totalusd) {
        this.totalusd = totalusd;
    }

    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getFolioUsuario() {
        return this.folioUsuario;
    }

    public void setFolioUsuario(String folioUsuario) {
        this.folioUsuario = folioUsuario;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRfcreceptor() {
        return this.rfcreceptor;
    }

    public void setRfcreceptor(String rfcreceptor) {
        this.rfcreceptor = rfcreceptor;
    }

    public String getNombreReceptor() {
        return this.nombreReceptor;
    }

    public void setNombreReceptor(String nombreReceptor) {
        this.nombreReceptor = nombreReceptor;
    }

    public String getTarjeta() {
        return this.tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getRutaXml() {
        return this.rutaXml;
    }

    public void setRutaXml(String rutaXml) {
        this.rutaXml = rutaXml;
    }

    public String getRutaImagen() {
        return this.rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getRutaPdf() {
        return this.rutaPdf;
    }

    public void setRutaPdf(String rutaPdf) {
        this.rutaPdf = rutaPdf;
    }

    public String getModificarArchivo() {
        return this.modificarArchivo;
    }

    public void setModificarArchivo(String modificarArchivo) {
        this.modificarArchivo = modificarArchivo;
    }

    public BigDecimal getPropina() {
        return this.propina;
    }

    public void setPropina(BigDecimal propina) {
        this.propina = propina;
    }

    public BigDecimal getIsh() {
        return this.ish;
    }

    public void setIsh(BigDecimal ish) {
        this.ish = ish;
    }

    public String getTarjetaGasolina() {
        return this.tarjetaGasolina;
    }

    public void setTarjetaGasolina(String tarjetaGasolina) {
        this.tarjetaGasolina = tarjetaGasolina;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getLugarExpedicion() {
        return this.lugarExpedicion;
    }

    public void setLugarExpedicion(String lugarExpedicion) {
        this.lugarExpedicion = lugarExpedicion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
