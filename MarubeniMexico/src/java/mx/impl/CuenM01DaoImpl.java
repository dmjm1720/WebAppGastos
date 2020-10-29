/*    */ package mx.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import mx.model.Cuenm01;
/*    */ import mx.util.HibernateUtil;
/*    */ import org.hibernate.HibernateException;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.SessionFactory;
/*    */ import org.hibernate.Transaction;
/*    */ 
/*    */ public class CuenM01DaoImpl implements mx.dao.CuenM01Dao
/*    */ {
/*    */   public List<Cuenm01> listaFactura()
/*    */   {
/* 16 */     List<Cuenm01> lista = null;
/* 17 */     Session session = HibernateUtil.getSessionFactory().openSession();
/* 18 */     Transaction transaction = session.beginTransaction();
/* 19 */     String hql = "FROM Cuenm01 WHERE procesado=0";
/*    */     try {
/* 21 */       lista = session.createQuery(hql).list();
/* 22 */       transaction.commit();
/* 23 */       session.close();
/*    */     } catch (HibernateException e) {
/* 25 */       transaction.rollback();
/*    */     }
/* 27 */     return lista;
/*    */   }
/*    */   
/*    */ 
/*    */   public void insertFactf01(Cuenm01 f)
/*    */   {
/* 33 */     Session session = null;
/*    */     try {
/* 35 */       session = HibernateUtil.getSessionFactory().openSession();
/* 36 */       session.beginTransaction();
/* 37 */       session.save(f);
/* 38 */       session.getTransaction().commit();
/*    */     } catch (HibernateException e) {
/* 40 */       System.out.println(e.getMessage());
/* 41 */       session.getTransaction().rollback();
/*    */     } finally {
/* 43 */       if (session != null) {
/* 44 */         session.close();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public void updateFactf01(Cuenm01 f)
/*    */   {
/* 52 */     Session session = null;
/*    */     try {
/* 54 */       session = HibernateUtil.getSessionFactory().openSession();
/* 55 */       session.beginTransaction();
/* 56 */       session.update(f);
/* 57 */       session.getTransaction().commit();
/*    */     } catch (HibernateException e) {
/* 59 */       System.out.println(e.getMessage());
/* 60 */       session.getTransaction().rollback();
/*    */     } finally {
/* 62 */       if (session != null) {
/* 63 */         session.close();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public List<Cuenm01> listaReporte()
/*    */   {
/* 70 */     List<Cuenm01> lista = null;
/* 71 */     Session session = HibernateUtil.getSessionFactory().openSession();
/* 72 */     Transaction transaction = session.beginTransaction();
/* 73 */     String hql = "FROM Cuenm01 WHERE procesado=1";
/*    */     try {
/* 75 */       lista = session.createQuery(hql).list();
/* 76 */       transaction.commit();
/* 77 */       session.close();
/*    */     } catch (HibernateException e) {
/* 79 */       transaction.rollback();
/*    */     }
/* 81 */     return lista;
/*    */   }
/*    */   
/*    */   public List<Cuenm01> lsitaFacturasParciales()
/*    */   {
/* 86 */     List<Cuenm01> lista = null;
/* 87 */     Session session = HibernateUtil.getSessionFactory().openSession();
/* 88 */     Transaction transaction = session.beginTransaction();
/* 89 */     String hql = "FROM Cuenm01 WHERE procesado=1 and pagoParcial=1";
/*    */     try {
/* 91 */       lista = session.createQuery(hql).list();
/* 92 */       transaction.commit();
/* 93 */       session.close();
/*    */     } catch (HibernateException e) {
/* 95 */       transaction.rollback();
/*    */     }
/* 97 */     return lista;
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\impl\CuenM01DaoImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */