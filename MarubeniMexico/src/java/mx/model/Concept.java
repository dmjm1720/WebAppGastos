/*     */ package mx.model;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class Concept
/*     */   implements Serializable
/*     */ {
/*     */   private int idConcepto;
/*     */   private String nombreConcepto;
/*     */   private BigDecimal importe;
/*     */   private BigDecimal iva;
/*     */   private BigDecimal tua;
/*     */   private String factura;
/*     */   private String uuid;
/*     */   private String rfc;
/*     */   private String nombre;
/*     */   private String estatus;
/*     */   private BigDecimal totalmxn;
/*     */   private BigDecimal totalusd;
/*     */   private String comentario;
/*     */   private String nombreUsuario;
/*     */   private String folioUsuario;
/*     */   private Date fecha;
/*     */   private String tipo;
/*     */   private String estado;
/*     */   private String rfcreceptor;
/*     */   private String nombreReceptor;
/*     */   private String tarjeta;
/*     */   private String rutaXml;
/*     */   private String rutaImagen;
/*     */   private String rutaPdf;
/*     */   private String modificarArchivo;
/*     */   private BigDecimal propina;
/*     */   private BigDecimal ish;
/*     */   private String tarjetaGasolina;
/*     */   private String departamento;
/*     */   private String lugarExpedicion;
/*     */   private String descripcion;
/*     */   
/*     */   public int getIdConcepto()
/*     */   {
/*  44 */     return this.idConcepto;
/*     */   }
/*     */   
/*     */   public void setIdConcepto(int idConcepto) {
/*  48 */     this.idConcepto = idConcepto;
/*     */   }
/*     */   
/*     */   public String getNombreConcepto() {
/*  52 */     return this.nombreConcepto;
/*     */   }
/*     */   
/*     */   public void setNombreConcepto(String nombreConcepto) {
/*  56 */     this.nombreConcepto = nombreConcepto;
/*     */   }
/*     */   
/*     */   public BigDecimal getImporte() {
/*  60 */     return this.importe;
/*     */   }
/*     */   
/*     */   public void setImporte(BigDecimal importe) {
/*  64 */     this.importe = importe;
/*     */   }
/*     */   
/*     */   public BigDecimal getIva() {
/*  68 */     return this.iva;
/*     */   }
/*     */   
/*     */   public void setIva(BigDecimal iva) {
/*  72 */     this.iva = iva;
/*     */   }
/*     */   
/*     */   public BigDecimal getTua() {
/*  76 */     return this.tua;
/*     */   }
/*     */   
/*     */   public void setTua(BigDecimal tua) {
/*  80 */     this.tua = tua;
/*     */   }
/*     */   
/*     */   public String getFactura() {
/*  84 */     return this.factura;
/*     */   }
/*     */   
/*     */   public void setFactura(String factura) {
/*  88 */     this.factura = factura;
/*     */   }
/*     */   
/*     */   public String getUuid() {
/*  92 */     return this.uuid;
/*     */   }
/*     */   
/*     */   public void setUuid(String uuid) {
/*  96 */     this.uuid = uuid;
/*     */   }
/*     */   
/*     */   public String getRfc() {
/* 100 */     return this.rfc;
/*     */   }
/*     */   
/*     */   public void setRfc(String rfc) {
/* 104 */     this.rfc = rfc;
/*     */   }
/*     */   
/*     */   public String getNombre() {
/* 108 */     return this.nombre;
/*     */   }
/*     */   
/*     */   public void setNombre(String nombre) {
/* 112 */     this.nombre = nombre;
/*     */   }
/*     */   
/*     */   public String getEstatus() {
/* 116 */     return this.estatus;
/*     */   }
/*     */   
/*     */   public void setEstatus(String estatus) {
/* 120 */     this.estatus = estatus;
/*     */   }
/*     */   
/*     */   public BigDecimal getTotalmxn() {
/* 124 */     return this.totalmxn;
/*     */   }
/*     */   
/*     */   public void setTotalmxn(BigDecimal totalmxn) {
/* 128 */     this.totalmxn = totalmxn;
/*     */   }
/*     */   
/*     */   public BigDecimal getTotalusd() {
/* 132 */     return this.totalusd;
/*     */   }
/*     */   
/*     */   public void setTotalusd(BigDecimal totalusd) {
/* 136 */     this.totalusd = totalusd;
/*     */   }
/*     */   
/*     */   public String getComentario() {
/* 140 */     return this.comentario;
/*     */   }
/*     */   
/*     */   public void setComentario(String comentario) {
/* 144 */     this.comentario = comentario;
/*     */   }
/*     */   
/*     */   public String getNombreUsuario() {
/* 148 */     return this.nombreUsuario;
/*     */   }
/*     */   
/*     */   public void setNombreUsuario(String nombreUsuario) {
/* 152 */     this.nombreUsuario = nombreUsuario;
/*     */   }
/*     */   
/*     */   public String getFolioUsuario() {
/* 156 */     return this.folioUsuario;
/*     */   }
/*     */   
/*     */   public void setFolioUsuario(String folioUsuario) {
/* 160 */     this.folioUsuario = folioUsuario;
/*     */   }
/*     */   
/*     */   public Date getFecha() {
/* 164 */     return this.fecha;
/*     */   }
/*     */   
/*     */   public void setFecha(Date fecha) {
/* 168 */     this.fecha = fecha;
/*     */   }
/*     */   
/*     */   public String getTipo() {
/* 172 */     return this.tipo;
/*     */   }
/*     */   
/*     */   public void setTipo(String tipo) {
/* 176 */     this.tipo = tipo;
/*     */   }
/*     */   
/*     */   public String getEstado() {
/* 180 */     return this.estado;
/*     */   }
/*     */   
/*     */   public void setEstado(String estado) {
/* 184 */     this.estado = estado;
/*     */   }
/*     */   
/*     */   public String getRfcreceptor() {
/* 188 */     return this.rfcreceptor;
/*     */   }
/*     */   
/*     */   public void setRfcreceptor(String rfcreceptor) {
/* 192 */     this.rfcreceptor = rfcreceptor;
/*     */   }
/*     */   
/*     */   public String getNombreReceptor() {
/* 196 */     return this.nombreReceptor;
/*     */   }
/*     */   
/*     */   public void setNombreReceptor(String nombreReceptor) {
/* 200 */     this.nombreReceptor = nombreReceptor;
/*     */   }
/*     */   
/*     */   public String getTarjeta() {
/* 204 */     return this.tarjeta;
/*     */   }
/*     */   
/*     */   public void setTarjeta(String tarjeta) {
/* 208 */     this.tarjeta = tarjeta;
/*     */   }
/*     */   
/*     */   public String getRutaXml() {
/* 212 */     return this.rutaXml;
/*     */   }
/*     */   
/*     */   public void setRutaXml(String rutaXml) {
/* 216 */     this.rutaXml = rutaXml;
/*     */   }
/*     */   
/*     */   public String getRutaImagen() {
/* 220 */     return this.rutaImagen;
/*     */   }
/*     */   
/*     */   public void setRutaImagen(String rutaImagen) {
/* 224 */     this.rutaImagen = rutaImagen;
/*     */   }
/*     */   
/*     */   public String getRutaPdf() {
/* 228 */     return this.rutaPdf;
/*     */   }
/*     */   
/*     */   public void setRutaPdf(String rutaPdf) {
/* 232 */     this.rutaPdf = rutaPdf;
/*     */   }
/*     */   
/*     */   public String getModificarArchivo() {
/* 236 */     return this.modificarArchivo;
/*     */   }
/*     */   
/*     */   public void setModificarArchivo(String modificarArchivo) {
/* 240 */     this.modificarArchivo = modificarArchivo;
/*     */   }
/*     */   
/*     */   public BigDecimal getPropina() {
/* 244 */     return this.propina;
/*     */   }
/*     */   
/*     */   public void setPropina(BigDecimal propina) {
/* 248 */     this.propina = propina;
/*     */   }
/*     */   
/*     */   public BigDecimal getIsh() {
/* 252 */     return this.ish;
/*     */   }
/*     */   
/*     */   public void setIsh(BigDecimal ish) {
/* 256 */     this.ish = ish;
/*     */   }
/*     */   
/*     */   public String getTarjetaGasolina() {
/* 260 */     return this.tarjetaGasolina;
/*     */   }
/*     */   
/*     */   public void setTarjetaGasolina(String tarjetaGasolina) {
/* 264 */     this.tarjetaGasolina = tarjetaGasolina;
/*     */   }
/*     */   
/*     */   public String getDepartamento() {
/* 268 */     return this.departamento;
/*     */   }
/*     */   
/*     */   public void setDepartamento(String departamento) {
/* 272 */     this.departamento = departamento;
/*     */   }
/*     */   
/*     */   public String getLugarExpedicion() {
/* 276 */     return this.lugarExpedicion;
/*     */   }
/*     */   
/*     */   public void setLugarExpedicion(String lugarExpedicion) {
/* 280 */     this.lugarExpedicion = lugarExpedicion;
/*     */   }
/*     */   
/*     */   public String getDescripcion() {
/* 284 */     return this.descripcion;
/*     */   }
/*     */   
/*     */   public void setDescripcion(String descripcion) {
/* 288 */     this.descripcion = descripcion;
/*     */   }
/*     */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\model\Concept.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */