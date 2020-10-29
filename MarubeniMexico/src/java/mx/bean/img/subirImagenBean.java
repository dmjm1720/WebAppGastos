package mx.bean.img;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

@Named("subirImagenBean")
@ViewScoped
public class subirImagenBean extends mx.conexion.DAO implements Serializable {

    private UploadedFile file;
    private StreamedContent descarga;

    public UploadedFile getFile() {
        return this.file;
    }

    public void setFile(UploadedFile file) {
         this.file = file;
    }

    public StreamedContent getDescarga() {
         return this.descarga;
    }

    public void setDescarga(StreamedContent descarga) {
         this.descarga = descarga;
    }

    public void upload() {
        try {
            if (this.file != null) {
                Conectar();
                PreparedStatement ps = getCn().prepareStatement("UPDATE concepto  SET imagen=? WHERE nombreConcepto='Avión' AND nombreUsuario='MAG010' AND folioUsuario='05'");
                ps.setBinaryStream(1, this.file.getInputstream());
                ps.executeUpdate();
                Cerrar();
            }
        } catch (IOException | SQLException localIOException) {
        }
    }

    public void donwload() {
        try {
            Conectar();
            PreparedStatement ps = getCn().prepareStatement("SELECT imagen FROM concepto WHERE idConcepto=17432");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                InputStream stream = rs.getBlob("imagen").getBinaryStream();
                this.descarga = new DefaultStreamedContent(stream, "image/jpg", "descarga.jpg");
            }
            Cerrar();
        } catch (SQLException localSQLException) {
        }
    }

    public void ver(int folio)
            throws IOException {
        try {
            byte[] bytes = null;
            Conectar();
            PreparedStatement ps = getCn().prepareStatement("SELECT imagen FROM concepto WHERE idConcepto='" + folio + "'");
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
}
