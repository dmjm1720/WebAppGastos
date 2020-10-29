package mx.bean;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import mx.conexion.DAO;
import mx.model.Usuario;

public class MakeFile extends DAO {
    
    Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
    
    ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    String path = ctx.getRealPath("/") + "/resources/upload/";
    
    public void txt(String ruta, String nombreArchivo) {
        try {
            File file = new File(ruta + us.getCodigoSap() + "_" + nombreArchivo.replace(".pdf", ".txt").replace(".PDF", ".txt"));
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        
    }
    
    public void buscarArchivo(File ruta) {
        
        File[] archivo = ruta.listFiles();
        if (archivo != null) {
            for (File Arc : archivo) {
                if (Arc.isDirectory()) {
                    buscarArchivo(Arc);
                } else {
                    if (Arc.getName().endsWith(".txt") || Arc.getName().contains(us.getCodigoSap())) {
                        actualizarPDF(Arc.getName().replace(path, "").replace(us.getCodigoSap().concat("_"), "").replace(".txt", ".pdf"));
                        Arc.delete();
                    }
                }
            }
        }
    }
    
    public void actualizarPDF(String nombreTxt) {
        nombreTxt = "/resources/upload/" + nombreTxt;
        try {
            this.Conectar();
            PreparedStatement psConsulta = getCn().prepareStatement("SELECT TOP(1) idConcepto, rutaPDF FROM concepto "
                    + "WHERE nombreUsuario='" + us.getCodigoSap() + "' AND rutaPDF='' OR rutaPDF IS NULL ORDER BY idConcepto DESC");
            ResultSet rs = psConsulta.executeQuery();
            if (!rs.isBeforeFirst()) {
                
            } else {
                while (rs.next()) {
                        PreparedStatement psActualiza = getCn().prepareStatement("UPDATE concepto SET rutaPDF='" + nombreTxt + "'  "
                                + "WHERE nombreUsuario='" + us.getCodigoSap() + "' AND idConcepto= '" + rs.getInt("idConcepto") + "'");
                        psActualiza.executeUpdate();
                }
            }
            this.Cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(MakeFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void buscarArchivoSinXML(File ruta) {
        
        File[] archivo = ruta.listFiles();
        if (archivo != null) {
            for (File Arc : archivo) {
                if (Arc.isDirectory()) {
                    buscarArchivo(Arc);
                } else {
                    if (Arc.getName().endsWith(".txt") || Arc.getName().contains(us.getCodigoSap())) {
                        Arc.delete();
                    }
                }
            }
        }
    }
    
}
