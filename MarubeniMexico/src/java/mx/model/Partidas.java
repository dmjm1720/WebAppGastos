/*    */ package mx.model;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ 
/*    */ public class Partidas implements java.io.Serializable
/*    */ {
/*    */   private int id;
/*    */   private String descripcion;
/*    */   private String uuid;
/*    */   private BigDecimal precioUnitario;
/*    */   private String cantidad;
/*    */   private String unidad;
/*    */   private String claveUnidad;
/*    */   private BigDecimal importe;
/*    */   
/*    */   public Partidas() {}
/*    */   
/*    */   public Partidas(int id)
/*    */   {
/* 20 */     this.id = id;
/*    */   }
/*    */   
/*    */   public Partidas(int id, String descripcion, String uuid, BigDecimal precioUnitario, String cantidad, String unidad, String claveUnidad, BigDecimal importe) {
/* 24 */     this.id = id;
/* 25 */     this.descripcion = descripcion;
/* 26 */     this.uuid = uuid;
/* 27 */     this.precioUnitario = precioUnitario;
/* 28 */     this.cantidad = cantidad;
/* 29 */     this.unidad = unidad;
/* 30 */     this.claveUnidad = claveUnidad;
/* 31 */     this.importe = importe;
/*    */   }
/*    */   
/*    */   public int getId() {
/* 35 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(int id) {
/* 39 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getDescripcion() {
/* 43 */     return this.descripcion;
/*    */   }
/*    */   
/*    */   public void setDescripcion(String descripcion) {
/* 47 */     this.descripcion = descripcion;
/*    */   }
/*    */   
/*    */   public String getUuid() {
/* 51 */     return this.uuid;
/*    */   }
/*    */   
/*    */   public void setUuid(String uuid) {
/* 55 */     this.uuid = uuid;
/*    */   }
/*    */   
/*    */   public BigDecimal getPrecioUnitario() {
/* 59 */     return this.precioUnitario;
/*    */   }
/*    */   
/*    */   public void setPrecioUnitario(BigDecimal precioUnitario) {
/* 63 */     this.precioUnitario = precioUnitario;
/*    */   }
/*    */   
/*    */   public String getCantidad() {
/* 67 */     return this.cantidad;
/*    */   }
/*    */   
/*    */   public void setCantidad(String cantidad) {
/* 71 */     this.cantidad = cantidad;
/*    */   }
/*    */   
/*    */   public String getUnidad() {
/* 75 */     return this.unidad;
/*    */   }
/*    */   
/*    */   public void setUnidad(String unidad) {
/* 79 */     this.unidad = unidad;
/*    */   }
/*    */   
/*    */   public String getClaveUnidad() {
/* 83 */     return this.claveUnidad;
/*    */   }
/*    */   
/*    */   public void setClaveUnidad(String claveUnidad) {
/* 87 */     this.claveUnidad = claveUnidad;
/*    */   }
/*    */   
/*    */   public BigDecimal getImporte() {
/* 91 */     return this.importe;
/*    */   }
/*    */   
/*    */   public void setImporte(BigDecimal importe) {
/* 95 */     this.importe = importe;
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\model\Partidas.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */