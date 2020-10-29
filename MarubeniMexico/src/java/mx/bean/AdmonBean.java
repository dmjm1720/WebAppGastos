package mx.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import mx.conexion.ConceptDAO;
import mx.dao.AdmonDao;
import mx.impl.AdmonDaoImpl;
import mx.model.Categoria;
import mx.model.Concept;
import mx.model.Concepto;
import mx.model.Usuario;
import mx.model.Viaje;

@Named
@ViewScoped
public class AdmonBean
        implements Serializable {

    private List<Viaje> listaViaje;
    private Viaje viaje;
    private List<SelectItem> listNombreUsuario;
    private List<SelectItem> listPorDepto;
    private List<Viaje> lisSAT;
    private List<Concepto> listarPolizaUsuario;
    private String folioUsuario;
    private String nombreViajero;
    private List<Concepto> listaDePolizas;
    private List<Concept> listaPol;

    public List<SelectItem> getListPorDepto() {
        return this.listPorDepto;
    }

    public void setListPorDepto(List<SelectItem> listPorDepto) {
        this.listPorDepto = listPorDepto;
    }

    public void setListaViaje(List<Viaje> listaViaje) {
        this.listaViaje = listaViaje;
    }

    public Viaje getViaje() {
        return this.viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    public List<Viaje> getListaViaje() {
        AdmonDao vDao = new AdmonDaoImpl();
        this.listaViaje = vDao.listaViajes();
        return this.listaViaje;
    }

    public void prepararNuevoViaje() {
        this.viaje = new Viaje();
    }

    public void nuevoViaje() {
        AdmonDao vDao = new AdmonDaoImpl();
        vDao.newViaje(this.viaje);
    }

    public void modificarViaje() {
        AdmonDao vDao = new AdmonDaoImpl();
        vDao.updateViaje(this.viaje);
        this.viaje = new Viaje();
    }

    public void eliminarViaje() {
        AdmonDao vDao = new AdmonDaoImpl();
        vDao.deleteViaje(this.viaje);
        this.viaje = new Viaje();
    }

    public List<SelectItem> getListNombreUsuario() {
        this.listNombreUsuario = new ArrayList();
        AdmonDao uDao = new AdmonDaoImpl();
        List<Usuario> u = uDao.listaporNombre();
        this.listNombreUsuario.clear();

        for (Usuario nombre : u) {
            SelectItem nombreItem = new SelectItem(nombre.getCodigoSap());
            this.listNombreUsuario.add(nombreItem);
        }
        return this.listNombreUsuario;
    }

    public List<Viaje> getLisSAT() {
        return this.lisSAT;
    }

    public List<SelectItem> getlistPorDepto() {
        this.listPorDepto = new ArrayList();
        AdmonDao uDao = new AdmonDaoImpl();
        List<Categoria> u = uDao.listaDepto();
        this.listPorDepto.clear();

        for (Categoria nombre : u) {
            SelectItem nombreItem = new SelectItem(nombre.getSubDepartamento());
            this.listPorDepto.add(nombreItem);
        }

        return this.listPorDepto;
    }

    public List<Concepto> getListarPolizaUsuario() {
        AdmonDao vDao = new AdmonDaoImpl();
        this.listarPolizaUsuario = vDao.listarPoliza();
        return this.listarPolizaUsuario;
    }

    public void setListarPolizaUsuario(List<Concepto> listarPolizaUsuario) {
        this.listarPolizaUsuario = listarPolizaUsuario;
    }

    public String getFolioUsuario() {
        return this.folioUsuario;
    }

    public void setFolioUsuario(String folioUsuario) {
        this.folioUsuario = folioUsuario;
    }

    public String getNombreViajero() {
        return this.nombreViajero;
    }

    public void setNombreViajero(String nombreViajero) {
        this.nombreViajero = nombreViajero;
    }

    public List<Concepto> getListaDePolizas() {
        AdmonDao aDao = new AdmonDaoImpl();
        this.listaDePolizas = aDao.listarPoliza();
        return this.listaDePolizas;
    }

    public void setListaDePolizas(List<Concepto> listaDePolizas) {
        this.listaDePolizas = listaDePolizas;
    }

    public List<Concept> getListaPol() {
        return this.listaPol;
    }

    public void setListaPol(List<Concept> listaPol) {
        this.listaPol = listaPol;
    }

    public void miLista() throws Exception {
        ConceptDAO aDao = new ConceptDAO();
        try {
            this.listaPol = aDao.listar("", "");
        } catch (Exception ex) {
            throw ex;
        }
    }
}
