/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import modelo.Usuario;
import modelo.UsuarioDAO;

/**
 *
 * @author EBER
 */
public class ControladorLogin {
    public String validar(String usuario, String clave){
        UsuarioDAO u = new UsuarioDAO();
        List<Usuario>credenciales = u.listar();
        for(Usuario val: credenciales){
            switch(val.getRol()){
                case "ADMIN":
                    if(val.getUsuario().equals(usuario)&&val.getPassword().equals(clave)){
                        System.out.println("Usted es un administrador");
                        return "admin";
                    }
                    break;
                case "USER":
                    if(val.getUsuario().equals(usuario) && val.getPassword().equals(clave)){
                        System.out.println("Usted es un usuario");
                        return "user";
                    }
                    break;
            }
        }
        
        return null;
        
    }        
}
