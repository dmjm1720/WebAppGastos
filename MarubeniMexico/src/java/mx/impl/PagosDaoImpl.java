/*     */ package mx.impl;
/*     */ 
/*     */ import java.util.List;
/*     */ import mx.model.Pagos;
/*     */ import mx.util.HibernateUtil;
/*     */ import org.hibernate.HibernateException;
/*     */ import org.hibernate.Query;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.SessionFactory;
/*     */ import org.hibernate.Transaction;
/*     */ 
/*     */ public class PagosDaoImpl implements mx.dao.PagosDao
/*     */ {
/*     */   public List<Pagos> listaFactura()
/*     */   {
/*  16 */     List<Pagos> lista = null;
/*  17 */     Session session = HibernateUtil.getSessionFactory().openSession();
/*  18 */     Transaction transaction = session.beginTransaction();
/*     */     
/*  20 */     String hql = "FROM Pagos WHERE procesado=0";
/*     */     try {
/*  22 */       lista = session.createQuery(hql).list();
/*  23 */       transaction.commit();
/*  24 */       session.close();
/*     */     } catch (HibernateException e) {
/*  26 */       transaction.rollback();
/*     */     }
/*  28 */     return lista;
/*     */   }
/*     */   
/*     */ 
/*     */   public void insertFactf01(Pagos p)
/*     */   {
/*  34 */     Session session = null;
/*     */     try {
/*  36 */       session = HibernateUtil.getSessionFactory().openSession();
/*  37 */       session.beginTransaction();
/*  38 */       session.save(p);
/*  39 */       session.getTransaction().commit();
/*     */     } catch (HibernateException e) {
/*  41 */       System.out.println(e.getMessage());
/*  42 */       session.getTransaction().rollback();
/*     */     } finally {
/*  44 */       if (session != null) {
/*  45 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void updateFactf01(int folio, String p)
/*     */   {
/*  53 */     Session session = HibernateUtil.getSessionFactory().openSession();
/*  54 */     Transaction t = session.beginTransaction();
/*  55 */     String hql = "UPDATE Pagos SET Enviado=:p WHERE pagoMultiple=:folio";
/*  56 */     Query q = session.createQuery(hql);
/*  57 */     q.setParameter("p", p);
/*  58 */     q.setParameter("folio", Integer.valueOf(folio));
/*     */     try {
/*  60 */       q.executeUpdate();
/*  61 */       t.commit();
/*  62 */       session.close();
/*     */     } catch (HibernateException e) {
/*  64 */       t.rollback();
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Pagos> listarFacturasEnvioCorreos()
/*     */   {
/*  70 */     List<Pagos> lista = null;
/*  71 */     Session session = HibernateUtil.getSessionFactory().openSession();
/*  72 */     Transaction t = session.beginTransaction();
/*  73 */     String hql = "FROM Pagos WHERE enviado IS NULL";
/*     */     try {
/*  75 */       lista = session.createQuery(hql).list();
/*  76 */       t.commit();
/*  77 */       session.close();
/*     */     } catch (HibernateException e) {
/*  79 */       t.rollback();
/*     */     }
/*  81 */     return lista;
/*     */   }
/*     */   
/*     */   public List<Pagos> listarFacturasSeleccionadas()
/*     */   {
/*  86 */     List<Pagos> lista = null;
/*  87 */     Session session = HibernateUtil.getSessionFactory().openSession();
/*  88 */     Transaction t = session.beginTransaction();
/*  89 */     String hql = "FROM Pagos WHERE enviado='NO'";
/*     */     try {
/*  91 */       lista = session.createQuery(hql).list();
/*  92 */       t.commit();
/*  93 */       session.close();
/*     */     } catch (HibernateException e) {
/*  95 */       t.rollback();
/*     */     }
/*  97 */     return lista;
/*     */   }
/*     */   
/*     */   public List<String> listaUsuariosAvisoPago()
/*     */   {
/* 102 */     List<String> lista = null;
/* 103 */     Session session = HibernateUtil.getSessionFactory().openSession();
/* 104 */     Transaction t = session.beginTransaction();
/* 105 */     String hql = "SELECT DISTINCT strcvevend FROM Pagos WHERE enviado='NO' ";
/*     */     try {
/* 107 */       lista = session.createQuery(hql).list();
/* 108 */       t.commit();
/* 109 */       session.close();
/*     */     } catch (HibernateException e) {
/* 111 */       t.rollback();
/*     */     }
/* 113 */     return lista;
/*     */   }
/*     */   
/*     */   public void updateEnvio(String vendedor)
/*     */   {
/* 118 */     Session session = HibernateUtil.getSessionFactory().openSession();
/* 119 */     Transaction t = session.beginTransaction();
/* 120 */     String hql = "UPDATE Pagos SET Enviado='SI' WHERE strcvevend=:vendedor AND Enviado='NO'";
/* 121 */     Query q = session.createQuery(hql);
/* 122 */     q.setParameter("vendedor", vendedor);
/*     */     try
/*     */     {
/* 125 */       q.executeUpdate();
/* 126 */       t.commit();
/* 127 */       session.close();
/*     */     } catch (HibernateException e) {
/* 129 */       t.rollback();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\impl\PagosDaoImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */