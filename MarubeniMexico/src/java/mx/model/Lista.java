/*    */ package mx.model;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class Lista implements Serializable {
/*    */   private String conceptos;
/*    */   private Integer idConcepto;
/*    */   private String descripcion;
/*    */   
/*    */   public Lista() {}
/*    */   
/*    */   public Lista(String conceptos) {
/* 13 */     this.conceptos = conceptos;
/*    */   }
/*    */   
/*    */   public Lista(String conceptos, Integer idConcepto, String descripcion) {
/* 17 */     this.conceptos = conceptos;
/* 18 */     this.idConcepto = idConcepto;
/* 19 */     this.descripcion = descripcion;
/*    */   }
/*    */   
/*    */   public String getConceptos() {
/* 23 */     return this.conceptos;
/*    */   }
/*    */   
/*    */   public void setConceptos(String conceptos) {
/* 27 */     this.conceptos = conceptos;
/*    */   }
/*    */   
/*    */   public Integer getIdConcepto() {
/* 31 */     return this.idConcepto;
/*    */   }
/*    */   
/*    */   public void setIdConcepto(Integer idConcepto) {
/* 35 */     this.idConcepto = idConcepto;
/*    */   }
/*    */   
/*    */   public String getDescripcion() {
/* 39 */     return this.descripcion;
/*    */   }
/*    */   
/*    */   public void setDescripcion(String descripcion) {
/* 43 */     this.descripcion = descripcion;
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\model\Lista.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */