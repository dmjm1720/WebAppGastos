/*     */ package mx.impl;
/*     */ 
/*     */ import java.util.List;
/*     */ import javax.faces.application.FacesMessage;
/*     */ import javax.faces.context.FacesContext;
/*     */ import mx.model.Concepto;
/*     */ import mx.model.Usuario;
/*     */ import mx.util.HibernateUtil;
/*     */ import org.hibernate.HibernateException;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.SessionFactory;
/*     */ import org.hibernate.Transaction;
/*     */ 
/*     */ public class PolizaDaoImpl implements mx.dao.PolizaDao
/*     */ {
/*     */   public List<Concepto> listaConcepto()
/*     */   {
/*  18 */     List<Concepto> lista = null;
/*  19 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/*  20 */     Session session = HibernateUtil.getSessionFactory().openSession();
/*  21 */     Transaction t = session.beginTransaction();
/*  22 */     String hql = "FROM Concepto";
/*     */     try {
/*  24 */       lista = session.createQuery(hql).list();
/*  25 */       t.commit();
/*  26 */       session.close();
/*     */     } catch (HibernateException e) {
/*  28 */       t.rollback();
/*     */     }
/*  30 */     return lista;
/*     */   }
/*     */   
/*     */ 
/*     */   public void nuevoConcepto(Concepto concepto)
/*     */   {
/*  36 */     Session session = null;
/*     */     try {
/*  38 */       session = HibernateUtil.getSessionFactory().openSession();
/*  39 */       session.beginTransaction();
/*  40 */       session.save(concepto);
/*  41 */       session.getTransaction().commit();
/*  42 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Registro agregado correctamente"));
/*     */     } catch (HibernateException e) {
/*  44 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE GASTOS", "Factura o UUID duplicado"));
/*  45 */       session.getTransaction().rollback();
/*     */     } finally {
/*  47 */       if (session != null) {
/*  48 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void updateConcepto(Concepto concepto)
/*     */   {
/*  56 */     Session session = null;
/*     */     try {
/*  58 */       session = HibernateUtil.getSessionFactory().openSession();
/*  59 */       session.beginTransaction();
/*  60 */       session.update(concepto);
/*  61 */       session.getTransaction().commit();
/*  62 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Registro actualizado correctamente"));
/*     */     } catch (HibernateException e) {
/*  64 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE GASTOS", "Factura o UUID duplicado"));
/*  65 */       session.getTransaction().rollback();
/*     */     } finally {
/*  67 */       if (session != null) {
/*  68 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void deleteConcepto(Concepto concepto)
/*     */   {
/*  76 */     Session session = null;
/*     */     try {
/*  78 */       session = HibernateUtil.getSessionFactory().openSession();
/*  79 */       session.beginTransaction();
/*  80 */       session.delete(concepto);
/*  81 */       session.getTransaction().commit();
/*  82 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Registro borrado correctamente"));
/*     */     } catch (HibernateException e) {
/*  84 */       System.out.println(e.getMessage());
/*  85 */       session.getTransaction().rollback();
/*     */     } finally {
/*  87 */       if (session != null) {
/*  88 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Usuario> listaporNombre()
/*     */   {
/*  95 */     List<Usuario> lista = null;
/*  96 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/*  97 */     Session session = HibernateUtil.getSessionFactory().openSession();
/*  98 */     Transaction t = session.beginTransaction();
/*  99 */     String hql = "FROM Usuario WHERE nombre='" + us.getNombre() + "'";
/*     */     try {
/* 101 */       lista = session.createQuery(hql).list();
/*     */       
/* 103 */       t.commit();
/* 104 */       session.close();
/*     */     } catch (HibernateException e) {
/* 106 */       t.rollback();
/*     */     }
/* 108 */     return lista;
/*     */   }
/*     */   
/*     */   public List<Concepto> listaConceptoUSD()
/*     */   {
/* 113 */     List<Concepto> lista = null;
/* 114 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/* 115 */     Session session = HibernateUtil.getSessionFactory().openSession();
/* 116 */     Transaction t = session.beginTransaction();
/*     */     
/* 118 */     String hql = "FROM Concepto WHERE nombreUsuario='" + us.getCodigoSap() + "'  AND nombreConcepto='Avión' AND tipo='Extranjero' AND estado='Agregar' ORDER BY idConcepto DESC";
/*     */     try {
/* 120 */       lista = session.createQuery(hql).list();
/* 121 */       t.commit();
/* 122 */       session.close();
/*     */     } catch (HibernateException e) {
/* 124 */       t.rollback();
/*     */     }
/* 126 */     return lista;
/*     */   }
/*     */   
/*     */   public List<Concepto> listaSAT()
/*     */   {
/* 131 */     List<Concepto> lista = null;
/* 132 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/* 133 */     Session session = HibernateUtil.getSessionFactory().openSession();
/* 134 */     Transaction t = session.beginTransaction();
/* 135 */     String hql = "SELECT  comentario FROM Concepto WHERE comentario like'RFC INVALIDO%' AND nombreUsuario='" + us.getCodigoSap() + "' AND Estado='Agregar'  ORDER BY idConcepto DESC";
/*     */     try {
/* 137 */       lista = session.createQuery(hql).list();
/* 138 */       t.commit();
/* 139 */       session.close();
/*     */     } catch (HibernateException e) {
/* 141 */       t.rollback();
/*     */     }
/* 143 */     return lista;
/*     */   }
/*     */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\impl\PolizaDaoImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */