/*     */ package mx.model;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class Viaje implements Serializable
/*     */ {
/*     */   private int idViaje;
/*     */   private String folioUsuario;
/*     */   private Date fechaDocumento;
/*     */   private String oficina;
/*     */   private String nombreViajero;
/*     */   private String origen;
/*     */   private String destino;
/*     */   private String proposito;
/*     */   private Date fechaOrigen;
/*     */   private Date fechaLlegada;
/*     */   private String status;
/*     */   private Integer dias;
/*     */   private BigDecimal totalAsignado;
/*     */   private String departamento;
/*     */   private String fechaAno;
/*     */   private BigDecimal tipoCambio;
/*     */   private String tipoMoneda;
/*     */   private String tipoViaje;
/*     */   private String layout;
/*     */   private String seccion;
/*     */   private String comentario;
/*     */   private String mutual;
/*     */   
/*     */   public Viaje() {}
/*     */   
/*     */   public Viaje(int idViaje)
/*     */   {
/*  36 */     this.idViaje = idViaje;
/*     */   }
/*     */   
/*     */   public Viaje(int idViaje, String folioUsuario, Date fechaDocumento, String oficina, String nombreViajero, String origen, String destino, String proposito, Date fechaOrigen, Date fechaLlegada, String status, Integer dias, BigDecimal totalAsignado, String departamento, String fechaAno, BigDecimal tipoCambio, String tipoMoneda, String tipoViaje, String layout, String seccion, String comentario, String mutual) {
/*  40 */     this.idViaje = idViaje;
/*  41 */     this.folioUsuario = folioUsuario;
/*  42 */     this.fechaDocumento = fechaDocumento;
/*  43 */     this.oficina = oficina;
/*  44 */     this.nombreViajero = nombreViajero;
/*  45 */     this.origen = origen;
/*  46 */     this.destino = destino;
/*  47 */     this.proposito = proposito;
/*  48 */     this.fechaOrigen = fechaOrigen;
/*  49 */     this.fechaLlegada = fechaLlegada;
/*  50 */     this.status = status;
/*  51 */     this.dias = dias;
/*  52 */     this.totalAsignado = totalAsignado;
/*  53 */     this.departamento = departamento;
/*  54 */     this.fechaAno = fechaAno;
/*  55 */     this.tipoCambio = tipoCambio;
/*  56 */     this.tipoMoneda = tipoMoneda;
/*  57 */     this.tipoViaje = tipoViaje;
/*  58 */     this.layout = layout;
/*  59 */     this.seccion = seccion;
/*  60 */     this.comentario = comentario;
/*  61 */     this.mutual = mutual;
/*     */   }
/*     */   
/*     */   public int getIdViaje() {
/*  65 */     return this.idViaje;
/*     */   }
/*     */   
/*     */   public void setIdViaje(int idViaje) {
/*  69 */     this.idViaje = idViaje;
/*     */   }
/*     */   
/*     */   public String getFolioUsuario() {
/*  73 */     return this.folioUsuario;
/*     */   }
/*     */   
/*     */   public void setFolioUsuario(String folioUsuario) {
/*  77 */     this.folioUsuario = folioUsuario;
/*     */   }
/*     */   
/*     */   public Date getFechaDocumento() {
/*  81 */     return this.fechaDocumento;
/*     */   }
/*     */   
/*     */   public void setFechaDocumento(Date fechaDocumento) {
/*  85 */     this.fechaDocumento = fechaDocumento;
/*     */   }
/*     */   
/*     */   public String getOficina() {
/*  89 */     return this.oficina;
/*     */   }
/*     */   
/*     */   public void setOficina(String oficina) {
/*  93 */     this.oficina = oficina;
/*     */   }
/*     */   
/*     */   public String getNombreViajero() {
/*  97 */     return this.nombreViajero;
/*     */   }
/*     */   
/*     */   public void setNombreViajero(String nombreViajero) {
/* 101 */     this.nombreViajero = nombreViajero;
/*     */   }
/*     */   
/*     */   public String getOrigen() {
/* 105 */     return this.origen;
/*     */   }
/*     */   
/*     */   public void setOrigen(String origen) {
/* 109 */     this.origen = origen;
/*     */   }
/*     */   
/*     */   public String getDestino() {
/* 113 */     return this.destino;
/*     */   }
/*     */   
/*     */   public void setDestino(String destino) {
/* 117 */     this.destino = destino;
/*     */   }
/*     */   
/*     */   public String getProposito() {
/* 121 */     return this.proposito;
/*     */   }
/*     */   
/*     */   public void setProposito(String proposito) {
/* 125 */     this.proposito = proposito;
/*     */   }
/*     */   
/*     */   public Date getFechaOrigen() {
/* 129 */     return this.fechaOrigen;
/*     */   }
/*     */   
/*     */   public void setFechaOrigen(Date fechaOrigen) {
/* 133 */     this.fechaOrigen = fechaOrigen;
/*     */   }
/*     */   
/*     */   public Date getFechaLlegada() {
/* 137 */     return this.fechaLlegada;
/*     */   }
/*     */   
/*     */   public void setFechaLlegada(Date fechaLlegada) {
/* 141 */     this.fechaLlegada = fechaLlegada;
/*     */   }
/*     */   
/*     */   public String getStatus() {
/* 145 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(String status) {
/* 149 */     this.status = status;
/*     */   }
/*     */   
/*     */   public Integer getDias() {
/* 153 */     return this.dias;
/*     */   }
/*     */   
/*     */   public void setDias(Integer dias) {
/* 157 */     this.dias = dias;
/*     */   }
/*     */   
/*     */   public BigDecimal getTotalAsignado() {
/* 161 */     return this.totalAsignado;
/*     */   }
/*     */   
/*     */   public void setTotalAsignado(BigDecimal totalAsignado) {
/* 165 */     this.totalAsignado = totalAsignado;
/*     */   }
/*     */   
/*     */   public String getDepartamento() {
/* 169 */     return this.departamento;
/*     */   }
/*     */   
/*     */   public void setDepartamento(String departamento) {
/* 173 */     this.departamento = departamento;
/*     */   }
/*     */   
/*     */   public String getFechaAno() {
/* 177 */     return this.fechaAno;
/*     */   }
/*     */   
/*     */   public void setFechaAno(String fechaAno) {
/* 181 */     this.fechaAno = fechaAno;
/*     */   }
/*     */   
/*     */   public BigDecimal getTipoCambio() {
/* 185 */     return this.tipoCambio;
/*     */   }
/*     */   
/*     */   public void setTipoCambio(BigDecimal tipoCambio) {
/* 189 */     this.tipoCambio = tipoCambio;
/*     */   }
/*     */   
/*     */   public String getTipoMoneda() {
/* 193 */     return this.tipoMoneda;
/*     */   }
/*     */   
/*     */   public void setTipoMoneda(String tipoMoneda) {
/* 197 */     this.tipoMoneda = tipoMoneda;
/*     */   }
/*     */   
/*     */   public String getTipoViaje() {
/* 201 */     return this.tipoViaje;
/*     */   }
/*     */   
/*     */   public void setTipoViaje(String tipoViaje) {
/* 205 */     this.tipoViaje = tipoViaje;
/*     */   }
/*     */   
/*     */   public String getLayout() {
/* 209 */     return this.layout;
/*     */   }
/*     */   
/*     */   public void setLayout(String layout) {
/* 213 */     this.layout = layout;
/*     */   }
/*     */   
/*     */   public String getSeccion() {
/* 217 */     return this.seccion;
/*     */   }
/*     */   
/*     */   public void setSeccion(String seccion) {
/* 221 */     this.seccion = seccion;
/*     */   }
/*     */   
/*     */   public String getComentario() {
/* 225 */     return this.comentario;
/*     */   }
/*     */   
/*     */   public void setComentario(String comentario) {
/* 229 */     this.comentario = comentario;
/*     */   }
/*     */   
/*     */   public String getMutual() {
/* 233 */     return this.mutual;
/*     */   }
/*     */   
/*     */   public void setMutual(String mutual) {
/* 237 */     this.mutual = mutual;
/*     */   }
/*     */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\model\Viaje.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */