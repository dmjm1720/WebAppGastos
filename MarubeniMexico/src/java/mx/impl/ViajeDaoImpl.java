package mx.impl;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import mx.model.Usuario;
import mx.model.Viaje;
import mx.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ViajeDaoImpl implements mx.dao.ViajeDao {

    @Override
    public List<Viaje> listaViajes() {
        List<Viaje> lista = null;

        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();

        String hql = "FROM Viaje WHERE nombreViajero='" + us.getCodigoSap() + "' AND Status<>'Cerrar' AND Status<>'Generada'";
        try {
            lista = session.createQuery(hql).list();

            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @SuppressWarnings("null")
    public void newViaje(Viaje viaje) {
        Usuario vi = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        if (vi.getEstatus().equals("Activo")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "SISTEMA DE GASTOS", "" + vi.getNombre() + " Tienes un folio pendiente por ingresarle gastos, favor de revisarlo. Gracias"));
        } else {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(viaje);
                session.getTransaction().commit();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Registro agregado correctamente"));
            } catch (HibernateException e) {
                System.out.println(e.getMessage());
                session.getTransaction().rollback();
            } finally {
                if (session != null) {
                    session.close();
                }
            }
        }
    }

    @SuppressWarnings("null")
    @Override
    public void updateViaje(Viaje viaje) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(viaje);
            session.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Registro actualizado correctamente"));
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("null")
    @Override
    public void deleteViaje(Viaje viaje) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(viaje);
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
    public List<mx.model.Categoria> listaDepto() {
        List<mx.model.Categoria> lista = null;
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Categoria WHERE usuario='" + us.getNombre() + "'";
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
    public List<Viaje> listaPorFolio() {
        List<Viaje> lista = null;
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Viaje WHERE Status='Agregar' AND nombreViajero='" + us.getCodigoSap() + "'";
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
    public List<Viaje> listaViajesConcluidos() {
        List<Viaje> lista = null;

        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();

        String hql = "FROM Viaje WHERE nombreViajero='" + us.getCodigoSap() + "' AND Status<>'Pendiente' AND Status<>'Agregar'";
        try {
            lista = session.createQuery(hql).list();

            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }
}
