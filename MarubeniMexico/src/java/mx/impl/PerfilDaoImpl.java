/*    */ package mx.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import javax.faces.context.ExternalContext;
/*    */ import javax.faces.context.FacesContext;
/*    */ import mx.dao.PerfilDao;
/*    */ import mx.model.Concepto;
/*    */ import mx.model.Usuario;
/*    */ import mx.util.HibernateUtil;
/*    */ import org.hibernate.HibernateException;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.SessionFactory;
/*    */ import org.hibernate.Transaction;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PerfilDaoImpl
/*    */   implements PerfilDao
/*    */ {
/*    */   public List<Usuario> listaUsuarios()
/*    */   {
/* 27 */     List<Usuario> lista = null;
/* 28 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/* 29 */     Session session = HibernateUtil.getSessionFactory().openSession();
/* 30 */     Transaction t = session.beginTransaction();
/* 31 */     String hql = "select nombre FROM Usuario WHERE codigoPerfil='Usuario' AND codigoSap='" + us.getCodigoSap() + "'";
/*    */     try {
/* 33 */       lista = session.createQuery(hql).list();
/* 34 */       t.commit();
/* 35 */       session.close();
/*    */     } catch (HibernateException e) {
/* 37 */       t.rollback();
/*    */     }
/* 39 */     return lista;
/*    */   }
/*    */   
/*    */   public List<Concepto> listaModificar()
/*    */   {
/* 44 */     List<Concepto> lista = null;
/* 45 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/* 46 */     Session session = HibernateUtil.getSessionFactory().openSession();
/* 47 */     Transaction t = session.beginTransaction();
/* 48 */     String hql = "select modificarArchivo FROM Concepto WHERE nombreUsuario='" + us.getCodigoSap() + "' AND modificarArchivo='Si'";
/*    */     try {
/* 50 */       lista = session.createQuery(hql).list();
/* 51 */       t.commit();
/* 52 */       session.close();
/*    */     } catch (HibernateException e) {
/* 54 */       t.rollback();
/*    */     }
/* 56 */     return lista;
/*    */   }
/*    */   
/*    */   public List<Usuario> admonPoliza()
/*    */   {
/* 61 */     List<Usuario> lista = null;
/* 62 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/* 63 */     Session session = HibernateUtil.getSessionFactory().openSession();
/* 64 */     Transaction t = session.beginTransaction();
/* 65 */     String hql = "select nombre FROM Usuario WHERE admonPoliza='Si' AND codigoSap='" + us.getCodigoSap() + "'";
/*    */     try {
/* 67 */       lista = session.createQuery(hql).list();
/* 68 */       t.commit();
/* 69 */       session.close();
/*    */     } catch (HibernateException e) {
/* 71 */       t.rollback();
/*    */     }
/* 73 */     return lista;
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\impl\PerfilDaoImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */