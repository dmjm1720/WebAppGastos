package mx.bean;

import java.io.IOException;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import mx.conexion.DAO;
import mx.dao.ConceptoCargoDao;
import mx.dao.ViajeDao;
import mx.impl.ConceptoCargoDaoImpl;
import mx.impl.ViajeDaoImpl;
import mx.model.Concepto;
import mx.model.Usuario;
import mx.model.Viaje;
import org.primefaces.context.RequestContext;
import org.primefaces.model.UploadedFile;

@Named("conceptoCargoBean")
@ViewScoped
public class conceptoCargoBean extends DAO implements Serializable {

    private List<Concepto> listaConcepto;
    private List<Concepto> listaConceptoUSD;
    private List<SelectItem> listaFolio;
    private List<SelectItem> listNombreUsuario;
    private UploadedFile file;
    private Concepto concepto;

    public List<Concepto> getListaConceptoUSD() {
        ConceptoCargoDao cDao = new ConceptoCargoDaoImpl();
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
        ConceptoCargoDao cDao = new ConceptoCargoDaoImpl();
        this.listaConcepto = cDao.listaConcepto();
        return this.listaConcepto;
    }

    public void prepararNuevoConcepto() {
        this.concepto = new Concepto();
    }

    public UploadedFile getFile() {
        return this.file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void nuevoConcepto() {
        ConceptoCargoDao cDao = new ConceptoCargoDaoImpl();
        this.concepto.setModificarArchivo("NN");
        cDao.nuevoConcepto(this.concepto);
        if (this.concepto.getTipo().equals("Nacional")) {
            RequestContext.getCurrentInstance().execute("PF('dialogNuevoConTCoorp').hide();PF('dialogNuevoConcepto').hide();PF('dlgSubirImagen').show();");
        } else {
            RequestContext.getCurrentInstance().execute("PF('dialogNuevoConTCoorp').hide();PF('dialogNuevoConcepto').hide();PF('dlgDolaresSTC').hide();PF('dlgNewDolares').hide();PF('dlgSubirImagen').show();");
        }
    }

    public void upload() {
        try {
            if (this.file != null) {
                Conectar();
                PreparedStatement ps = getCn().prepareStatement("UPDATE concepto  SET imagen=?, modificarArchivo=NULL WHERE nombreConcepto='" + this.concepto.getNombreConcepto() + "' AND nombreUsuario='" + this.concepto.getNombreUsuario() + "' AND folioUsuario='" + this.concepto.getFolioUsuario() + "'AND estado='Agregar' AND modificarArchivo='NN'");

                ps.setBinaryStream(1, this.file.getInputstream());
                ps.executeUpdate();
                Cerrar();
            }
        } catch (IOException | SQLException localIOException) {
        }
    }

    public void verImagen() throws IOException {
        try {
            byte[] bytes = null;
            Conectar();
            PreparedStatement ps = getCn().prepareStatement("SELECT imagen FROM concepto WHERE idConcepto='" + this.concepto.getIdConcepto() + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                bytes = rs.getBytes("imagen");
            }
            Cerrar();
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            response.getOutputStream().write(bytes);
            response.getOutputStream().close();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (SQLException localSQLException) {
        }
    }

    public void modificarConcepto() {
        ConceptoCargoDao cDao = new ConceptoCargoDaoImpl();
        cDao.updateConcepto(this.concepto);
        this.concepto = new Concepto();
    }

    public void eliminarConcepto() {
        ConceptoCargoDao cDao = new ConceptoCargoDaoImpl();
        cDao.deleteConcepto(this.concepto);
        this.concepto = new Concepto();
    }

    public List<SelectItem> getListaFolio() {
        this.listaFolio = new ArrayList();
        ViajeDao fDao = new ViajeDaoImpl();
        List<Viaje> f = fDao.listaPorFolio();
        for (Viaje nombre : f) {
            SelectItem nombreItem = new SelectItem(nombre.getFolioUsuario());
            this.listaFolio.add(nombreItem);
        }
        return this.listaFolio;
    }

    public List<SelectItem> getListNombreUsuario() {
        this.listNombreUsuario = new ArrayList();
        ConceptoCargoDao uDao = new ConceptoCargoDaoImpl();
        List<Usuario> u = uDao.listaporNombre();
        this.listNombreUsuario.clear();

        for (Usuario nombre : u) {
            SelectItem nombreItem = new SelectItem(nombre.getCodigoSap());
            this.listNombreUsuario.add(nombreItem);
        }
        return this.listNombreUsuario;
    }
}
