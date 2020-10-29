/*     */ package mx.model;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class Pagos implements java.io.Serializable
/*     */ {
/*     */   private int id;
/*     */   private String noFactura;
/*     */   private Double importe;
/*     */   private Double tcambio;
/*     */   private Integer moneda;
/*     */   private Date fechaPago;
/*     */   private Integer pagoMultiple;
/*     */   private Boolean procesado;
/*     */   private String banco;
/*     */   private String depto;
/*     */   private String estado;
/*     */   private String subcuenta;
/*     */   private String ctaclientesap;
/*     */   private Double importeusd;
/*     */   private String cliente;
/*     */   private String subctabancos;
/*     */   private String enviado;
/*     */   private String strcvevend;
/*     */   private int tipopago;
/*     */   
/*     */   public Pagos() {}
/*     */   
/*     */   public Pagos(int id)
/*     */   {
/*  31 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Pagos(int id, String noFactura, Double importe, Double tcambio, Integer moneda, Date fechaPago, Integer pagoMultiple, Boolean procesado, String banco, String depto, String estado, String subcuenta, String ctaclientesap, Double importeusd, String cliente, String subctabancos, String enviado, String strcvevend, int tipopago) {
/*  35 */     this.id = id;
/*  36 */     this.noFactura = noFactura;
/*  37 */     this.importe = importe;
/*  38 */     this.tcambio = tcambio;
/*  39 */     this.moneda = moneda;
/*  40 */     this.fechaPago = fechaPago;
/*  41 */     this.pagoMultiple = pagoMultiple;
/*  42 */     this.procesado = procesado;
/*  43 */     this.banco = banco;
/*  44 */     this.depto = depto;
/*  45 */     this.estado = estado;
/*  46 */     this.subcuenta = subcuenta;
/*  47 */     this.ctaclientesap = ctaclientesap;
/*  48 */     this.importeusd = importeusd;
/*  49 */     this.cliente = cliente;
/*  50 */     this.subctabancos = subctabancos;
/*  51 */     this.enviado = enviado;
/*  52 */     this.strcvevend = strcvevend;
/*  53 */     this.tipopago = tipopago;
/*     */   }
/*     */   
/*     */   public int getId() {
/*  57 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(int id) {
/*  61 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getNoFactura() {
/*  65 */     return this.noFactura;
/*     */   }
/*     */   
/*     */   public void setNoFactura(String noFactura) {
/*  69 */     this.noFactura = noFactura;
/*     */   }
/*     */   
/*     */   public Double getImporte() {
/*  73 */     return this.importe;
/*     */   }
/*     */   
/*     */   public void setImporte(Double importe) {
/*  77 */     this.importe = importe;
/*     */   }
/*     */   
/*     */   public Double getTcambio() {
/*  81 */     return this.tcambio;
/*     */   }
/*     */   
/*     */   public void setTcambio(Double tcambio) {
/*  85 */     this.tcambio = tcambio;
/*     */   }
/*     */   
/*     */   public Integer getMoneda() {
/*  89 */     return this.moneda;
/*     */   }
/*     */   
/*     */   public void setMoneda(Integer moneda) {
/*  93 */     this.moneda = moneda;
/*     */   }
/*     */   
/*     */   public Date getFechaPago() {
/*  97 */     return this.fechaPago;
/*     */   }
/*     */   
/*     */   public void setFechaPago(Date fechaPago) {
/* 101 */     this.fechaPago = fechaPago;
/*     */   }
/*     */   
/*     */   public Integer getPagoMultiple() {
/* 105 */     return this.pagoMultiple;
/*     */   }
/*     */   
/*     */   public void setPagoMultiple(Integer pagoMultiple) {
/* 109 */     this.pagoMultiple = pagoMultiple;
/*     */   }
/*     */   
/*     */   public Boolean getProcesado() {
/* 113 */     return this.procesado;
/*     */   }
/*     */   
/*     */   public void setProcesado(Boolean procesado) {
/* 117 */     this.procesado = procesado;
/*     */   }
/*     */   
/*     */   public String getBanco() {
/* 121 */     return this.banco;
/*     */   }
/*     */   
/*     */   public void setBanco(String banco) {
/* 125 */     this.banco = banco;
/*     */   }
/*     */   
/*     */   public String getDepto() {
/* 129 */     return this.depto;
/*     */   }
/*     */   
/*     */   public void setDepto(String depto) {
/* 133 */     this.depto = depto;
/*     */   }
/*     */   
/*     */   public String getEstado() {
/* 137 */     return this.estado;
/*     */   }
/*     */   
/*     */   public void setEstado(String estado) {
/* 141 */     this.estado = estado;
/*     */   }
/*     */   
/*     */   public String getSubcuenta() {
/* 145 */     return this.subcuenta;
/*     */   }
/*     */   
/*     */   public void setSubcuenta(String subcuenta) {
/* 149 */     this.subcuenta = subcuenta;
/*     */   }
/*     */   
/*     */   public String getCtaclientesap() {
/* 153 */     return this.ctaclientesap;
/*     */   }
/*     */   
/*     */   public void setCtaclientesap(String ctaclientesap) {
/* 157 */     this.ctaclientesap = ctaclientesap;
/*     */   }
/*     */   
/*     */   public Double getImporteusd() {
/* 161 */     return this.importeusd;
/*     */   }
/*     */   
/*     */   public void setImporteusd(Double importeusd) {
/* 165 */     this.importeusd = importeusd;
/*     */   }
/*     */   
/*     */   public String getCliente() {
/* 169 */     return this.cliente;
/*     */   }
/*     */   
/*     */   public void setCliente(String cliente) {
/* 173 */     this.cliente = cliente;
/*     */   }
/*     */   
/*     */   public String getSubctabancos() {
/* 177 */     return this.subctabancos;
/*     */   }
/*     */   
/*     */   public void setSubctabancos(String subctabancos) {
/* 181 */     this.subctabancos = subctabancos;
/*     */   }
/*     */   
/*     */   public String getEnviado() {
/* 185 */     return this.enviado;
/*     */   }
/*     */   
/*     */   public void setEnviado(String enviado) {
/* 189 */     this.enviado = enviado;
/*     */   }
/*     */   
/*     */   public String getStrcvevend() {
/* 193 */     return this.strcvevend;
/*     */   }
/*     */   
/*     */   public void setStrcvevend(String strcvevend) {
/* 197 */     this.strcvevend = strcvevend;
/*     */   }
/*     */   
/*     */   public int getTipopago() {
/* 201 */     return this.tipopago;
/*     */   }
/*     */   
/*     */   public void setTipopago(int tipopago) {
/* 205 */     this.tipopago = tipopago;
/*     */   }
/*     */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\model\Pagos.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */