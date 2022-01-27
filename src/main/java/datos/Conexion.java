/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.*;

/**
 *
 * @author daniel
 */
public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "---------";

    public static Connection getConexion() throws ClassNotFoundException, SQLException {
       
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            return conexion;    
    }
    public static void close(ResultSet resultado) throws SQLException{
        resultado.close();
    }
    public static void close(Statement instruccion) throws SQLException{
        instruccion.close();
    }
        public static void close(PreparedStatement instruccion) throws SQLException{
        instruccion.close();
    }
        public static void close(Connection conn) throws SQLException{
        conn.close();
    }
}

