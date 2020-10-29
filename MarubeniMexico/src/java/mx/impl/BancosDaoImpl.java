/*    */ package mx.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import mx.model.Bancos;
/*    */ import org.hibernate.HibernateException;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.SessionFactory;
/*    */ import org.hibernate.Transaction;
/*    */ 
/*    */ public class BancosDaoImpl implements mx.dao.BancosDao
/*    */ {
/*    */   public List<Bancos> listaBancos()
/*    */   {
/* 15 */     List<Bancos> lista = null;
/* 16 */     Session session = mx.util.HibernateUtil.getSessionFactory().openSession();
/* 17 */     Transaction t = session.beginTransaction();
/* 18 */     String SQL = "FROM Bancos";
/*    */     try {
/* 20 */       lista = session.createQuery(SQL).list();
/* 21 */       t.commit();
/* 22 */       session.close();
/*    */     } catch (HibernateException e) {
/* 24 */       t.rollback();
/*    */     }
/* 26 */     return lista;
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\impl\BancosDaoImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */