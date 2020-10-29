/*     */ package mx.model;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class Usuario implements java.io.Serializable
/*     */ {
/*     */   private String nombre;
/*     */   private String correo;
/*     */   private String codigoPerfil;
/*     */   private String codigoDepartamento;
/*     */   private String codigoSap;
/*     */   private String folioUsuario;
/*     */   private String clave;
/*     */   private String asignacion;
/*     */   private String asignacionusd;
/*     */   private Date fechaAlta;
/*     */   private Integer vigencia;
/*     */   private String tarjetaCoorporativa;
/*     */   private String estatus;
/*     */   private String tarjetaGasolina;
/*     */   private String admonPoliza;
/*     */   private Date fechaAcceso;
/*     */   
/*     */   public Usuario() {}
/*     */   
/*     */   public Usuario(String nombre)
/*     */   {
/*  28 */     this.nombre = nombre;
/*     */   }
/*     */   
/*     */   public Usuario(String nombre, String correo, String codigoPerfil, String codigoDepartamento, String codigoSap, String folioUsuario, String clave, String asignacion, String asignacionusd, Date fechaAlta, Integer vigencia, String tarjetaCoorporativa, String estatus, String tarjetaGasolina, String admonPoliza, Date fechaAcceso) {
/*  32 */     this.nombre = nombre;
/*  33 */     this.correo = correo;
/*  34 */     this.codigoPerfil = codigoPerfil;
/*  35 */     this.codigoDepartamento = codigoDepartamento;
/*  36 */     this.codigoSap = codigoSap;
/*  37 */     this.folioUsuario = folioUsuario;
/*  38 */     this.clave = clave;
/*  39 */     this.asignacion = asignacion;
/*  40 */     this.asignacionusd = asignacionusd;
/*  41 */     this.fechaAlta = fechaAlta;
/*  42 */     this.vigencia = vigencia;
/*  43 */     this.tarjetaCoorporativa = tarjetaCoorporativa;
/*  44 */     this.estatus = estatus;
/*  45 */     this.tarjetaGasolina = tarjetaGasolina;
/*  46 */     this.admonPoliza = admonPoliza;
/*  47 */     this.fechaAcceso = fechaAcceso;
/*     */   }
/*     */   
/*     */   public String getNombre() {
/*  51 */     return this.nombre;
/*     */   }
/*     */   
/*     */   public void setNombre(String nombre) {
/*  55 */     this.nombre = nombre;
/*     */   }
/*     */   
/*     */   public String getCorreo() {
/*  59 */     return this.correo;
/*     */   }
/*     */   
/*     */   public void setCorreo(String correo) {
/*  63 */     this.correo = correo;
/*     */   }
/*     */   
/*     */   public String getCodigoPerfil() {
/*  67 */     return this.codigoPerfil;
/*     */   }
/*     */   
/*     */   public void setCodigoPerfil(String codigoPerfil) {
/*  71 */     this.codigoPerfil = codigoPerfil;
/*     */   }
/*     */   
/*     */   public String getCodigoDepartamento() {
/*  75 */     return this.codigoDepartamento;
/*     */   }
/*     */   
/*     */   public void setCodigoDepartamento(String codigoDepartamento) {
/*  79 */     this.codigoDepartamento = codigoDepartamento;
/*     */   }
/*     */   
/*     */   public String getCodigoSap() {
/*  83 */     return this.codigoSap;
/*     */   }
/*     */   
/*     */   public void setCodigoSap(String codigoSap) {
/*  87 */     this.codigoSap = codigoSap;
/*     */   }
/*     */   
/*     */   public String getFolioUsuario() {
/*  91 */     return this.folioUsuario;
/*     */   }
/*     */   
/*     */   public void setFolioUsuario(String folioUsuario) {
/*  95 */     this.folioUsuario = folioUsuario;
/*     */   }
/*     */   
/*     */   public String getClave() {
/*  99 */     return this.clave;
/*     */   }
/*     */   
/*     */   public void setClave(String clave) {
/* 103 */     this.clave = clave;
/*     */   }
/*     */   
/*     */   public String getAsignacion() {
/* 107 */     return this.asignacion;
/*     */   }
/*     */   
/*     */   public void setAsignacion(String asignacion) {
/* 111 */     this.asignacion = asignacion;
/*     */   }
/*     */   
/*     */   public String getAsignacionusd() {
/* 115 */     return this.asignacionusd;
/*     */   }
/*     */   
/*     */   public void setAsignacionusd(String asignacionusd) {
/* 119 */     this.asignacionusd = asignacionusd;
/*     */   }
/*     */   
/*     */   public Date getFechaAlta() {
/* 123 */     return this.fechaAlta;
/*     */   }
/*     */   
/*     */   public void setFechaAlta(Date fechaAlta) {
/* 127 */     this.fechaAlta = fechaAlta;
/*     */   }
/*     */   
/*     */   public Integer getVigencia() {
/* 131 */     return this.vigencia;
/*     */   }
/*     */   
/*     */   public void setVigencia(Integer vigencia) {
/* 135 */     this.vigencia = vigencia;
/*     */   }
/*     */   
/*     */   public String getTarjetaCoorporativa() {
/* 139 */     return this.tarjetaCoorporativa;
/*     */   }
/*     */   
/*     */   public void setTarjetaCoorporativa(String tarjetaCoorporativa) {
/* 143 */     this.tarjetaCoorporativa = tarjetaCoorporativa;
/*     */   }
/*     */   
/*     */   public String getEstatus() {
/* 147 */     return this.estatus;
/*     */   }
/*     */   
/*     */   public void setEstatus(String estatus) {
/* 151 */     this.estatus = estatus;
/*     */   }
/*     */   
/*     */   public String getTarjetaGasolina() {
/* 155 */     return this.tarjetaGasolina;
/*     */   }
/*     */   
/*     */   public void setTarjetaGasolina(String tarjetaGasolina) {
/* 159 */     this.tarjetaGasolina = tarjetaGasolina;
/*     */   }
/*     */   
/*     */   public String getAdmonPoliza() {
/* 163 */     return this.admonPoliza;
/*     */   }
/*     */   
/*     */   public void setAdmonPoliza(String admonPoliza) {
/* 167 */     this.admonPoliza = admonPoliza;
/*     */   }
/*     */   
/*     */   public Date getFechaAcceso() {
/* 171 */     return this.fechaAcceso;
/*     */   }
/*     */   
/*     */   public void setFechaAcceso(Date fechaAcceso) {
/* 175 */     this.fechaAcceso = fechaAcceso;
/*     */   }
/*     */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\model\Usuario.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */