/*     */ package mx.impl;
/*     */ 
/*     */ import java.util.List;
/*     */ import javax.faces.application.FacesMessage;
/*     */ import javax.faces.context.FacesContext;
/*     */ import mx.model.Concepto;
/*     */ import mx.model.Usuario;
/*     */ import mx.util.HibernateUtil;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.SessionFactory;
/*     */ import org.hibernate.Transaction;
/*     */ 
/*     */ public class ConceptoTelIntDaoImpl implements mx.dao.ConceptoTelIntDao
/*     */ {
/*     */   public List<Concepto> listaConcepto()
/*     */   {
/*  17 */     List<Concepto> lista = null;
/*  18 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/*  19 */     Session session = HibernateUtil.getSessionFactory().openSession();
/*  20 */     Transaction t = session.beginTransaction();
/*  21 */     String hql = "FROM Concepto WHERE nombreUsuario='" + us.getCodigoSap() + "'  AND nombreConcepto='Tel-Int' AND tipo='Nacional' AND estado='Agregar' ORDER BY idConcepto DESC";
/*     */     try {
/*  23 */       lista = session.createQuery(hql).list();
/*  24 */       t.commit();
/*  25 */       session.close();
/*     */     } catch (Exception e) {
/*  27 */       t.rollback();
/*     */     }
/*  29 */     return lista;
/*     */   }
/*     */   
/*     */   public void nuevoConcepto(Concepto concepto)
/*     */   {
/*  34 */     Session session = null;
/*     */     try {
/*  36 */       session = HibernateUtil.getSessionFactory().openSession();
/*  37 */       session.beginTransaction();
/*  38 */       session.save(concepto);
/*  39 */       session.getTransaction().commit();
/*  40 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Registro agregado correctamente"));
/*     */     } catch (Exception e) {
/*  42 */       System.out.println(e.getMessage());
/*  43 */       session.getTransaction().rollback();
/*     */     } finally {
/*  45 */       if (session != null) {
/*  46 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void updateConcepto(Concepto concepto)
/*     */   {
/*  53 */     Session session = null;
/*     */     try {
/*  55 */       session = HibernateUtil.getSessionFactory().openSession();
/*  56 */       session.beginTransaction();
/*  57 */       session.update(concepto);
/*  58 */       session.getTransaction().commit();
/*  59 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Registro actualizado correctamente"));
/*     */     } catch (Exception e) {
/*  61 */       System.out.println(e.getMessage());
/*  62 */       session.getTransaction().rollback();
/*     */     } finally {
/*  64 */       if (session != null) {
/*  65 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void deleteConcepto(Concepto concepto)
/*     */   {
/*  72 */     Session session = null;
/*     */     try {
/*  74 */       session = HibernateUtil.getSessionFactory().openSession();
/*  75 */       session.beginTransaction();
/*  76 */       session.delete(concepto);
/*  77 */       session.getTransaction().commit();
/*  78 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Registro borrado correctamente"));
/*     */     } catch (Exception e) {
/*  80 */       System.out.println(e.getMessage());
/*  81 */       session.getTransaction().rollback();
/*     */     } finally {
/*  83 */       if (session != null) {
/*  84 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Concepto> listaSAT()
/*     */   {
/*  91 */     List<Concepto> lista = null;
/*  92 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/*  93 */     Session session = HibernateUtil.getSessionFactory().openSession();
/*  94 */     Transaction t = session.beginTransaction();
/*  95 */     String hql = "FROM Concepto WHERE nombreUsuario='" + us.getCodigoSap() + "'";
/*     */     try {
/*  97 */       lista = session.createQuery(hql).list();
/*  98 */       t.commit();
/*  99 */       session.close();
/*     */     } catch (Exception e) {
/* 101 */       t.rollback();
/*     */     }
/* 103 */     return lista;
/*     */   }
/*     */   
/*     */   public List<Usuario> listaporNombre()
/*     */   {
/* 108 */     List<Usuario> lista = null;
/* 109 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/* 110 */     Session session = HibernateUtil.getSessionFactory().openSession();
/* 111 */     Transaction t = session.beginTransaction();
/* 112 */     String hql = "FROM Usuario WHERE nombre='" + us.getNombre() + "'";
/*     */     try {
/* 114 */       lista = session.createQuery(hql).list();
/* 115 */       t.commit();
/* 116 */       session.close();
/*     */     } catch (Exception e) {
/* 118 */       t.rollback();
/*     */     }
/* 120 */     return lista;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Concepto> listaConceptoUSD()
/*     */   {
/* 126 */     List<Concepto> lista = null;
/* 127 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/* 128 */     Session session = HibernateUtil.getSessionFactory().openSession();
/* 129 */     Transaction t = session.beginTransaction();
/* 130 */     String hql = "FROM Concepto WHERE nombreUsuario='" + us.getCodigoSap() + "'  AND nombreConcepto='Tel-Int' AND tipo='Extranjero' AND estado='Agregar' ORDER BY idConcepto DESC";
/*     */     try {
/* 132 */       lista = session.createQuery(hql).list();
/* 133 */       t.commit();
/* 134 */       session.close();
/*     */     } catch (Exception e) {
/* 136 */       t.rollback();
/*     */     }
/* 138 */     return lista;
/*     */   }
/*     */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\impl\ConceptoTelIntDaoImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */