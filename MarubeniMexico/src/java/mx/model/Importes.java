/*    */ package mx.model;
/*    */ 
/*    */ public class Importes
/*    */ {
/*    */   private Double mxn;
/*    */   private Double usd;
/*    */   
/*    */   public Importes() {}
/*    */   
/*    */   public Importes(Double mxn, Double usd)
/*    */   {
/* 12 */     this.mxn = mxn;
/* 13 */     this.usd = usd;
/*    */   }
/*    */   
/*    */   public Double getMxn() {
/* 17 */     return this.mxn;
/*    */   }
/*    */   
/*    */   public void setMxn(Double mxn) {
/* 21 */     this.mxn = mxn;
/*    */   }
/*    */   
/*    */   public Double getUsd() {
/* 25 */     return this.usd;
/*    */   }
/*    */   
/*    */   public void setUsd(Double usd) {
/* 29 */     this.usd = usd;
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\model\Importes.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */