/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import domain.Persona;
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
public class PersonaDAO {

    private static final String SQL_SELECT = "SELECT * FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE idpersona = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE idpersona = ?";

    public List<Persona> seleccionar() {
        Connection conn = null;
        PreparedStatement instruccion = null;
        ResultSet resultado = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            conn = Conexion.getConexion();
            instruccion = conn.prepareStatement(SQL_SELECT);
            resultado = instruccion.executeQuery();
            while (resultado.next()) {
                int idPersona = resultado.getInt("idpersona");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                String eMail = resultado.getNString("email");
                double telefono = resultado.getDouble("telefono");
                persona = new Persona(idPersona, nombre, apellido, eMail, telefono);
                personas.add(persona);
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
        return personas;
    }

    public int insertar(Persona persona) {
        Connection conn = null;
        PreparedStatement instruccion = null;
        int registros = 0;
        try {
            conn = Conexion.getConexion();
            instruccion = conn.prepareStatement(SQL_INSERT);
            instruccion.setString(1, persona.getNombre());
            instruccion.setString(2, persona.getApellido());
            instruccion.setString(3, persona.geteMail());
            instruccion.setDouble(4, persona.getTelefono());
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
    public int actualizar(Persona persona) {
        Connection conn = null;
        PreparedStatement instruccion = null;
        int registrosactualizados = 0;
        try {
            conn = Conexion.getConexion();
            instruccion = conn.prepareStatement(SQL_UPDATE);
            instruccion.setString(1, persona.getNombre());
            instruccion.setString(2, persona.getApellido());
            instruccion.setString(3, persona.geteMail());
            instruccion.setDouble(4, persona.getTelefono());
            instruccion.setInt(5, persona.getIdPersona());
            registrosactualizados = instruccion.executeUpdate();
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
        return registrosactualizados;
    }
    public int eliminar(Persona persona){
        Connection conn = null;
        PreparedStatement instruccion = null;
        int registrosEliminados = 0;
        try{
            conn = Conexion.getConexion();
            instruccion = conn.prepareStatement(SQL_DELETE);
            instruccion.setInt(1, persona.getIdPersona());
            registrosEliminados = instruccion.executeUpdate();
        }catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(instruccion);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registrosEliminados;
    }
    

}
