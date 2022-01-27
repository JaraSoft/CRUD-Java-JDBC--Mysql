/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import domain.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daniel
 */
public class UsuarioDAO {

    private static final String SQL_SELECT = "SELECT * FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario(usuario, password) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET usuario = ?, password = ? WHERE idusuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE idusuario = ?";

    public List<Usuario> seleccionar() {
        Connection conn = null;
        PreparedStatement instruccion = null;
        ResultSet resultado = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            conn = Conexion.getConexion();
            instruccion = conn.prepareStatement(SQL_SELECT);
            resultado = instruccion.executeQuery();
            while (resultado.next()) {
                usuarios.add(new Usuario(resultado.getInt("idusuario"), resultado.getNString("usuario"), resultado.getNString("password")));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(resultado);
                Conexion.close(instruccion);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return usuarios;
    }

    public int insertar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement instruccion = null;
        var registros = 0;
        try {
            conn = Conexion.getConexion();
            instruccion = conn.prepareStatement(SQL_INSERT);
            instruccion.setString(1, usuario.getUsuario());
            instruccion.setString(2, usuario.getPassWord());
            registros = instruccion.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(instruccion);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int actualizar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement instruccion = null;
        var registrosActualizados = 0;
        try {
            conn = Conexion.getConexion();
            instruccion = conn.prepareStatement(SQL_UPDATE);
            instruccion.setString(1, usuario.getUsuario());
            instruccion.setString(2, usuario.getPassWord());
            instruccion.setInt(3, usuario.getIdUsuario());
            registrosActualizados = instruccion.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(instruccion);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registrosActualizados;
    }

    public int eliminar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement instruccion = null;
        var registrosActualizados = 0;
        try {
            conn = Conexion.getConexion();
            instruccion = conn.prepareStatement(SQL_DELETE);
            instruccion.setInt(1, usuario.getIdUsuario());
            registrosActualizados = instruccion.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(instruccion);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registrosActualizados;
    }
}
