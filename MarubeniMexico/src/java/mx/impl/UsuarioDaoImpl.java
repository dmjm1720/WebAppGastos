/*    */ package mx.impl;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import javax.faces.application.FacesMessage;
/*    */ import javax.faces.context.FacesContext;
/*    */ import mx.model.Usuario;
/*    */ import mx.util.HibernateUtil;
/*    */ import org.hibernate.HibernateException;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.SessionFactory;
/*    */ import org.hibernate.Transaction;
/*    */ 
/*    */ public class UsuarioDaoImpl implements mx.dao.UsuarioDao
/*    */ {
/*    */   public java.util.List<Usuario> listaUsuarios()
/*    */   {
/* 17 */     java.util.List<Usuario> lista = null;
/* 18 */     Usuario us = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
/* 19 */     Session session = HibernateUtil.getSessionFactory().openSession();
/* 20 */     Transaction t = session.beginTransaction();
/* 21 */     String SQL = "FROM Usuario";
/*    */     try {
/* 23 */       lista = session.createQuery(SQL).list();
/* 24 */       t.commit();
/* 25 */       session.close();
/*    */     } catch (Exception e) {
/* 27 */       t.rollback();
/*    */     }
/* 29 */     return lista;
/*    */   }
/*    */   
/*    */   public void newUsuario(Usuario usuario)
/*    */   {
/* 34 */     Session session = null;
/*    */     try {
/* 36 */       session = HibernateUtil.getSessionFactory().openSession();
/* 37 */       session.beginTransaction();
/* 38 */       session.save(usuario);
/* 39 */       session.getTransaction().commit();
/* 40 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Usuario agregado correctamente"));
/*    */     } catch (Exception e) {
/* 42 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "SISTEMA DE GASTOS", "El usuario ya existe"));
/* 43 */       session.getTransaction().rollback();
/*    */     } finally {
/* 45 */       if (session != null) {
/* 46 */         session.close();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void updateUsuario(Usuario usuario)
/*    */   {
/* 53 */     Session session = null;
/*    */     try {
/* 55 */       session = HibernateUtil.getSessionFactory().openSession();
/* 56 */       session.beginTransaction();
/* 57 */       session.update(usuario);
/* 58 */       session.getTransaction().commit();
/* 59 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Usuario actualizado correctamente"));
/*    */     } catch (Exception e) {
/* 61 */       System.out.println(e.getMessage());
/* 62 */       session.getTransaction().rollback();
/*    */     } finally {
/* 64 */       if (session != null) {
/* 65 */         session.close();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public void deleteUsuario(Usuario usuario)
/*    */   {
/* 73 */     Session session = null;
/*    */     try {
/* 75 */       session = HibernateUtil.getSessionFactory().openSession();
/* 76 */       session.beginTransaction();
/* 77 */       session.delete(usuario);
/* 78 */       session.getTransaction().commit();
/* 79 */       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Usuario borrado correctamente"));
/*    */     } catch (HibernateException e) {
/* 81 */       System.out.println(e.getMessage());
/* 82 */       session.getTransaction().rollback();
/*    */     } finally {
/* 84 */       if (session != null) {
/* 85 */         session.close();
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\impl\UsuarioDaoImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */