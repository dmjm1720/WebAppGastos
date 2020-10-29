/*    */ package mx.impl;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.hibernate.HibernateException;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.SessionFactory;
/*    */ import org.hibernate.Transaction;
/*    */ 
/*    */ public class CorreosDaoImpl implements mx.dao.CorreosDao
/*    */ {
/*    */   public List<String> listaCorreos(String clave)
/*    */   {
/* 14 */     List<String> lista = null;
/* 15 */     Session session = mx.util.HibernateUtil.getSessionFactory().openSession();
/* 16 */     Transaction t = session.beginTransaction();
/* 17 */     String SQL = "SELECT correoAsociado FROM Correos where strcvevend='" + clave + "'";
/*    */     try {
/* 19 */       lista = session.createQuery(SQL).list();
/* 20 */       t.commit();
/* 21 */       session.close();
/*    */     } catch (HibernateException e) {
/* 23 */       t.rollback();
/*    */     }
/* 25 */     return lista;
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\impl\CorreosDaoImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */