package mx.impl;

import mx.dao.LoginDao;
import mx.model.Usuario;
import mx.password.EncriptarPassword;
import org.hibernate.Query;
import org.hibernate.Session;

public class LoginUsuarioImpl implements LoginDao {

    @Override
    public Usuario obternerDatosUsuario(Usuario usuario) {
        Session session = mx.util.HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Usuario WHERE nombre=:nombre and clave=:clave and token=:token";
        Query q = session.createQuery(hql);
        q.setParameter("nombre", usuario.getNombre());
        q.setParameter("clave", EncriptarPassword.sha512(usuario.getClave()));
        q.setParameter("token", usuario.getToken());
      
        return (Usuario) q.uniqueResult();
    }

    @Override
    public Usuario login(Usuario usuario) {
        Usuario user = obternerDatosUsuario(usuario);
        if (user != null) {
            if (!user.getClave().equals(EncriptarPassword.sha512(usuario.getClave()))) {
                 user = null;
            }
           
        }

        return user;
    }

    @Override
    public Usuario loginPrimeraValidacion(Usuario usuario) {
         Usuario user = obternerDatosUsuarioPrimeraValidacion(usuario);
        if (user != null) {
            if (!user.getClave().equals(EncriptarPassword.sha512(usuario.getClave()))) {
                 user = null;
            }
           
        }

        return user;
    }

    @Override
    public Usuario obternerDatosUsuarioPrimeraValidacion(Usuario usuario) {
       Session session = mx.util.HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Usuario WHERE nombre=:nombre and clave=:clave";
        Query q = session.createQuery(hql);
        q.setParameter("nombre", usuario.getNombre());
        q.setParameter("clave", EncriptarPassword.sha512(usuario.getClave()));
        System.out.println("Contraseña encriptada: " + EncriptarPassword.sha512(usuario.getClave()));
        return (Usuario) q.uniqueResult();
    }
}
