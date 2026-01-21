/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author EBER
 */
public class Usuario {
    private int id_usuario;
    private String usuario;
    private String password;
    private String rol;
    
    public Usuario(int id_usuario,String usuario,String password,String rol){
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.password = password;
        this.rol = rol;
    }
    
    public Usuario(String usuario,String password){
        this.usuario = usuario;
        this.password = password;
    }
    

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
    
}
