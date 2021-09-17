package mx.permisos;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import mx.model.Usuario;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@javax.inject.Named("permisosBean")
@ViewScoped
public class PermisosBean implements java.io.Serializable {

    Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");

    private MenuModel model;

    @PostConstruct
    public void init() {
        this.model = new DefaultMenuModel();

        if (this.us.getCodigoPerfil().equals("Administrador")) {
            DefaultSubMenu primerSubmenu = new DefaultSubMenu("Inicio");

            DefaultMenuItem item = new DefaultMenuItem("Inicio");
            item.setOutcome("/Views/Gastos/CapturaViaje.jsf");
            item.setIcon("ui-icon-home");
            primerSubmenu.addElement(item);

            this.model.addElement(primerSubmenu);

            DefaultSubMenu segundoSubmenu = new DefaultSubMenu("Usuarios");

            item = new DefaultMenuItem("Usuarios");
            item.setIcon("ui-icon-disk");
            item.setOutcome("/Views/Usuario/Usuario.jsf");
            segundoSubmenu.addElement(item);

            item = new DefaultMenuItem("Sub departamentos");
            item.setIcon("ui-icon-close");
            item.setOutcome("/Views/Gastos/Subdepto.jsf");
            segundoSubmenu.addElement(item);

            this.model.addElement(segundoSubmenu);

            DefaultSubMenu tercerSubmenu = new DefaultSubMenu("Reportes");
            item = new DefaultMenuItem("Viajes concluídos");
            item.setIcon("ui-icon-disk");
            item.setOutcome("/Views/Gastos/MisViajes.jsf");
            tercerSubmenu.addElement(item);

            this.model.addElement(tercerSubmenu);

            DefaultSubMenu cuartoSubmenu = new DefaultSubMenu("Pólizas");
            item = new DefaultMenuItem("Admnistrar pólizas");
            item.setIcon("ui-icon-disk");
            item.setOutcome("/Views/Gastos/Poliza.jsf");
            cuartoSubmenu.addElement(item);

            this.model.addElement(cuartoSubmenu);
            
            DefaultSubMenu quintoSubmenu = new DefaultSubMenu("Reportes");
            item = new DefaultMenuItem("Reportes");
            item.setIcon("ui-icon-disk");
            item.setOutcome("/Views/Gastos/Reportes.jsf");
            quintoSubmenu.addElement(item);

            this.model.addElement(quintoSubmenu);

        } else if (this.us.getCodigoPerfil().equals("Usuario")) {
            DefaultSubMenu primerSubmenu = new DefaultSubMenu("Inicio");
            DefaultMenuItem item = new DefaultMenuItem("Inicio");
            item.setOutcome("/Views/Gastos/CapturaViaje.jsf");
            item.setIcon("ui-icon-home");
            primerSubmenu.addElement(item);
            this.model.addElement(primerSubmenu);
            DefaultSubMenu tercerSubmenu = new DefaultSubMenu("Reportes");
            item = new DefaultMenuItem("Viajes concluídos");
            item.setIcon("ui-icon-disk");
            item.setOutcome("/Views/Gastos/MisViajes.jsf");
            tercerSubmenu.addElement(item);
            this.model.addElement(tercerSubmenu);
        }
    }

    public MenuModel getModel() {
        return this.model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public void save() {
        addMessage("Success", "Data saved");
    }

    public void update() {
        addMessage("Success", "Data updated");
    }

    public void delete() {
        addMessage("Success", "Data deleted");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
