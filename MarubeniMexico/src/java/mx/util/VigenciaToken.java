
package mx.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import mx.conexion.DAO;

public class VigenciaToken extends DAO {

    public void actualizarFechaVigenciaToken(String token, String vigencia, String nombre) throws SQLException {
        this.Conectar();
        try (PreparedStatement ps = getCn().prepareStatement("UPDATE usuario SET token = ?, tokenVigencia = ? WHERE nombre = ?")) {
            ps.setString(1, token);
            ps.setString(2, vigencia); // Conversion si es necesario
            ps.setString(3, nombre);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar los datos del usuario: " + e.getMessage());
            e.printStackTrace();
        }
        Cerrar();
        this.Cerrar();
    }
}
