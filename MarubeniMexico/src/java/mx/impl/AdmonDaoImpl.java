/*     */ package mx.impl;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.faces.application.FacesMessage;
/*     */ import javax.faces.context.ExternalContext;
/*     */ import javax.faces.context.FacesContext;
/*     */ import mx.model.Usuario;
/*     */ import mx.model.Viaje;
/*     */ import mx.util.HibernateUtil;
/*     */ import org.hibernate.HibernateException;
/*     */ import org.hibernate.Query;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.SessionFactory;
/*     */ import org.hibernate.Transaction;
/*     */ 
/*     */ public class AdmonDaoImpl implements mx.dao.AdmonDao
/*     */ {
/*     */   public List<Viaje> listaViajes()
/*     */   {
/*  22 */     List<Viaje> lista = null;
/*  23 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/*  24 */     Session session = HibernateUtil.getSessionFactory().openSession();
/*  25 */     Transaction t = session.beginTransaction();
/*  26 */     String hql = "FROM Viaje WHERE Status<>'Pendiente' AND Status<>'Agregar'";
/*     */     try {
/*  28 */       lista = session.createQuery(hql).list();
/*     */       
/*  30 */       t.commit();
/*  31 */       session.close();
/*     */     } catch (HibernateException e) {
/*  33 */       t.rollback();
/*     */     }
/*  35 */     return lista;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void newViaje(Viaje viaje)
/*     */   {
/*  42 */     Usuario vi = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/*  43 */     if (vi.getEstatus().equals("Activo")) {
/*  44 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE GASTOS", "" + vi.getNombre() + " Tienes un folio pendiente por ingresarle gastos, favor de revisarlo. Gracias"));
/*     */     }
/*     */     else {
/*  47 */       Session session = null;
/*     */       try
/*     */       {
/*  50 */         session = HibernateUtil.getSessionFactory().openSession();
/*  51 */         session.beginTransaction();
/*  52 */         session.save(viaje);
/*  53 */         session.getTransaction().commit();
/*  54 */         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Registro agregado correctamente"));
/*     */       }
/*     */       catch (HibernateException e) {
/*  57 */         System.out.println(e.getMessage());
/*  58 */         session.getTransaction().rollback();
/*     */       } finally {
/*  60 */         if (session != null) {
/*  61 */           session.close();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void updateViaje(Viaje viaje)
/*     */   {
/*  70 */     Session session = null;
/*     */     try {
/*  72 */       session = HibernateUtil.getSessionFactory().openSession();
/*  73 */       session.beginTransaction();
/*  74 */       session.update(viaje);
/*  75 */       session.getTransaction().commit();
/*  76 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Registro actualizado correctamente"));
/*     */     } catch (HibernateException e) {
/*  78 */       System.out.println(e.getMessage());
/*  79 */       session.getTransaction().rollback();
/*     */     } finally {
/*  81 */       if (session != null) {
/*  82 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void deleteViaje(Viaje viaje)
/*     */   {
/*  90 */     Session session = null;
/*     */     try {
/*  92 */       session = HibernateUtil.getSessionFactory().openSession();
/*  93 */       session.beginTransaction();
/*  94 */       session.delete(viaje);
/*  95 */       session.getTransaction().commit();
/*  96 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Registro borrado correctamente"));
/*     */     } catch (HibernateException e) {
/*  98 */       System.out.println(e.getMessage());
/*  99 */       session.getTransaction().rollback();
/*     */     } finally {
/* 101 */       if (session != null) {
/* 102 */         session.close();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Usuario> listaporNombre()
/*     */   {
/* 109 */     List<Usuario> lista = null;
/* 110 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/* 111 */     Session session = HibernateUtil.getSessionFactory().openSession();
/* 112 */     Transaction t = session.beginTransaction();
/* 113 */     String hql = "FROM Usuario WHERE nombre='" + us.getNombre() + "'";
/*     */     try {
/* 115 */       lista = session.createQuery(hql).list();
/*     */       
/* 117 */       t.commit();
/* 118 */       session.close();
/*     */     }
/*     */     catch (HibernateException e) {
/* 121 */       t.rollback();
/*     */     }
/* 123 */     return lista;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<mx.model.Categoria> listaDepto()
/*     */   {
/* 129 */     List<mx.model.Categoria> lista = null;
/* 130 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/* 131 */     Session session = HibernateUtil.getSessionFactory().openSession();
/* 132 */     Transaction t = session.beginTransaction();
/* 133 */     String hql = "FROM Categoria WHERE usuario='" + us.getNombre() + "'";
/*     */     try {
/* 135 */       lista = session.createQuery(hql).list();
/* 136 */       t.commit();
/* 137 */       session.close();
/*     */     } catch (HibernateException e) {
/* 139 */       t.rollback();
/*     */     }
/* 141 */     return lista;
/*     */   }
/*     */   
/*     */   public List<Viaje> listaPorFolio()
/*     */   {
/* 146 */     List<Viaje> lista = null;
/* 147 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/* 148 */     Session session = HibernateUtil.getSessionFactory().openSession();
/* 149 */     Transaction t = session.beginTransaction();
/* 150 */     String hql = "FROM Viaje WHERE Status='Agregar' AND nombreViajero='" + us.getCodigoSap() + "'";
/*     */     try {
/* 152 */       lista = session.createQuery(hql).list();
/* 153 */       t.commit();
/* 154 */       session.close();
/*     */     } catch (HibernateException e) {
/* 156 */       t.rollback();
/*     */     }
/* 158 */     return lista;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<mx.model.Concepto> listarPoliza()
/*     */   {
/* 183 */     List<mx.model.Concepto> lista = null;
/* 184 */     javax.servlet.http.HttpServletRequest request = (javax.servlet.http.HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
/*     */     
/* 186 */     String nombre = "R0038";
/* 187 */     String folio = request.getParameter("frmVerPoliza:folio");
/* 188 */     Session session = HibernateUtil.getSessionFactory().openSession();
/* 189 */     Transaction transaction = session.beginTransaction();
/* 190 */     String hql = "FROM Concepto WHERE estado<>'Agregar' AND estado<>'Pendiente' AND nombreUsuario='" + nombre + "'";
/*     */     
/*     */     try
/*     */     {
/* 194 */       lista = session.createQuery(hql).list();
/* 195 */       transaction.commit();
/* 196 */       session.close();
/*     */     } catch (HibernateException e) {
/* 198 */       System.out.println(e.getMessage());
/* 199 */       transaction.rollback();
/*     */     }
/* 201 */     return lista;
/*     */   }
/*     */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\impl\AdmonDaoImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */