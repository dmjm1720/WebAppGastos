/*    */ package mx.impl;
/*    */ 
/*    */ import javax.faces.application.FacesMessage;
/*    */ import javax.faces.context.FacesContext;
/*    */ import mx.dao.RegistrarDao;
/*    */ import mx.model.Concepto;
/*    */ import org.hibernate.HibernateException;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.SessionFactory;
/*    */ import org.hibernate.Transaction;
/*    */ 
/*    */ public class RegistrarDaoImpl implements RegistrarDao
/*    */ {
/*    */   public void newUsuario(Concepto concepto)
/*    */   {
/* 16 */     Session session = null;
/*    */     try {
/* 18 */       session = mx.util.HibernateUtil.getSessionFactory().openSession();
/* 19 */       session.beginTransaction();
/* 20 */       session.save(concepto);
/* 21 */       session.getTransaction().commit();
/* 22 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Usuario agregado correctamente"));
/*    */     } catch (HibernateException e) {
/* 24 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "SISTEMA DE GASTOS", "El usuario ya existe"));
/* 25 */       session.getTransaction().rollback();
/*    */     } finally {
/* 27 */       if (session != null) {
/* 28 */         session.close();
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\impl\RegistrarDaoImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */