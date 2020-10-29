/*     */ package mx.impl;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.faces.application.FacesMessage;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ import mx.dao.ConceptoDetalleDao;
/*     */ import mx.model.Concepto;
/*     */ import mx.model.Usuario;
/*     */ import mx.util.HibernateUtil;
/*     */ import org.hibernate.HibernateException;
/*     */ import org.hibernate.Query;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.SessionFactory;
/*     */ import org.hibernate.Transaction;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ConceptoDetalleDaoImpl
/*     */   implements ConceptoDetalleDao
/*     */ {
/*     */   public List<Concepto> listaConcepto()
/*     */   {
/*  27 */     List<Concepto> lista = null;
/*  28 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/*  29 */     Session session = HibernateUtil.getSessionFactory().openSession();
/*  30 */     Transaction t = session.beginTransaction();
/*  31 */     String hql = "FROM Concepto WHERE nombreUsuario='" + us.getCodigoSap() + "'";
/*     */     try {
/*  33 */       lista = session.createQuery(hql).list();
/*  34 */       t.commit();
/*  35 */       session.close();
/*     */     } catch (Exception e) {
/*  37 */       t.rollback();
/*     */     }
/*  39 */     return lista;
/*     */   }
/*     */   
/*     */ 
/*     */   public void nuevoConcepto(Concepto concepto)
/*     */   {
/*  45 */     Session session = null;
/*     */     try {
/*  47 */       session = HibernateUtil.getSessionFactory().openSession();
/*  48 */       session.beginTransaction();
/*  49 */       session.save(concepto);
/*  50 */       session.getTransaction().commit();
/*  51 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Registro agregado correctamente"));
/*     */     } catch (HibernateException e) {
/*  53 */       System.out.println(e.getMessage());
/*  54 */       session.getTransaction().rollback();
/*     */     } finally {
/*  56 */       if (session != null) {
/*  57 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void updateConcepto(Concepto concepto)
/*     */   {
/*  65 */     Session session = null;
/*     */     try {
/*  67 */       session = HibernateUtil.getSessionFactory().openSession();
/*  68 */       session.beginTransaction();
/*  69 */       session.update(concepto);
/*  70 */       session.getTransaction().commit();
/*  71 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Registro actualizado correctamente"));
/*     */     } catch (HibernateException e) {
/*  73 */       System.out.println(e.getMessage());
/*  74 */       session.getTransaction().rollback();
/*     */     } finally {
/*  76 */       if (session != null) {
/*  77 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void deleteConcepto(Concepto concepto)
/*     */   {
/*  85 */     Session session = null;
/*     */     try {
/*  87 */       session = HibernateUtil.getSessionFactory().openSession();
/*  88 */       session.beginTransaction();
/*  89 */       session.delete(concepto);
/*  90 */       session.getTransaction().commit();
/*  91 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Registro borrado correctamente"));
/*     */     } catch (HibernateException e) {
/*  93 */       System.out.println(e.getMessage());
/*  94 */       session.getTransaction().rollback();
/*     */     } finally {
/*  96 */       if (session != null) {
/*  97 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Usuario> listaPorFolio()
/*     */   {
/* 104 */     List<Usuario> lista = null;
/* 105 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/* 106 */     Session session = HibernateUtil.getSessionFactory().openSession();
/* 107 */     Transaction t = session.beginTransaction();
/* 108 */     String hql = "FROM Usuario WHERE nombre='" + us.getNombre() + "'";
/*     */     try {
/* 110 */       lista = session.createQuery(hql).list();
/* 111 */       t.commit();
/* 112 */       session.close();
/*     */     } catch (HibernateException e) {
/* 114 */       t.rollback();
/*     */     }
/* 116 */     return lista;
/*     */   }
/*     */   
/*     */   public List<Concepto> listaSAT()
/*     */   {
/* 121 */     List<Concepto> lista = null;
/* 122 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/* 123 */     Session session = HibernateUtil.getSessionFactory().openSession();
/* 124 */     Transaction t = session.beginTransaction();
/* 125 */     String hql = "FROM Concepto WHERE nombreUsuario='" + us.getNombre() + "'";
/*     */     try {
/* 127 */       lista = session.createQuery(hql).list();
/* 128 */       t.commit();
/* 129 */       session.close();
/*     */     } catch (HibernateException e) {
/* 131 */       t.rollback();
/*     */     }
/* 133 */     return lista;
/*     */   }
/*     */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\impl\ConceptoDetalleDaoImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */