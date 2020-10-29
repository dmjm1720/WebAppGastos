/*    */ package mx.model;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class Foliopoliza implements java.io.Serializable
/*    */ {
/*    */   private int idpol;
/*    */   private Date fechaPoliza;
/*    */   private String usuario;
/*    */   
/*    */   public Foliopoliza() {}
/*    */   
/*    */   public Foliopoliza(int idpol)
/*    */   {
/* 15 */     this.idpol = idpol;
/*    */   }
/*    */   
/*    */   public Foliopoliza(int idpol, Date fechaPoliza, String usuario) {
/* 19 */     this.idpol = idpol;
/* 20 */     this.fechaPoliza = fechaPoliza;
/* 21 */     this.usuario = usuario;
/*    */   }
/*    */   
/*    */   public int getIdpol() {
/* 25 */     return this.idpol;
/*    */   }
/*    */   
/*    */   public void setIdpol(int idpol) {
/* 29 */     this.idpol = idpol;
/*    */   }
/*    */   
/*    */   public Date getFechaPoliza() {
/* 33 */     return this.fechaPoliza;
/*    */   }
/*    */   
/*    */   public void setFechaPoliza(Date fechaPoliza) {
/* 37 */     this.fechaPoliza = fechaPoliza;
/*    */   }
/*    */   
/*    */   public String getUsuario() {
/* 41 */     return this.usuario;
/*    */   }
/*    */   
/*    */   public void setUsuario(String usuario) {
/* 45 */     this.usuario = usuario;
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\model\Foliopoliza.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */