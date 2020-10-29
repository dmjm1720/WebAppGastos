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
/*    */ public class Categoria
/*    */   implements Serializable
/*    */ {
/*    */   private int idCategoria;
/*    */   private String subDepartamento;
/*    */   private String usuario;
/*    */   
/*    */   public Categoria() {}
/*    */   
/* 21 */   public Categoria(int idCategoria) { this.idCategoria = idCategoria; }
/*    */   
/*    */   public Categoria(int idCategoria, String subDepartamento, String usuario) {
/* 24 */     this.idCategoria = idCategoria;
/* 25 */     this.subDepartamento = subDepartamento;
/* 26 */     this.usuario = usuario;
/*    */   }
/*    */   
/*    */   public int getIdCategoria() {
/* 30 */     return this.idCategoria;
/*    */   }
/*    */   
/*    */   public void setIdCategoria(int idCategoria) {
/* 34 */     this.idCategoria = idCategoria;
/*    */   }
/*    */   
/* 37 */   public String getSubDepartamento() { return this.subDepartamento; }
/*    */   
/*    */   public void setSubDepartamento(String subDepartamento)
/*    */   {
/* 41 */     this.subDepartamento = subDepartamento;
/*    */   }
/*    */   
/* 44 */   public String getUsuario() { return this.usuario; }
/*    */   
/*    */   public void setUsuario(String usuario)
/*    */   {
/* 48 */     this.usuario = usuario;
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\model\Categoria.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */