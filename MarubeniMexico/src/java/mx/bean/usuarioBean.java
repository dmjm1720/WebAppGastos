package mx.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import mx.dao.UsuarioDao;
import mx.impl.UsuarioDaoImpl;
import mx.model.Usuario;
import mx.password.EncriptarPassword;

@Named("usuarioBean")
@ViewScoped
public class usuarioBean
        implements Serializable {

    private List<Usuario> listaUsuario;
    private Usuario usuario;
    private final String llave = "0b64888c87e25fae31b50e9ea8b07f2de43383db284473db0aede56be49f1fe959a1681d4379f7f62ef196f6825bc3dbf7b9ba242341fcff79840ecb836bb1b5";

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuario() {
        UsuarioDao uDao = new UsuarioDaoImpl();
        this.listaUsuario = uDao.listaUsuarios();
        return this.listaUsuario;
    }

    public void prepararNuevoUsuario() {
        this.usuario = new Usuario();
    }

    public void nuevoUsuario() {
        UsuarioDao uDao = new UsuarioDaoImpl();
        this.usuario.setClave(EncriptarPassword.sha512(llave + this.usuario.getClave()));
        uDao.newUsuario(this.usuario);
    }

    public void modificarUsuario() {
        UsuarioDao uDao = new UsuarioDaoImpl();
        this.usuario.setClave(EncriptarPassword.sha512(llave + this.usuario.getClave()));
        uDao.updateUsuario(this.usuario);
        this.usuario = new Usuario();
    }

    public void eliminarUsuario() {
        UsuarioDao uDao = new UsuarioDaoImpl();
        uDao.deleteUsuario(this.usuario);
        this.usuario = new Usuario();
    }
}
