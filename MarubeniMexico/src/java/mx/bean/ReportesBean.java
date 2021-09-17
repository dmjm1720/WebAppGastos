package mx.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import mx.dao.ConceptoDao;
import mx.impl.ConceptoDaoImpl;
import mx.model.Concepto;

@Named(value = "repBean")
@ViewScoped
public class ReportesBean implements Serializable {

    private List<Concepto> lista;
    private Date fecha1;
    private Date fecha2;

    public ReportesBean() {
        this.lista = new ArrayList<>();

    }

    public Date getFecha1() {
        return fecha1;
    }

    public void setFecha1(Date fecha1) {
        this.fecha1 = fecha1;
    }

    public Date getFecha2() {
        return fecha2;
    }

    public void setFecha2(Date fecha2) {
        this.fecha2 = fecha2;
    }

    public List<Concepto> getLista() {
        return lista;
    }

    public void buscarPorFecha() {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String f1 = simpleDateFormat.format(fecha1);
        String f2 = simpleDateFormat.format(fecha2);
        ConceptoDao cDao = new ConceptoDaoImpl();
        this.lista = cDao.listaConceptoReporte(f1, f2);
        getLista();
    }
}
