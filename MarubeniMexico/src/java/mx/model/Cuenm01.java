/*     */ package mx.model;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class Cuenm01 implements java.io.Serializable
/*     */ {
/*     */   private String noFactura;
/*     */   private String cveClie;
/*     */   private String rfc;
/*     */   private String nombreClie;
/*     */   private Double importe;
/*     */   private Date fechaApli;
/*     */   private Integer numMoned;
/*     */   private Double tcambio;
/*     */   private Double impmonExt;
/*     */   private String strcvevend;
/*     */   private String nombreVend;
/*     */   private Boolean pagoParcial;
/*     */   private Double nuevoImporte;
/*     */   private Double nuevoTcambio;
/*     */   private Integer nuevoMoneda;
/*     */   private String tipoPago;
/*     */   private Integer aviso;
/*     */   private Boolean procesado;
/*     */   private Date fechaIngreso;
/*     */   private Date fechaEnvio;
/*     */   private Boolean completado;
/*     */   private String banco;
/*     */   private Date fechaPago;
/*     */   private Integer pagoMultiple;
/*     */   private String depto;
/*     */   private Double saldo;
/*     */   private Boolean proParcial;
/*     */   
/*     */   public Cuenm01() {}
/*     */   
/*     */   public Cuenm01(String noFactura)
/*     */   {
/*  39 */     this.noFactura = noFactura;
/*     */   }
/*     */   
/*     */   public Cuenm01(String noFactura, String cveClie, String rfc, String nombreClie, Double importe, Date fechaApli, Integer numMoned, Double tcambio, Double impmonExt, String strcvevend, String nombreVend, Boolean pagoParcial, Double nuevoImporte, Double nuevoTcambio, Integer nuevoMoneda, String tipoPago, Integer aviso, Boolean procesado, Date fechaIngreso, Date fechaEnvio, Boolean completado, String banco, Date fechaPago, Integer pagoMultiple, String depto, Double saldo, Boolean proParcial) {
/*  43 */     this.noFactura = noFactura;
/*  44 */     this.cveClie = cveClie;
/*  45 */     this.rfc = rfc;
/*  46 */     this.nombreClie = nombreClie;
/*  47 */     this.importe = importe;
/*  48 */     this.fechaApli = fechaApli;
/*  49 */     this.numMoned = numMoned;
/*  50 */     this.tcambio = tcambio;
/*  51 */     this.impmonExt = impmonExt;
/*  52 */     this.strcvevend = strcvevend;
/*  53 */     this.nombreVend = nombreVend;
/*  54 */     this.pagoParcial = pagoParcial;
/*  55 */     this.nuevoImporte = nuevoImporte;
/*  56 */     this.nuevoTcambio = nuevoTcambio;
/*  57 */     this.nuevoMoneda = nuevoMoneda;
/*  58 */     this.tipoPago = tipoPago;
/*  59 */     this.aviso = aviso;
/*  60 */     this.procesado = procesado;
/*  61 */     this.fechaIngreso = fechaIngreso;
/*  62 */     this.fechaEnvio = fechaEnvio;
/*  63 */     this.completado = completado;
/*  64 */     this.banco = banco;
/*  65 */     this.fechaPago = fechaPago;
/*  66 */     this.pagoMultiple = pagoMultiple;
/*  67 */     this.depto = depto;
/*  68 */     this.saldo = saldo;
/*  69 */     this.proParcial = proParcial;
/*     */   }
/*     */   
/*     */   public String getNoFactura() {
/*  73 */     return this.noFactura;
/*     */   }
/*     */   
/*     */   public void setNoFactura(String noFactura) {
/*  77 */     this.noFactura = noFactura;
/*     */   }
/*     */   
/*     */   public String getCveClie() {
/*  81 */     return this.cveClie;
/*     */   }
/*     */   
/*     */   public void setCveClie(String cveClie) {
/*  85 */     this.cveClie = cveClie;
/*     */   }
/*     */   
/*     */   public String getRfc() {
/*  89 */     return this.rfc;
/*     */   }
/*     */   
/*     */   public void setRfc(String rfc) {
/*  93 */     this.rfc = rfc;
/*     */   }
/*     */   
/*     */   public String getNombreClie() {
/*  97 */     return this.nombreClie;
/*     */   }
/*     */   
/*     */   public void setNombreClie(String nombreClie) {
/* 101 */     this.nombreClie = nombreClie;
/*     */   }
/*     */   
/*     */   public Double getImporte() {
/* 105 */     return this.importe;
/*     */   }
/*     */   
/*     */   public void setImporte(Double importe) {
/* 109 */     this.importe = importe;
/*     */   }
/*     */   
/*     */   public Date getFechaApli() {
/* 113 */     return this.fechaApli;
/*     */   }
/*     */   
/*     */   public void setFechaApli(Date fechaApli) {
/* 117 */     this.fechaApli = fechaApli;
/*     */   }
/*     */   
/*     */   public Integer getNumMoned() {
/* 121 */     return this.numMoned;
/*     */   }
/*     */   
/*     */   public void setNumMoned(Integer numMoned) {
/* 125 */     this.numMoned = numMoned;
/*     */   }
/*     */   
/*     */   public Double getTcambio() {
/* 129 */     return this.tcambio;
/*     */   }
/*     */   
/*     */   public void setTcambio(Double tcambio) {
/* 133 */     this.tcambio = tcambio;
/*     */   }
/*     */   
/*     */   public Double getImpmonExt() {
/* 137 */     return this.impmonExt;
/*     */   }
/*     */   
/*     */   public void setImpmonExt(Double impmonExt) {
/* 141 */     this.impmonExt = impmonExt;
/*     */   }
/*     */   
/*     */   public String getStrcvevend() {
/* 145 */     return this.strcvevend;
/*     */   }
/*     */   
/*     */   public void setStrcvevend(String strcvevend) {
/* 149 */     this.strcvevend = strcvevend;
/*     */   }
/*     */   
/*     */   public String getNombreVend() {
/* 153 */     return this.nombreVend;
/*     */   }
/*     */   
/*     */   public void setNombreVend(String nombreVend) {
/* 157 */     this.nombreVend = nombreVend;
/*     */   }
/*     */   
/*     */   public Boolean getPagoParcial() {
/* 161 */     return this.pagoParcial;
/*     */   }
/*     */   
/*     */   public void setPagoParcial(Boolean pagoParcial) {
/* 165 */     this.pagoParcial = pagoParcial;
/*     */   }
/*     */   
/*     */   public Double getNuevoImporte() {
/* 169 */     return this.nuevoImporte;
/*     */   }
/*     */   
/*     */   public void setNuevoImporte(Double nuevoImporte) {
/* 173 */     this.nuevoImporte = nuevoImporte;
/*     */   }
/*     */   
/*     */   public Double getNuevoTcambio() {
/* 177 */     return this.nuevoTcambio;
/*     */   }
/*     */   
/*     */   public void setNuevoTcambio(Double nuevoTcambio) {
/* 181 */     this.nuevoTcambio = nuevoTcambio;
/*     */   }
/*     */   
/*     */   public Integer getNuevoMoneda() {
/* 185 */     return this.nuevoMoneda;
/*     */   }
/*     */   
/*     */   public void setNuevoMoneda(Integer nuevoMoneda) {
/* 189 */     this.nuevoMoneda = nuevoMoneda;
/*     */   }
/*     */   
/*     */   public String getTipoPago() {
/* 193 */     return this.tipoPago;
/*     */   }
/*     */   
/*     */   public void setTipoPago(String tipoPago) {
/* 197 */     this.tipoPago = tipoPago;
/*     */   }
/*     */   
/*     */   public Integer getAviso() {
/* 201 */     return this.aviso;
/*     */   }
/*     */   
/*     */   public void setAviso(Integer aviso) {
/* 205 */     this.aviso = aviso;
/*     */   }
/*     */   
/*     */   public Boolean getProcesado() {
/* 209 */     return this.procesado;
/*     */   }
/*     */   
/*     */   public void setProcesado(Boolean procesado) {
/* 213 */     this.procesado = procesado;
/*     */   }
/*     */   
/*     */   public Date getFechaIngreso() {
/* 217 */     return this.fechaIngreso;
/*     */   }
/*     */   
/*     */   public void setFechaIngreso(Date fechaIngreso) {
/* 221 */     this.fechaIngreso = fechaIngreso;
/*     */   }
/*     */   
/*     */   public Date getFechaEnvio() {
/* 225 */     return this.fechaEnvio;
/*     */   }
/*     */   
/*     */   public void setFechaEnvio(Date fechaEnvio) {
/* 229 */     this.fechaEnvio = fechaEnvio;
/*     */   }
/*     */   
/*     */   public Boolean getCompletado() {
/* 233 */     return this.completado;
/*     */   }
/*     */   
/*     */   public void setCompletado(Boolean completado) {
/* 237 */     this.completado = completado;
/*     */   }
/*     */   
/*     */   public String getBanco() {
/* 241 */     return this.banco;
/*     */   }
/*     */   
/*     */   public void setBanco(String banco) {
/* 245 */     this.banco = banco;
/*     */   }
/*     */   
/*     */   public Date getFechaPago() {
/* 249 */     return this.fechaPago;
/*     */   }
/*     */   
/*     */   public void setFechaPago(Date fechaPago) {
/* 253 */     this.fechaPago = fechaPago;
/*     */   }
/*     */   
/*     */   public Integer getPagoMultiple() {
/* 257 */     return this.pagoMultiple;
/*     */   }
/*     */   
/*     */   public void setPagoMultiple(Integer pagoMultiple) {
/* 261 */     this.pagoMultiple = pagoMultiple;
/*     */   }
/*     */   
/*     */   public String getDepto() {
/* 265 */     return this.depto;
/*     */   }
/*     */   
/*     */   public void setDepto(String depto) {
/* 269 */     this.depto = depto;
/*     */   }
/*     */   
/*     */   public Double getSaldo() {
/* 273 */     return this.saldo;
/*     */   }
/*     */   
/*     */   public void setSaldo(Double saldo) {
/* 277 */     this.saldo = saldo;
/*     */   }
/*     */   
/*     */   public Boolean getProParcial() {
/* 281 */     return this.proParcial;
/*     */   }
/*     */   
/*     */   public void setProParcial(Boolean proParcial) {
/* 285 */     this.proParcial = proParcial;
/*     */   }
/*     */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\model\Cuenm01.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */