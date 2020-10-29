/*    */ package mx.filtro;
/*    */ 
/*    */ import javax.faces.application.Application;
/*    */ import javax.faces.application.NavigationHandler;
/*    */ import javax.faces.component.UIViewRoot;
/*    */ import javax.faces.context.ExternalContext;
/*    */ import javax.faces.context.FacesContext;
/*    */ import javax.faces.event.PhaseEvent;
/*    */ import javax.faces.event.PhaseId;
/*    */ import javax.faces.event.PhaseListener;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class filtroUrl
/*    */   implements PhaseListener
/*    */ {
/*    */   public void afterPhase(PhaseEvent event)
/*    */   {
/* 23 */     FacesContext facesContext = event.getFacesContext();
/* 24 */     String currrentPage = facesContext.getViewRoot().getViewId();
/* 25 */     boolean isPageLogin = currrentPage.lastIndexOf("/index.xhtml") > -1;
/* 26 */     HttpSession session = (HttpSession)facesContext.getExternalContext().getSession(true);
/* 27 */     Object nombre = session.getAttribute("nombre");
/* 28 */     if ((!isPageLogin) && (nombre == null)) {
/* 29 */       NavigationHandler nHandler = facesContext.getApplication().getNavigationHandler();
/* 30 */       nHandler.handleNavigation(facesContext, null, "/index.xhtml");
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void beforePhase(PhaseEvent event) {}
/*    */   
/*    */ 
/*    */ 
/*    */   public PhaseId getPhaseId()
/*    */   {
/* 43 */     return PhaseId.RESTORE_VIEW;
/*    */   }
/*    */ }


/* Location:              C:\Users\Mario Arias\Desktop\Ultima version marubeni trabajable\WebAppGastos.war!\WEB-INF\classes\mx\filtro\filtroUrl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */