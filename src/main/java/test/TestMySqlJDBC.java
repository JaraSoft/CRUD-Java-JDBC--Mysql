/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.sql.*;

/**
 *
 * @author daniel
 */
public class TestMySqlJDBC {

    public static void main(String[] args) {
        final var url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "N1ñ0##99");
            Statement instruccion = conexion.createStatement();
            var sql = "SELECT idpersona, nombre, apellido, email, telefono FROM persona";
            var resultado = instruccion.executeQuery(sql);
            while (resultado.next()) {
                System.out.print("idpersona = " + resultado.getInt("idpersona"));
                System.out.print(" nombre = " + resultado.getString("nombre"));
                System.out.print(" apellido = " + resultado.getString("apellido"));
                System.out.print(" email = " + resultado.getString("email"));
                System.out.print(" telefono = " + resultado.getDouble("telefono"));
                System.out.println();
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
