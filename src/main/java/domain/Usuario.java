/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author daniel
 */
public class Usuario {

    private int idUsuario;
    private String usuario;
    private String passWord;

    public Usuario() {
    }

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(String usuario, String passWord) {
        this.usuario = usuario;
        this.passWord = passWord;
    }

    public Usuario(int idUsuario, String usuario, String passWord) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.passWord = passWord;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{");
        sb.append("idUsuario=").append(idUsuario);
        sb.append(", usuario=").append(usuario);
        sb.append(", passWord=").append(passWord);
        sb.append('}');
        return sb.toString();
    }
}
