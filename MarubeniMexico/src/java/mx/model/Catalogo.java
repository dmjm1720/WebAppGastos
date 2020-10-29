/*    */ package mx.model;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class Catalogo implements Serializable {
/*    */   private int id;
/*    */   private String subcuenta;
/*    */   private String cliente;
/*    */   
/*    */   public Catalogo() {}
/*    */   
/*    */   public Catalogo(int id) {
/* 13 */     this.id = id;
/*    */   }
/*    */   
/*    */   public Catalogo(int id, String subcuenta, String cliente) {
/* 17 */     this.id = id;
/* 18 */     this.subcuenta = subcuenta;
/* 19 */     this.cliente = cliente;
/*    */   }
/*    */   
/*    */   public int getId() {
/* 23 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(int id) {
/* 27 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getSubcuenta() {
/* 31 */     return this.subcuenta;
/*    */   }
/*    */   
/*    */   public void setSubcuenta(String subcuenta) {
/* 35 */     this.subcuenta = subcuenta;
/*    */   }
/*    */   
/*    */   public String getCliente() {
/* 39 */     return this.cliente;
/*    */   }
/*    */   
/*    */   public void setCliente(String cliente) {
/* 43 */     this.cliente = cliente;
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\model\Catalogo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */