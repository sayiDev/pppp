/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author loren
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
public class RolDAO {
     conexionBD conexion = new conexionBD();

    public void agregarRol(String rol, String nombre) {
        String sql = "INSERT INTO roles (rol, nombre) VALUES (?, ?)";

        try (Connection con = conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, rol);
            ps.setString(2, nombre);
            ps.executeUpdate();
            System.out.println("Rol agregado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al agregar: " + e.getMessage());
        }
    }
    
public void cargarRoles(DefaultTableModel model) {
    String sql = "SELECT * FROM roles";
    try (Connection con = conexion.conectar();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        model.setRowCount(0); // limpiar la tabla

        while (rs.next()) {
            Object[] row = {
                rs.getInt("id"),
                rs.getString("rol"),
                rs.getString("nombre")
            };
            model.addRow(row);
        }
    } catch (SQLException e) {
        System.out.println("Error al consultar: " + e.getMessage());
    }
}
public void actualizarRol(int id, String rol, String nombre) {
    String sql = "UPDATE roles SET rol = ?, nombre = ? WHERE id = ?";

    try (Connection con = conexion.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, rol);
        ps.setString(2, nombre);
        ps.setInt(3, id);
        ps.executeUpdate();
        System.out.println("Rol actualizado correctamente");

    } catch (SQLException e) {
        System.out.println("Error al actualizar: " + e.getMessage());
    }
}
public void eliminarRol(int id) {
    String sql = "DELETE FROM roles WHERE id = ?";

     try (Connection con = conexion.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Error al eliminar: " + e.getMessage());
    }
}
}



