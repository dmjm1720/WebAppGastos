package mx.bean;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import mx.dao.RegistrarDao;
import mx.impl.RegistrarDaoImpl;
import mx.model.Concepto;

@Named
@ViewScoped
public class RegistarBean
        implements Serializable {

    private Concepto concepto;

    public Concepto getConcepto() {
        return this.concepto;
    }

    public void setConcepto(Concepto concepto) {
        this.concepto = concepto;
    }

    public void prepararNuevoConcepto() {
        this.concepto = new Concepto();
    }

    public void nuevoConcepto() {
        RegistrarDao uDao = new RegistrarDaoImpl();
        uDao.newUsuario(this.concepto);
    }
}
