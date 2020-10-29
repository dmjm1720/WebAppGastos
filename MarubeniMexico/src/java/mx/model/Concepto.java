/*     */ package mx.model;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Concepto
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
/*     */   private String selloCfd;
/*     */   private String selloSat;
/*     */   private String fechaTimbrado;
/*     */   private String noCertificadoSat;
/*     */   private String veruuid;
/*     */   private String noCertificado;
/*     */   private BigDecimal tipoCambio;
/*     */   private String moneda;
/*     */   private String tipoComprobante;
/*     */   private String metodoPago;
/*     */   private String formaPago;
/*     */   private BigDecimal impuestoRetenido;
/*     */   private byte[] imagen;
/*     */   
/*     */   public Concepto() {}
/*     */   
/*     */   public Concepto(int idConcepto)
/*     */   {
/*  61 */     this.idConcepto = idConcepto;
/*     */   }
/*     */   
/*     */   public Concepto(int idConcepto, String nombreConcepto, BigDecimal importe, BigDecimal iva, BigDecimal tua, String factura, String uuid, String rfc, String nombre, String estatus, BigDecimal totalmxn, BigDecimal totalusd, String comentario, String nombreUsuario, String folioUsuario, Date fecha, String tipo, String estado, String rfcreceptor, String nombreReceptor, String tarjeta, String rutaXml, String rutaImagen, String rutaPdf, String modificarArchivo, BigDecimal propina, BigDecimal ish, String tarjetaGasolina, String departamento, String lugarExpedicion, String descripcion, String selloCfd, String selloSat, String fechaTimbrado, String noCertificadoSat, String veruuid, String noCertificado, BigDecimal tipoCambio, String moneda, String tipoComprobante, String metodoPago, String formaPago, BigDecimal impuestoRetenido, byte[] imagen) {
/*  65 */     this.idConcepto = idConcepto;
/*  66 */     this.nombreConcepto = nombreConcepto;
/*  67 */     this.importe = importe;
/*  68 */     this.iva = iva;
/*  69 */     this.tua = tua;
/*  70 */     this.factura = factura;
/*  71 */     this.uuid = uuid;
/*  72 */     this.rfc = rfc;
/*  73 */     this.nombre = nombre;
/*  74 */     this.estatus = estatus;
/*  75 */     this.totalmxn = totalmxn;
/*  76 */     this.totalusd = totalusd;
/*  77 */     this.comentario = comentario;
/*  78 */     this.nombreUsuario = nombreUsuario;
/*  79 */     this.folioUsuario = folioUsuario;
/*  80 */     this.fecha = fecha;
/*  81 */     this.tipo = tipo;
/*  82 */     this.estado = estado;
/*  83 */     this.rfcreceptor = rfcreceptor;
/*  84 */     this.nombreReceptor = nombreReceptor;
/*  85 */     this.tarjeta = tarjeta;
/*  86 */     this.rutaXml = rutaXml;
/*  87 */     this.rutaImagen = rutaImagen;
/*  88 */     this.rutaPdf = rutaPdf;
/*  89 */     this.modificarArchivo = modificarArchivo;
/*  90 */     this.propina = propina;
/*  91 */     this.ish = ish;
/*  92 */     this.tarjetaGasolina = tarjetaGasolina;
/*  93 */     this.departamento = departamento;
/*  94 */     this.lugarExpedicion = lugarExpedicion;
/*  95 */     this.descripcion = descripcion;
/*  96 */     this.selloCfd = selloCfd;
/*  97 */     this.selloSat = selloSat;
/*  98 */     this.fechaTimbrado = fechaTimbrado;
/*  99 */     this.noCertificadoSat = noCertificadoSat;
/* 100 */     this.veruuid = veruuid;
/* 101 */     this.noCertificado = noCertificado;
/* 102 */     this.tipoCambio = tipoCambio;
/* 103 */     this.moneda = moneda;
/* 104 */     this.tipoComprobante = tipoComprobante;
/* 105 */     this.metodoPago = metodoPago;
/* 106 */     this.formaPago = formaPago;
/* 107 */     this.impuestoRetenido = impuestoRetenido;
/* 108 */     this.imagen = imagen;
/*     */   }
/*     */   
/*     */   public int getIdConcepto() {
/* 112 */     return this.idConcepto;
/*     */   }
/*     */   
/*     */   public void setIdConcepto(int idConcepto) {
/* 116 */     this.idConcepto = idConcepto;
/*     */   }
/*     */   
/*     */   public String getNombreConcepto() {
/* 120 */     return this.nombreConcepto;
/*     */   }
/*     */   
/*     */   public void setNombreConcepto(String nombreConcepto) {
/* 124 */     this.nombreConcepto = nombreConcepto;
/*     */   }
/*     */   
/*     */   public BigDecimal getImporte() {
/* 128 */     return this.importe;
/*     */   }
/*     */   
/*     */   public void setImporte(BigDecimal importe) {
/* 132 */     this.importe = importe;
/*     */   }
/*     */   
/*     */   public BigDecimal getIva() {
/* 136 */     return this.iva;
/*     */   }
/*     */   
/*     */   public void setIva(BigDecimal iva) {
/* 140 */     this.iva = iva;
/*     */   }
/*     */   
/*     */   public BigDecimal getTua() {
/* 144 */     return this.tua;
/*     */   }
/*     */   
/*     */   public void setTua(BigDecimal tua) {
/* 148 */     this.tua = tua;
/*     */   }
/*     */   
/*     */   public String getFactura() {
/* 152 */     return this.factura;
/*     */   }
/*     */   
/*     */   public void setFactura(String factura) {
/* 156 */     this.factura = factura;
/*     */   }
/*     */   
/*     */   public String getUuid() {
/* 160 */     return this.uuid;
/*     */   }
/*     */   
/*     */   public void setUuid(String uuid) {
/* 164 */     this.uuid = uuid;
/*     */   }
/*     */   
/*     */   public String getRfc() {
/* 168 */     return this.rfc;
/*     */   }
/*     */   
/*     */   public void setRfc(String rfc) {
/* 172 */     this.rfc = rfc;
/*     */   }
/*     */   
/*     */   public String getNombre() {
/* 176 */     return this.nombre;
/*     */   }
/*     */   
/*     */   public void setNombre(String nombre) {
/* 180 */     this.nombre = nombre;
/*     */   }
/*     */   
/*     */   public String getEstatus() {
/* 184 */     return this.estatus;
/*     */   }
/*     */   
/*     */   public void setEstatus(String estatus) {
/* 188 */     this.estatus = estatus;
/*     */   }
/*     */   
/*     */   public BigDecimal getTotalmxn() {
/* 192 */     return this.totalmxn;
/*     */   }
/*     */   
/*     */   public void setTotalmxn(BigDecimal totalmxn) {
/* 196 */     this.totalmxn = totalmxn;
/*     */   }
/*     */   
/*     */   public BigDecimal getTotalusd() {
/* 200 */     return this.totalusd;
/*     */   }
/*     */   
/*     */   public void setTotalusd(BigDecimal totalusd) {
/* 204 */     this.totalusd = totalusd;
/*     */   }
/*     */   
/*     */   public String getComentario() {
/* 208 */     return this.comentario;
/*     */   }
/*     */   
/*     */   public void setComentario(String comentario) {
/* 212 */     this.comentario = comentario;
/*     */   }
/*     */   
/*     */   public String getNombreUsuario() {
/* 216 */     return this.nombreUsuario;
/*     */   }
/*     */   
/*     */   public void setNombreUsuario(String nombreUsuario) {
/* 220 */     this.nombreUsuario = nombreUsuario;
/*     */   }
/*     */   
/*     */   public String getFolioUsuario() {
/* 224 */     return this.folioUsuario;
/*     */   }
/*     */   
/*     */   public void setFolioUsuario(String folioUsuario) {
/* 228 */     this.folioUsuario = folioUsuario;
/*     */   }
/*     */   
/*     */   public Date getFecha() {
/* 232 */     return this.fecha;
/*     */   }
/*     */   
/*     */   public void setFecha(Date fecha) {
/* 236 */     this.fecha = fecha;
/*     */   }
/*     */   
/*     */   public String getTipo() {
/* 240 */     return this.tipo;
/*     */   }
/*     */   
/*     */   public void setTipo(String tipo) {
/* 244 */     this.tipo = tipo;
/*     */   }
/*     */   
/*     */   public String getEstado() {
/* 248 */     return this.estado;
/*     */   }
/*     */   
/*     */   public void setEstado(String estado) {
/* 252 */     this.estado = estado;
/*     */   }
/*     */   
/*     */   public String getRfcreceptor() {
/* 256 */     return this.rfcreceptor;
/*     */   }
/*     */   
/*     */   public void setRfcreceptor(String rfcreceptor) {
/* 260 */     this.rfcreceptor = rfcreceptor;
/*     */   }
/*     */   
/*     */   public String getNombreReceptor() {
/* 264 */     return this.nombreReceptor;
/*     */   }
/*     */   
/*     */   public void setNombreReceptor(String nombreReceptor) {
/* 268 */     this.nombreReceptor = nombreReceptor;
/*     */   }
/*     */   
/*     */   public String getTarjeta() {
/* 272 */     return this.tarjeta;
/*     */   }
/*     */   
/*     */   public void setTarjeta(String tarjeta) {
/* 276 */     this.tarjeta = tarjeta;
/*     */   }
/*     */   
/*     */   public String getRutaXml() {
/* 280 */     return this.rutaXml;
/*     */   }
/*     */   
/*     */   public void setRutaXml(String rutaXml) {
/* 284 */     this.rutaXml = rutaXml;
/*     */   }
/*     */   
/*     */   public String getRutaImagen() {
/* 288 */     return this.rutaImagen;
/*     */   }
/*     */   
/*     */   public void setRutaImagen(String rutaImagen) {
/* 292 */     this.rutaImagen = rutaImagen;
/*     */   }
/*     */   
/*     */   public String getRutaPdf() {
/* 296 */     return this.rutaPdf;
/*     */   }
/*     */   
/*     */   public void setRutaPdf(String rutaPdf) {
/* 300 */     this.rutaPdf = rutaPdf;
/*     */   }
/*     */   
/*     */   public String getModificarArchivo() {
/* 304 */     return this.modificarArchivo;
/*     */   }
/*     */   
/*     */   public void setModificarArchivo(String modificarArchivo) {
/* 308 */     this.modificarArchivo = modificarArchivo;
/*     */   }
/*     */   
/*     */   public BigDecimal getPropina() {
/* 312 */     return this.propina;
/*     */   }
/*     */   
/*     */   public void setPropina(BigDecimal propina) {
/* 316 */     this.propina = propina;
/*     */   }
/*     */   
/*     */   public BigDecimal getIsh() {
/* 320 */     return this.ish;
/*     */   }
/*     */   
/*     */   public void setIsh(BigDecimal ish) {
/* 324 */     this.ish = ish;
/*     */   }
/*     */   
/*     */   public String getTarjetaGasolina() {
/* 328 */     return this.tarjetaGasolina;
/*     */   }
/*     */   
/*     */   public void setTarjetaGasolina(String tarjetaGasolina) {
/* 332 */     this.tarjetaGasolina = tarjetaGasolina;
/*     */   }
/*     */   
/*     */   public String getDepartamento() {
/* 336 */     return this.departamento;
/*     */   }
/*     */   
/*     */   public void setDepartamento(String departamento) {
/* 340 */     this.departamento = departamento;
/*     */   }
/*     */   
/*     */   public String getLugarExpedicion() {
/* 344 */     return this.lugarExpedicion;
/*     */   }
/*     */   
/*     */   public void setLugarExpedicion(String lugarExpedicion) {
/* 348 */     this.lugarExpedicion = lugarExpedicion;
/*     */   }
/*     */   
/*     */   public String getDescripcion() {
/* 352 */     return this.descripcion;
/*     */   }
/*     */   
/*     */   public void setDescripcion(String descripcion) {
/* 356 */     this.descripcion = descripcion;
/*     */   }
/*     */   
/*     */   public String getSelloCfd() {
/* 360 */     return this.selloCfd;
/*     */   }
/*     */   
/*     */   public void setSelloCfd(String selloCfd) {
/* 364 */     this.selloCfd = selloCfd;
/*     */   }
/*     */   
/*     */   public String getSelloSat() {
/* 368 */     return this.selloSat;
/*     */   }
/*     */   
/*     */   public void setSelloSat(String selloSat) {
/* 372 */     this.selloSat = selloSat;
/*     */   }
/*     */   
/*     */   public String getFechaTimbrado() {
/* 376 */     return this.fechaTimbrado;
/*     */   }
/*     */   
/*     */   public void setFechaTimbrado(String fechaTimbrado) {
/* 380 */     this.fechaTimbrado = fechaTimbrado;
/*     */   }
/*     */   
/*     */   public String getNoCertificadoSat() {
/* 384 */     return this.noCertificadoSat;
/*     */   }
/*     */   
/*     */   public void setNoCertificadoSat(String noCertificadoSat) {
/* 388 */     this.noCertificadoSat = noCertificadoSat;
/*     */   }
/*     */   
/*     */   public String getVeruuid() {
/* 392 */     return this.veruuid;
/*     */   }
/*     */   
/*     */   public void setVeruuid(String veruuid) {
/* 396 */     this.veruuid = veruuid;
/*     */   }
/*     */   
/*     */   public String getNoCertificado() {
/* 400 */     return this.noCertificado;
/*     */   }
/*     */   
/*     */   public void setNoCertificado(String noCertificado) {
/* 404 */     this.noCertificado = noCertificado;
/*     */   }
/*     */   
/*     */   public BigDecimal getTipoCambio() {
/* 408 */     return this.tipoCambio;
/*     */   }
/*     */   
/*     */   public void setTipoCambio(BigDecimal tipoCambio) {
/* 412 */     this.tipoCambio = tipoCambio;
/*     */   }
/*     */   
/*     */   public String getMoneda() {
/* 416 */     return this.moneda;
/*     */   }
/*     */   
/*     */   public void setMoneda(String moneda) {
/* 420 */     this.moneda = moneda;
/*     */   }
/*     */   
/*     */   public String getTipoComprobante() {
/* 424 */     return this.tipoComprobante;
/*     */   }
/*     */   
/*     */   public void setTipoComprobante(String tipoComprobante) {
/* 428 */     this.tipoComprobante = tipoComprobante;
/*     */   }
/*     */   
/*     */   public String getMetodoPago() {
/* 432 */     return this.metodoPago;
/*     */   }
/*     */   
/*     */   public void setMetodoPago(String metodoPago) {
/* 436 */     this.metodoPago = metodoPago;
/*     */   }
/*     */   
/*     */   public String getFormaPago() {
/* 440 */     return this.formaPago;
/*     */   }
/*     */   
/*     */   public void setFormaPago(String formaPago) {
/* 444 */     this.formaPago = formaPago;
/*     */   }
/*     */   
/*     */   public BigDecimal getImpuestoRetenido() {
/* 448 */     return this.impuestoRetenido;
/*     */   }
/*     */   
/*     */   public void setImpuestoRetenido(BigDecimal impuestoRetenido) {
/* 452 */     this.impuestoRetenido = impuestoRetenido;
/*     */   }
/*     */   
/*     */   public byte[] getImagen() {
/* 456 */     return this.imagen;
/*     */   }
/*     */   
/*     */   public void setImagen(byte[] imagen) {
/* 460 */     this.imagen = imagen;
/*     */   }
/*     */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\model\Concepto.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */