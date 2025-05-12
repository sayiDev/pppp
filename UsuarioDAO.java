/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author loren
 */
public class UsuarioDAO {
 Connection con;
    conexionBD cn = new conexionBD(); // Tu clase de conexión
    PreparedStatement ps;
    ResultSet rs;

    public boolean verificarLogin(String usuarios, String contraseña) {
        String sql = "SELECT * FROM usuarios WHERE usuarios = ? AND contraseña = ?";
        try {
            Connection con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuarios);
            ps.setString(2, contraseña);
            rs = ps.executeQuery();
            return rs.next(); // Si hay resultado, las credenciales son correctas
        } catch (SQLException e) {
            System.out.println("Error al verificar login: " + e.getMessage());
        }
        return false;
    }
}

