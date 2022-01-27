/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.List;

/**
 *
 * @author daniel
 */
public class TestManejoUsuarios {
    public static void main(String[] args) {
        var usuarioDAO = new UsuarioDAO();
        //usuarioDAO.insertar(new Usuario("Kellyguira", "LaV1stima"));
        //usuarioDAO.actualizar(new Usuario(3, "KellyJ", "Holatodos"));
        usuarioDAO.eliminar(new Usuario(3));
        List<Usuario> usuarios = usuarioDAO.seleccionar();
        usuarios.forEach((var usuario) -> System.out.println(usuario));
    }
}
