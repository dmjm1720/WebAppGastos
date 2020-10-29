package mx.bean;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.sql.SQLException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import mx.dao.LoginDao;
import mx.impl.LoginUsuarioImpl;
import mx.model.Usuario;
import org.primefaces.context.RequestContext;

@javax.inject.Named("loginBean")
@SessionScoped
public class LoginBean extends mx.conexion.DAO implements Serializable {

    private Usuario usuario;
    private String nombre;
    private String password;

    public LoginBean() {
        this.usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombreUsuario(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return this.password;
    }

    void setPassword(String password) {
        this.password = password;
    }

    public void login() throws InterruptedException, SQLException, java.io.IOException {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        FacesMessage message2 = null;
        FacesMessage message3 = null;
        String array = "";
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.setAttribute("array", array);
        /* 58 */ boolean loggedIn = false;
        String ruta = "/WebAppGastos/Views/Gastos/CapturaViaje.jsf";
        LoginDao uDao = new LoginUsuarioImpl();
        this.usuario = uDao.login(this.usuario);

        if (this.usuario != null) {
            loggedIn = true;
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("nombre", this.usuario);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getNombre());
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "¡Error de sesión!", "Usuario o password incorrectos...");
            FacesContext.getCurrentInstance().addMessage(null, message);

            this.usuario = new Usuario();
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        try {
            FacesContext.getCurrentInstance().addMessage(null, message2);
            FacesContext.getCurrentInstance().addMessage(null, message3);
        } catch (Exception localException) {
        }
        context.addCallbackParam("loggedIn", loggedIn);
        ExternalContext con = FacesContext.getCurrentInstance().getExternalContext();
        con.redirect(ruta);
        //context.addCallbackParam("ruta", ruta);
    }

    public void cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
}
