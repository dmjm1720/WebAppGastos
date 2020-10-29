package mx.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import mx.dao.CategoriaDao;
import mx.impl.CategoriaDaoImpl;
import mx.model.Categoria;
import mx.model.Usuario;

@Named("CategoriaBean")
@ViewScoped
public class CategoriaBean implements Serializable {

    private Categoria categoria;
    private List<Categoria> listaCategoria;
    private List<SelectItem> listPorDepto;
    private List<SelectItem> listPorNombre;

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setListaCategoria(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    public List<Categoria> getListaCategoria() {
        CategoriaDao cDao = new CategoriaDaoImpl();
        this.listaCategoria = cDao.listaCategoria();
        return this.listaCategoria;
    }

    public void prepararNuevaCategoria() {
        this.categoria = new Categoria();
    }

    public void nuevoCategoria() {
        CategoriaDao cDao = new CategoriaDaoImpl();
        cDao.newCategoria(this.categoria);
    }

    public void modificarCategoria() {
        CategoriaDao cDao = new CategoriaDaoImpl();
        cDao.updateCategoria(this.categoria);
        this.categoria = new Categoria();
    }

    public void eliminarCategoria() {
        CategoriaDao cDao = new CategoriaDaoImpl();
        cDao.deleteCategoria(this.categoria);
        this.categoria = new Categoria();
    }

    public List<SelectItem> getListPorDepto() {
        this.listPorDepto = new ArrayList();
        CategoriaDao fDao = new CategoriaDaoImpl();
        List<Categoria> f = fDao.listaCategoria();
        for (Categoria nombre : f) {
            SelectItem nombreItem = new SelectItem(nombre.getSubDepartamento());
            this.listPorDepto.add(nombreItem);
        }
        return this.listPorDepto;
    }

    public List<SelectItem> getListPorNombre() {
        this.listPorNombre = new ArrayList();
        CategoriaDao nDao = new CategoriaDaoImpl();
        List<Usuario> s = nDao.listaUsuarios();
        for (Usuario nombre : s) {
            SelectItem nombreItem = new SelectItem(nombre.getNombre());
            this.listPorNombre.add(nombreItem);
        }

        return this.listPorNombre;
    }
}
