/*     */ package mx.impl;
/*     */ 
/*     */ import java.util.List;
/*     */ import javax.faces.application.FacesMessage;
/*     */ import javax.faces.context.FacesContext;
/*     */ import mx.model.Polizapagos;
/*     */ import mx.util.HibernateUtil;
/*     */ import org.hibernate.HibernateException;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.SessionFactory;
/*     */ import org.hibernate.Transaction;
/*     */ 
/*     */ public class PolizasPagosDaoImpl implements mx.dao.PolizaPagosDao
/*     */ {
/*     */   public List<Polizapagos> listaPolizas()
/*     */   {
/*  17 */     List<Polizapagos> lista = null;
/*  18 */     Session session = HibernateUtil.getSessionFactory().openSession();
/*  19 */     Transaction t = session.beginTransaction();
/*  20 */     String hql = "FROM Polizapagos";
/*     */     try {
/*  22 */       lista = session.createQuery(hql).list();
/*  23 */       t.commit();
/*  24 */       session.close();
/*     */     } catch (HibernateException e) {
/*  26 */       t.rollback();
/*     */     }
/*  28 */     return lista;
/*     */   }
/*     */   
/*     */ 
/*     */   public void newPolizas(Polizapagos p)
/*     */   {
/*  34 */     Session session = null;
/*     */     try {
/*  36 */       session = HibernateUtil.getSessionFactory().openSession();
/*  37 */       session.beginTransaction();
/*  38 */       session.save(p);
/*  39 */       session.getTransaction().commit();
/*     */     }
/*     */     catch (HibernateException e) {
/*  42 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE PAGOS", "Error al guardar registro"));
/*  43 */       session.getTransaction().rollback();
/*     */     } finally {
/*  45 */       if (session != null) {
/*  46 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void updatePolizas(Polizapagos p)
/*     */   {
/*  54 */     Session session = null;
/*     */     try {
/*  56 */       session = HibernateUtil.getSessionFactory().openSession();
/*  57 */       session.beginTransaction();
/*  58 */       session.update(p);
/*  59 */       session.getTransaction().commit();
/*     */     }
/*     */     catch (HibernateException e) {
/*  62 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE PAGOS", "Error al actualizar registro"));
/*  63 */       session.getTransaction().rollback();
/*     */     } finally {
/*  65 */       if (session != null) {
/*  66 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void deletePolizas(Polizapagos p)
/*     */   {
/*  74 */     Session session = null;
/*     */     try {
/*  76 */       session = HibernateUtil.getSessionFactory().openSession();
/*  77 */       session.beginTransaction();
/*  78 */       session.delete(p);
/*  79 */       session.getTransaction().commit();
/*     */     }
/*     */     catch (HibernateException e) {
/*  82 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE PAGOS", "Error al borrar registro"));
/*  83 */       session.getTransaction().rollback();
/*     */     } finally {
/*  85 */       if (session != null) {
/*  86 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public List<String> listarFoliosPoliza()
/*     */   {
/*  93 */     List<String> lista = null;
/*  94 */     Session session = HibernateUtil.getSessionFactory().openSession();
/*  95 */     Transaction t = session.beginTransaction();
/*  96 */     String hql = "SELECT DISTINCT userFolio FROM Polizapagos WHERE processed=0 order by userFolio DESC";
/*     */     try {
/*  98 */       lista = session.createQuery(hql).list();
/*  99 */       t.commit();
/* 100 */       session.close();
/*     */     } catch (HibernateException e) {
/* 102 */       t.rollback();
/*     */     }
/* 104 */     return lista;
/*     */   }
/*     */   
/*     */   public List<Polizapagos> listaFoliosPendientes()
/*     */   {
/* 109 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\impl\PolizasPagosDaoImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */