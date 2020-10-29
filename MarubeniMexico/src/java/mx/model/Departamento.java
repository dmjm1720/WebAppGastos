/*    */ package mx.model;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Departamento
/*    */   implements Serializable
/*    */ {
/*    */   private String codigoDep;
/*    */   
/*    */   public Departamento() {}
/*    */   
/*    */   public Departamento(String codigoDep)
/*    */   {
/* 18 */     this.codigoDep = codigoDep;
/*    */   }
/*    */   
/*    */   public String getCodigoDep() {
/* 22 */     return this.codigoDep;
/*    */   }
/*    */   
/*    */   public void setCodigoDep(String codigoDep) {
/* 26 */     this.codigoDep = codigoDep;
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\model\Departamento.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */