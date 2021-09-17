package mx.filtro;

import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class filtroUrl
        implements PhaseListener {

    public void afterPhase(PhaseEvent event) {
        FacesContext facesContext = event.getFacesContext();
        String currrentPage = facesContext.getViewRoot().getViewId();
        boolean isPageLogin = currrentPage.lastIndexOf("/index.xhtml") > -1;
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        Object nombre = session.getAttribute("nombre");
        if ((!isPageLogin) && (nombre == null)) {
            NavigationHandler nHandler = facesContext.getApplication().getNavigationHandler();
            nHandler.handleNavigation(facesContext, null, "/index.xhtml");
        }
    }

    public void beforePhase(PhaseEvent event) {
    }

    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
