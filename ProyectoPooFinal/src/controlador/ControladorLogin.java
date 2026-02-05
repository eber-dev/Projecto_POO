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
        
        if(usuario == null || clave == null || usuario.trim().isEmpty() || usuario.trim().isEmpty()){
            return "vacio";
        }
        
        for(Usuario val: credenciales){
            if(val.getUsuario().equals(usuario) && val.getPassword().equals(clave)){
                if(val.getRol().equals("ADMIN")){
                    return "admin";
                }
                
                if(val.getRol().equals("USER")){
                    return "user";
                }
            }
        }
        
        return "error";    
    }        
}
