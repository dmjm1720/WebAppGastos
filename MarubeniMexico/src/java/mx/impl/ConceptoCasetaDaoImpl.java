/*     */ package mx.impl;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.faces.application.FacesMessage;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ import mx.dao.ConceptoCasetaDao;
/*     */ import mx.model.Concepto;
/*     */ import mx.model.Usuario;
/*     */ import mx.util.HibernateUtil;
/*     */ import org.hibernate.Query;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.SessionFactory;
/*     */ import org.hibernate.Transaction;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ConceptoCasetaDaoImpl
/*     */   implements ConceptoCasetaDao
/*     */ {
/*     */   public List<Concepto> listaConcepto()
/*     */   {
/*  26 */     List<Concepto> lista = null;
/*  27 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/*  28 */     Session session = HibernateUtil.getSessionFactory().openSession();
/*  29 */     Transaction t = session.beginTransaction();
/*  30 */     String hql = "FROM Concepto WHERE nombreUsuario='" + us.getCodigoSap() + "'  AND nombreConcepto='Caseta' AND tipo='Nacional' AND estado='Agregar' ORDER BY idConcepto DESC";
/*     */     try {
/*  32 */       lista = session.createQuery(hql).list();
/*  33 */       t.commit();
/*  34 */       session.close();
/*     */     } catch (Exception e) {
/*  36 */       t.rollback();
/*     */     }
/*  38 */     return lista;
/*     */   }
/*     */   
/*     */   public void nuevoConcepto(Concepto concepto)
/*     */   {
/*  43 */     Session session = null;
/*     */     try {
/*  45 */       session = HibernateUtil.getSessionFactory().openSession();
/*  46 */       session.beginTransaction();
/*  47 */       session.save(concepto);
/*  48 */       session.getTransaction().commit();
/*  49 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Registro agregado correctamente"));
/*     */     } catch (Exception e) {
/*  51 */       System.out.println(e.getMessage());
/*  52 */       session.getTransaction().rollback();
/*     */     } finally {
/*  54 */       if (session != null) {
/*  55 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void updateConcepto(Concepto concepto)
/*     */   {
/*  62 */     Session session = null;
/*     */     try {
/*  64 */       session = HibernateUtil.getSessionFactory().openSession();
/*  65 */       session.beginTransaction();
/*  66 */       session.update(concepto);
/*  67 */       session.getTransaction().commit();
/*  68 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Registro actualizado correctamente"));
/*     */     } catch (Exception e) {
/*  70 */       System.out.println(e.getMessage());
/*  71 */       session.getTransaction().rollback();
/*     */     } finally {
/*  73 */       if (session != null) {
/*  74 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void deleteConcepto(Concepto concepto)
/*     */   {
/*  81 */     Session session = null;
/*     */     try {
/*  83 */       session = HibernateUtil.getSessionFactory().openSession();
/*  84 */       session.beginTransaction();
/*  85 */       session.delete(concepto);
/*  86 */       session.getTransaction().commit();
/*  87 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Registro borrado correctamente"));
/*     */     } catch (Exception e) {
/*  89 */       System.out.println(e.getMessage());
/*  90 */       session.getTransaction().rollback();
/*     */     } finally {
/*  92 */       if (session != null) {
/*  93 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Concepto> listaSAT()
/*     */   {
/* 101 */     List<Concepto> lista = null;
/* 102 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/* 103 */     Session session = HibernateUtil.getSessionFactory().openSession();
/* 104 */     Transaction t = session.beginTransaction();
/* 105 */     String hql = "FROM Concepto WHERE nombreUsuario='" + us.getCodigoSap() + "'";
/*     */     try {
/* 107 */       lista = session.createQuery(hql).list();
/* 108 */       t.commit();
/* 109 */       session.close();
/*     */     } catch (Exception e) {
/* 111 */       t.rollback();
/*     */     }
/* 113 */     return lista;
/*     */   }
/*     */   
/*     */   public List<Usuario> listaporNombre()
/*     */   {
/* 118 */     List<Usuario> lista = null;
/* 119 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/* 120 */     Session session = HibernateUtil.getSessionFactory().openSession();
/* 121 */     Transaction t = session.beginTransaction();
/* 122 */     String hql = "FROM Usuario WHERE nombre='" + us.getNombre() + "'";
/*     */     try {
/* 124 */       lista = session.createQuery(hql).list();
/* 125 */       t.commit();
/* 126 */       session.close();
/*     */     } catch (Exception e) {
/* 128 */       t.rollback();
/*     */     }
/* 130 */     return lista;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Concepto> listaConceptoUSD()
/*     */   {
/* 136 */     List<Concepto> lista = null;
/* 137 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/* 138 */     Session session = HibernateUtil.getSessionFactory().openSession();
/* 139 */     Transaction t = session.beginTransaction();
/* 140 */     String hql = "FROM Concepto WHERE nombreUsuario='" + us.getCodigoSap() + "'  AND nombreConcepto='Caseta' AND tipo='Extranjero' AND estado='Agregar' ORDER BY idConcepto DESC";
/*     */     try {
/* 142 */       lista = session.createQuery(hql).list();
/* 143 */       t.commit();
/* 144 */       session.close();
/*     */     } catch (Exception e) {
/* 146 */       t.rollback();
/*     */     }
/* 148 */     return lista;
/*     */   }
/*     */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\impl\ConceptoCasetaDaoImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */