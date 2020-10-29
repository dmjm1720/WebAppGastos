package mx.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import mx.dao.ConceptoDetalleDao;
import mx.impl.ConceptoDetalleDaoImpl;
import mx.model.Concepto;
import mx.model.Usuario;

@Named("conceptoDetalleBean")
@ViewScoped
public class conceptoDetalleBean
        implements Serializable {

    private List<Concepto> listaConcepto;
    private List<SelectItem> listaFolio;
    private Concepto concepto;

    public void setListaViaje(List<Concepto> listaConcepto) {
        this.listaConcepto = listaConcepto;
    }

    public Concepto getConcepto() {
        return this.concepto;
    }

    public void setConcepto(Concepto concepto) {
        this.concepto = concepto;
    }

    public List<Concepto> getListaConcepto() {
        ConceptoDetalleDao cDao = new ConceptoDetalleDaoImpl();
        this.listaConcepto = cDao.listaConcepto();
        return this.listaConcepto;
    }

    public void prepararNuevoConcepto() {
        this.concepto = new Concepto();
    }

    public void nuevoConcepto() {
        ConceptoDetalleDao cDao = new ConceptoDetalleDaoImpl();
        cDao.nuevoConcepto(this.concepto);
    }

    public void modificarConcepto() {
        ConceptoDetalleDao cDao = new ConceptoDetalleDaoImpl();
        cDao.updateConcepto(this.concepto);
        this.concepto = new Concepto();
    }

    public void eliminarConcepto() {
        ConceptoDetalleDao cDao = new ConceptoDetalleDaoImpl();
        cDao.deleteConcepto(this.concepto);
        this.concepto = new Concepto();
    }

    public List<SelectItem> getListaFolio() {
        this.listaFolio = new ArrayList();
        ConceptoDetalleDao fDao = new ConceptoDetalleDaoImpl();
        List<Usuario> f = fDao.listaPorFolio();
        for (Usuario nombre : f) {
            SelectItem nombreItem = new SelectItem(nombre.getFolioUsuario());
            this.listaFolio.add(nombreItem);
        }
        return this.listaFolio;
    }
}
