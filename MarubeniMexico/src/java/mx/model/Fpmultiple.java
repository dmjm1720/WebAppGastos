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
/*    */ public class Fpmultiple
/*    */   implements Serializable
/*    */ {
/*    */   private int id;
/*    */   private String facturas;
/*    */   
/*    */   public Fpmultiple() {}
/*    */   
/* 20 */   public Fpmultiple(int id) { this.id = id; }
/*    */   
/*    */   public Fpmultiple(int id, String facturas) {
/* 23 */     this.id = id;
/* 24 */     this.facturas = facturas;
/*    */   }
/*    */   
/*    */   public int getId() {
/* 28 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(int id) {
/* 32 */     this.id = id;
/*    */   }
/*    */   
/* 35 */   public String getFacturas() { return this.facturas; }
/*    */   
/*    */   public void setFacturas(String facturas)
/*    */   {
/* 39 */     this.facturas = facturas;
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\model\Fpmultiple.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */