package mx.conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import mx.model.Concept;

public class ConceptDAO extends DAO {

    public List<Concept> listar(String nombre, String folio) throws Exception {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        String nombre = request.getParameter("frmVer:codigo");
//        String folio = request.getParameter("frmVer:folio");

        List<Concept> lista = new java.util.ArrayList();
        try {
            Conectar();
            PreparedStatement st = getCn().prepareCall("SELECT nombreConcepto, totalmxn, factura, rutaPDF, rutaXML, rutaImagen, uuid, rfc, nombre, importe, iva FROM Concepto WHERE nombreUsuario='" + nombre + "' AND folioUsuario='" + folio + "' ");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Concept conc = new Concept();
                conc.setNombreConcepto(rs.getString("nombreConcepto"));
                conc.setTotalmxn(rs.getBigDecimal("totalmxn"));
                conc.setFactura(rs.getString("factura"));
                conc.setRutaPdf(rs.getString("rutaPDF"));
                conc.setRutaXml(rs.getString("rutaXML"));
                conc.setRutaImagen(rs.getString("rutaImagen"));
                conc.setUuid(rs.getString("uuid"));
                conc.setRfc(rs.getString("rfc"));
                conc.setNombre(rs.getString("nombre"));
                conc.setImporte(rs.getBigDecimal("importe"));
                conc.setIva(rs.getBigDecimal("iva"));
                lista.add(conc);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            Cerrar();
        }
        return lista;
    }
}
