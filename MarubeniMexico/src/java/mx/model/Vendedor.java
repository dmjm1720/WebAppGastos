/*    */ package mx.model;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Vendedor
/*    */   implements Serializable
/*    */ {
/*    */   private String strcvevend;
/*    */   private String correo;
/*    */   private String nombre;
/*    */   
/*    */   public Vendedor() {}
/*    */   
/* 21 */   public Vendedor(String strcvevend) { this.strcvevend = strcvevend; }
/*    */   
/*    */   public Vendedor(String strcvevend, String correo, String nombre) {
/* 24 */     this.strcvevend = strcvevend;
/* 25 */     this.correo = correo;
/* 26 */     this.nombre = nombre;
/*    */   }
/*    */   
/*    */   public String getStrcvevend() {
/* 30 */     return this.strcvevend;
/*    */   }
/*    */   
/*    */   public void setStrcvevend(String strcvevend) {
/* 34 */     this.strcvevend = strcvevend;
/*    */   }
/*    */   
/* 37 */   public String getCorreo() { return this.correo; }
/*    */   
/*    */   public void setCorreo(String correo)
/*    */   {
/* 41 */     this.correo = correo;
/*    */   }
/*    */   
/* 44 */   public String getNombre() { return this.nombre; }
/*    */   
/*    */   public void setNombre(String nombre)
/*    */   {
/* 48 */     this.nombre = nombre;
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\model\Vendedor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */