package mx.bean.img;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.event.FileUploadEvent;

@javax.inject.Named("ImgNewBean")
@javax.faces.view.ViewScoped
public class ImgNewBean extends mx.conexion.DAO implements java.io.Serializable {

    public void upload(FileUploadEvent event) throws SQLException {
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyFile(String fileName, InputStream in) throws SQLException {
        try {
             ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance()
                    .getExternalContext().getContext();
            String path = ctx.getRealPath("/") + "/resources/upload/";
            
            File directorio = new File(path);
            if (!directorio.exists()) {
                directorio.mkdir();
            }
            //OutputStream dir = new FileOutputStream(new File(getRuta() + fileName));
             OutputStream dir = new FileOutputStream(new File(path + fileName));
            int read = 0;
            byte[] bytes = new byte[51200];
            while ((read = in.read(bytes)) != -1) {
                dir.write(bytes, 0, read);
            }
            setRutaIMG("/resources/upload/" + fileName);
            nuevaImagen();
            Cerrar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE GASTOS", "Imagen actualizada correctamente"));
            in.close();
            dir.flush();
            dir.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
