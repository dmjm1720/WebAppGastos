package mx.bean.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import mx.model.Usuario;
import org.primefaces.event.FileUploadEvent;

@Named("FileUploadAsignacionPDFBean")
@ViewScoped
public class FileUploadAsignacionPDFBean
        implements Serializable {

    private final String destination = "C:\\PDF\\";
    private final String ruta = "C:\\inetpub\\wwwroot\\files\\";

    public void upload(FileUploadEvent event) {
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
            FacesMessage msg = new FacesMessage("SISTEMA DE GASTOS ", event.getFile().getFileName() + " Archivo subido correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyFile(String fileName, InputStream in) {
        try {
            Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
            Date fecha = new Date();
            String fileNew = fecha.toString();
            String var = fileNew.replace(":", "");
            String var2 = var.replace(" ", "");
            String var3 = var2 + ".file";
            File newdirectorio = new File("C:\\PDF\\" + var3);
            String novo = newdirectorio + "\\";
            newdirectorio.mkdir();
            OutputStream out = new FileOutputStream(new File(novo + us.getCodigoSap() + "@" + us.getFolioUsuario() + "@12@N@X@" + fileName));
            OutputStream dir = new FileOutputStream(new File("C:\\inetpub\\wwwroot\\files\\" + fileName));

            int read = 0;
            byte[] bytes = new byte['᐀'];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
                dir.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            dir.flush();
            out.close();
            dir.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
