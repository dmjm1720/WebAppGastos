package mx.impl;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import mx.model.xml;
import mx.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class xmlDaoImpl implements mx.dao.xmlDao {

    @Override
    @SuppressWarnings("null")
    public void newViaje(xml xml) {

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(xml);
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

    @Override
    public List<xml> selectviaje(String paramusu, String paramnom) {
        List<xml> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM xml WHERE numerousuario='" + paramusu + "'  AND numerosat='" + paramnom + "' and Bandera = 0";
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
    public void updatexml(String uuid, String folio, int est, String o, String usu) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "UPDATE xml SET Estatus=:esta , Observacion=:obv, Bandera=1 WHERE numerousuario=:folio and numerosat=:usu and UUID=:uuid";
        Query q = session.createQuery(hql);
        q.setParameter("folio", folio);
        q.setParameter("usu", o);
        q.setParameter("esta", est);
        q.setParameter("uuid", uuid);
        q.setParameter("obv", usu);
        try {
            q.executeUpdate();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
    }

}
