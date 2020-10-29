/*    */ package mx.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import mx.model.Polizapagos;
/*    */ import org.hibernate.HibernateException;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.SessionFactory;
/*    */ import org.hibernate.Transaction;
/*    */ 
/*    */ public class PolPagosDaoImpl implements mx.dao.PolPagosDao
/*    */ {
/*    */   public List<Polizapagos> listaRepPol(String p)
/*    */   {
/* 15 */     List<Polizapagos> lista = null;
/* 16 */     Session session = mx.util.HibernateUtil.getSessionFactory().openSession();
/* 17 */     Transaction t = session.beginTransaction();
/* 18 */     String hql = "FROM Polizapagos WHERE userFolio='" + p + "'";
/*    */     try {
/* 20 */       lista = session.createQuery(hql).list();
/* 21 */       t.commit();
/* 22 */       session.close();
/*    */     } catch (HibernateException e) {
/* 24 */       t.rollback();
/*    */     }
/* 26 */     return lista;
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\impl\PolPagosDaoImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */