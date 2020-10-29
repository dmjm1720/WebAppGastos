package mx.impl;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import mx.model.Concepto;
import mx.model.Usuario;
import mx.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ConceptoDaoImpl implements mx.dao.ConceptoDao {

    @Override
    public List<Concepto> listaConcepto() {
        List<Concepto> lista = null;
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Concepto WHERE nombreUsuario='" + us.getCodigoSap() + "'  AND nombreConcepto='Avión' AND tipo='Nacional' AND estado='Agregar' ORDER BY idConcepto DESC";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    @SuppressWarnings("null")
    public void nuevoConcepto(Concepto concepto) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(concepto);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    @SuppressWarnings("null")
    public void updateConcepto(Concepto concepto) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(concepto);
            session.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Registro actualizado correctamente"));
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE GASTOS", "Factura o UUID duplicado"));
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    @SuppressWarnings("null")
    public void deleteConcepto(Concepto concepto) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(concepto);
            session.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Registro borrado correctamente"));
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Usuario> listaporNombre() {
        List<Usuario> lista = null;
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Usuario WHERE nombre='" + us.getNombre() + "'";
        try {
            lista = session.createQuery(hql).list();

            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public List<Concepto> listaConceptoUSD() {
        List<Concepto> lista = null;
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();

        String hql = "FROM Concepto WHERE nombreUsuario='" + us.getCodigoSap() + "'  AND nombreConcepto='Avión' AND tipo='Extranjero' AND estado='Agregar' ORDER BY idConcepto DESC";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public List<Concepto> listaSAT() {
        List<Concepto> lista = null;
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "SELECT comentario FROM Concepto WHERE comentario like'RFC INVALIDO%' AND nombreUsuario='" + us.getCodigoSap() + "' AND Estado='Agregar'  ORDER BY idConcepto DESC";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public void updateConcepto(String uuid, String foliousuario, String nombreusuario, String foliousuariox) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "UPDATE Concepto SET folioUsuario=:foliox WHERE uuid=:uuid and nombreUsuario=:usu and folioUsuario=:folio";
        Query q = session.createQuery(hql);
        q.setParameter("uuid", uuid);
        q.setParameter("folio", foliousuario);
        q.setParameter("usu", nombreusuario);
        q.setParameter("foliox", foliousuariox);
        try {
            q.executeUpdate();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
    }

    @Override
    public void deleteConceptoViaje(int folio) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "DELETE FROM Concepto WHERE idConcepto=" + folio + "";
        try {
            session.createSQLQuery(sql).executeUpdate();
            session.getTransaction().commit();
            session.close();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "SISTEMA DE GASTOS", "Registro borrado"));
        } catch (HibernateException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE GASTOS", "ERROR " + e.getMessage()));
            session.getTransaction().rollback();
        }
    }

    @Override
    public List<Concepto> listaConceptoBorrar(String nombre, String folio) {
        List<Concepto> lista = null;
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Concepto WHERE nombreUsuario='" + nombre + "'  AND folioUsuario='" + folio +"'";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @Override
    public List<Concepto> listaConceptoViaje(String nombre, String folio) {
        List<Concepto> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Concepto WHERE nombreUsuario='" + nombre + "'  AND folioUsuario='" + folio +"'";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
            t.rollback();
        }
        return lista;
    }
}
