/*     */ package mx.impl;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.faces.application.FacesMessage;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ import mx.model.Categoria;
/*     */ import mx.model.Usuario;
/*     */ import mx.util.HibernateUtil;
/*     */ import org.hibernate.HibernateException;
/*     */ import org.hibernate.Query;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.SessionFactory;
/*     */ import org.hibernate.Transaction;
/*     */ 
/*     */ public class CategoriaDaoImpl implements mx.dao.CategoriaDao
/*     */ {
/*     */   public List<Categoria> listaCategoria()
/*     */   {
/*  21 */     List<Categoria> lista = null;
/*  22 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/*  23 */     Session session = HibernateUtil.getSessionFactory().openSession();
/*  24 */     Transaction t = session.beginTransaction();
/*  25 */     String SQL = "FROM Categoria";
/*     */     try {
/*  27 */       lista = session.createQuery(SQL).list();
/*  28 */       t.commit();
/*  29 */       session.close();
/*     */     } catch (HibernateException e) {
/*  31 */       t.rollback();
/*     */     }
/*  33 */     return lista;
/*     */   }
/*     */   
/*     */ 
/*     */   public void newCategoria(Categoria categoria)
/*     */   {
/*  39 */     Session session = null;
/*     */     try {
/*  41 */       session = HibernateUtil.getSessionFactory().openSession();
/*  42 */       session.beginTransaction();
/*  43 */       session.save(categoria);
/*  44 */       session.getTransaction().commit();
/*  45 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Subdepartamento agregado correctamente"));
/*     */     } catch (HibernateException e) {
/*  47 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "SISTEMA DE GASTOS", "El usuario ya existe"));
/*  48 */       session.getTransaction().rollback();
/*     */     } finally {
/*  50 */       if (session != null) {
/*  51 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void updateCategoria(Categoria categoria)
/*     */   {
/*  59 */     Session session = null;
/*     */     try {
/*  61 */       session = HibernateUtil.getSessionFactory().openSession();
/*  62 */       session.beginTransaction();
/*  63 */       session.update(categoria);
/*  64 */       session.getTransaction().commit();
/*  65 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Subdepartamento actualizado correctamente"));
/*     */     } catch (HibernateException e) {
/*  67 */       System.out.println(e.getMessage());
/*  68 */       session.getTransaction().rollback();
/*     */     } finally {
/*  70 */       if (session != null) {
/*  71 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void deleteCategoria(Categoria categoria)
/*     */   {
/*  79 */     Session session = null;
/*     */     try {
/*  81 */       session = HibernateUtil.getSessionFactory().openSession();
/*  82 */       session.beginTransaction();
/*  83 */       session.delete(categoria);
/*  84 */       session.getTransaction().commit();
/*  85 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Subdepartamento borrado correctamente"));
/*     */     } catch (HibernateException e) {
/*  87 */       System.out.println(e.getMessage());
/*  88 */       session.getTransaction().rollback();
/*     */     } finally {
/*  90 */       if (session != null) {
/*  91 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Categoria> listaSubDepto()
/*     */   {
/*  98 */     List<Categoria> lista = null;
/*  99 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/* 100 */     Session session = HibernateUtil.getSessionFactory().openSession();
/* 101 */     Transaction t = session.beginTransaction();
/* 102 */     String hql = "select distinct subDepartamento FROM Categoria";
/*     */     try {
/* 104 */       lista = session.createQuery(hql).list();
/* 105 */       t.commit();
/* 106 */       session.close();
/*     */     } catch (HibernateException e) {
/* 108 */       t.rollback();
/*     */     }
/* 110 */     return lista;
/*     */   }
/*     */   
/*     */   public List<Usuario> listaUsuarios()
/*     */   {
/* 115 */     List<Usuario> lista = null;
/* 116 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/* 117 */     Session session = HibernateUtil.getSessionFactory().openSession();
/* 118 */     Transaction t = session.beginTransaction();
/* 119 */     String SQL = "FROM Usuario";
/*     */     try {
/* 121 */       lista = session.createQuery(SQL).list();
/* 122 */       t.commit();
/* 123 */       session.close();
/*     */     } catch (HibernateException e) {
/* 125 */       t.rollback();
/*     */     }
/* 127 */     return lista;
/*     */   }
/*     */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\impl\CategoriaDaoImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */