package mx.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import mx.dao.PolizaDao;
import mx.dao.ViajeDao;
import mx.impl.PolizaDaoImpl;
import mx.impl.ViajeDaoImpl;
import mx.model.Concepto;
import mx.model.Usuario;
import mx.model.Viaje;

@Named("VoucherBean")
@ViewScoped
public class VoucherBean
        implements Serializable {

    private List<Concepto> listaConcepto;
    private List<Concepto> listaConceptoUSD;
    private List<SelectItem> listaFolio;
    private List<SelectItem> listNombreUsuario;
    private Concepto concepto;

    public List<Concepto> getListaConceptoUSD() {
        PolizaDao cDao = new PolizaDaoImpl();
        this.listaConceptoUSD = cDao.listaConceptoUSD();
        return this.listaConceptoUSD;
    }

    public void setListaConceptoUSD(List<Concepto> listaConceptoUSD) {
        this.listaConceptoUSD = listaConceptoUSD;
    }

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
        PolizaDao cDao = new PolizaDaoImpl();
        this.listaConcepto = cDao.listaConcepto();
        return this.listaConcepto;
    }

    public void prepararNuevoConcepto() {
        this.concepto = new Concepto();
    }

    public void nuevoConcepto() {
        PolizaDao cDao = new PolizaDaoImpl();
        cDao.nuevoConcepto(this.concepto);
    }

    public void modificarConcepto() {
        PolizaDao cDao = new PolizaDaoImpl();
        cDao.updateConcepto(this.concepto);
        this.concepto = new Concepto();
    }

    public void eliminarConcepto() {
        PolizaDao cDao = new PolizaDaoImpl();
        cDao.deleteConcepto(this.concepto);
        this.concepto = new Concepto();
    }

    public List<SelectItem> getListaFolio() {
        this.listaFolio = new ArrayList();
        ViajeDao fDao = new ViajeDaoImpl();
        List<Viaje> f = fDao.listaPorFolio();
        for (Viaje folio : f) {
            SelectItem nombreItem = new SelectItem(folio.getFolioUsuario());
            this.listaFolio.add(nombreItem);
        }
        return this.listaFolio;
    }

    public List<SelectItem> getListNombreUsuario() {
        this.listNombreUsuario = new ArrayList();
        PolizaDao uDao = new PolizaDaoImpl();
        List<Usuario> u = uDao.listaporNombre();
        this.listNombreUsuario.clear();

        for (Usuario nombre : u) {
            SelectItem nombreItem = new SelectItem(nombre.getCodigoSap());
            this.listNombreUsuario.add(nombreItem);
        }
        return this.listNombreUsuario;
    }
}
