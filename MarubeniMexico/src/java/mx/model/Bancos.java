/*    */ package mx.model;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class Bancos implements Serializable {
/*    */   private int id;
/*    */   private String nombre;
/*    */   private String cuenta;
/*    */   private String subcuenta;
/*    */   private String moneda;
/*    */   
/*    */   public Bancos() {}
/*    */   
/*    */   public Bancos(int id) {
/* 15 */     this.id = id;
/*    */   }
/*    */   
/*    */   public Bancos(int id, String nombre, String cuenta, String subcuenta, String moneda) {
/* 19 */     this.id = id;
/* 20 */     this.nombre = nombre;
/* 21 */     this.cuenta = cuenta;
/* 22 */     this.subcuenta = subcuenta;
/* 23 */     this.moneda = moneda;
/*    */   }
/*    */   
/*    */   public int getId() {
/* 27 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(int id) {
/* 31 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getNombre() {
/* 35 */     return this.nombre;
/*    */   }
/*    */   
/*    */   public void setNombre(String nombre) {
/* 39 */     this.nombre = nombre;
/*    */   }
/*    */   
/*    */   public String getCuenta() {
/* 43 */     return this.cuenta;
/*    */   }
/*    */   
/*    */   public void setCuenta(String cuenta) {
/* 47 */     this.cuenta = cuenta;
/*    */   }
/*    */   
/*    */   public String getSubcuenta() {
/* 51 */     return this.subcuenta;
/*    */   }
/*    */   
/*    */   public void setSubcuenta(String subcuenta) {
/* 55 */     this.subcuenta = subcuenta;
/*    */   }
/*    */   
/*    */   public String getMoneda() {
/* 59 */     return this.moneda;
/*    */   }
/*    */   
/*    */   public void setMoneda(String moneda) {
/* 63 */     this.moneda = moneda;
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\model\Bancos.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */