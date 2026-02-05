/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.FrmLogin;

/**
 *
 * @author EBER
 */
public class ControladorLogin {
    public String validar(String usuario, String clave){
        UsuarioDAO u = new UsuarioDAO();
        FrmLogin log = new FrmLogin();
        List<Usuario>credenciales = u.listar();
        for(Usuario val: credenciales){
            switch(val.getRol()){
                case "ADMIN":
                    if(val.getUsuario().equals(usuario)&&val.getPassword().equals(clave)){
                        System.out.println("Usted es un administrador");
                        return "admin";
                    }else{
                        JOptionPane.showMessageDialog(log, "Usuario y/o contraseña incorrectos, Ingrese nuevamente");
                        return "error";
                    }
                case "USER":
                    if(val.getUsuario().equals(usuario) && val.getPassword().equals(clave)){
                        System.out.println("Usted es un usuario");
                        return "user";
                    }else{
                        JOptionPane.showMessageDialog(log, "Usuario y/o contraseña incorrectos, Ingrese nuevamente");
                        return "error";
                    }
            }
        }
        
        return null;
        
    }        
}
