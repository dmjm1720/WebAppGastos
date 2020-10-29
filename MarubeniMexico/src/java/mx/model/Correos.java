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
/*    */ public class Correos
/*    */   implements Serializable
/*    */ {
/*    */   private int id;
/*    */   private String strcvevend;
/*    */   private String correoAsociado;
/*    */   
/*    */   public Correos() {}
/*    */   
/* 21 */   public Correos(int id) { this.id = id; }
/*    */   
/*    */   public Correos(int id, String strcvevend, String correoAsociado) {
/* 24 */     this.id = id;
/* 25 */     this.strcvevend = strcvevend;
/* 26 */     this.correoAsociado = correoAsociado;
/*    */   }
/*    */   
/*    */   public int getId() {
/* 30 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(int id) {
/* 34 */     this.id = id;
/*    */   }
/*    */   
/* 37 */   public String getStrcvevend() { return this.strcvevend; }
/*    */   
/*    */   public void setStrcvevend(String strcvevend)
/*    */   {
/* 41 */     this.strcvevend = strcvevend;
/*    */   }
/*    */   
/* 44 */   public String getCorreoAsociado() { return this.correoAsociado; }
/*    */   
/*    */   public void setCorreoAsociado(String correoAsociado)
/*    */   {
/* 48 */     this.correoAsociado = correoAsociado;
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\model\Correos.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */