/*    */ package mx.model;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ 
/*    */ public class Propina
/*    */ {
/*    */   private BigDecimal prop;
/*    */   
/*    */   public Propina() {}
/*    */   
/*    */   public Propina(BigDecimal prop)
/*    */   {
/* 13 */     this.prop = prop;
/*    */   }
/*    */   
/*    */   public BigDecimal getProp() {
/* 17 */     return this.prop;
/*    */   }
/*    */   
/*    */   public void setProp(BigDecimal prop) {
/* 21 */     this.prop = prop;
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\model\Propina.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */