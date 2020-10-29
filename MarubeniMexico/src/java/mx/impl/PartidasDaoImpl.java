/*    */ package mx.impl;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import javax.faces.context.FacesContext;
/*    */ import mx.model.Partidas;
/*    */ import mx.model.Usuario;
/*    */ import mx.util.HibernateUtil;
/*    */ import org.hibernate.HibernateException;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.SessionFactory;
/*    */ import org.hibernate.Transaction;
/*    */ 
/*    */ public class PartidasDaoImpl implements mx.dao.PartidasDao
/*    */ {
/*    */   public java.util.List<Partidas> listaPartidas()
/*    */   {
/* 17 */     java.util.List<Partidas> lista = null;
/* 18 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/* 19 */     Session session = HibernateUtil.getSessionFactory().openSession();
/* 20 */     Transaction t = session.beginTransaction();
/* 21 */     String SQL = "FROM Partidas";
/*    */     try {
/* 23 */       lista = session.createQuery(SQL).list();
/* 24 */       t.commit();
/* 25 */       session.close();
/*    */     } catch (HibernateException e) {
/* 27 */       t.rollback();
/*    */     }
/* 29 */     return lista;
/*    */   }
/*    */   
/*    */ 
/*    */   public void nuevaPartida(Partidas partidas)
/*    */   {
/* 35 */     Session session = null;
/*    */     try {
/* 37 */       session = HibernateUtil.getSessionFactory().openSession();
/* 38 */       session.beginTransaction();
/* 39 */       session.save(partidas);
/* 40 */       session.getTransaction().commit();
/*    */     }
/*    */     catch (HibernateException e)
/*    */     {
/* 44 */       session.getTransaction().rollback();
/*    */     } finally {
/* 46 */       if (session != null) {
/* 47 */         session.close();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public void actualizarPartida(Partidas partidas)
/*    */   {
/* 55 */     Session session = null;
/*    */     try {
/* 57 */       session = HibernateUtil.getSessionFactory().openSession();
/* 58 */       session.beginTransaction();
/* 59 */       session.update(partidas);
/* 60 */       session.getTransaction().commit();
/*    */     }
/*    */     catch (HibernateException e) {
/* 63 */       System.out.println(e.getMessage());
/* 64 */       session.getTransaction().rollback();
/*    */     } finally {
/* 66 */       if (session != null) {
/* 67 */         session.close();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public void updatePartida(Partidas partidas)
/*    */   {
/* 75 */     Session session = null;
/*    */     try {
/* 77 */       session = HibernateUtil.getSessionFactory().openSession();
/* 78 */       session.beginTransaction();
/* 79 */       session.delete(partidas);
/* 80 */       session.getTransaction().commit();
/*    */     }
/*    */     catch (HibernateException e) {
/* 83 */       System.out.println(e.getMessage());
/* 84 */       session.getTransaction().rollback();
/*    */     } finally {
/* 86 */       if (session != null) {
/* 87 */         session.close();
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\impl\PartidasDaoImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */