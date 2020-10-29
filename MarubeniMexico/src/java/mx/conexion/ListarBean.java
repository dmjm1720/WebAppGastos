package mx.conexion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import mx.dao.ConceptoDao;
import mx.impl.ConceptoDaoImpl;
import mx.model.Concept;
import mx.model.Concepto;

@Named("ListarBean")
@ViewScoped
public class ListarBean implements Serializable {

    private List<Concept> lista;
    private String name;
    private Concept concept;
    private String rutaPDF;
    private List<Concepto> listaConceptoViaje;

    public List<Concept> getLista() {
        return this.lista;
    }

    public void setLista(List<Concept> lista) {
        this.lista = lista;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Concept getConcept() {
        return this.concept;
    }

    public void setConcept(Concept concept) {
        this.concept = concept;
    }

    public String getRutaPDF() {
        return this.rutaPDF;
    }

    public void setRutaPDF(String rutaPDF) {
        this.rutaPDF = rutaPDF;
    }

    public List<Concepto> getListaConceptoViaje() {
        return listaConceptoViaje;
    }

    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    String ruta2 = this.request.getParameter("frmVer:ruta");
    String ruta = this.request.getParameter("frmVert:ruta");

    public void listados() {
    }

    public void listar(String nombre, String folio) {

        this.listaConceptoViaje = new ArrayList<>();
        ConceptoDao listaDao = new ConceptoDaoImpl();
        this.listaConceptoViaje = listaDao.listaConceptoViaje(nombre, folio);
//            throws Exception {
//        try {
//            ConceptDAO dao = new ConceptDAO();
//            this.lista = dao.listar(nombre, folio);
//        } catch (Exception e) {
//            throw e;
//        }
//        ConceptDAO dao;
    }
}
