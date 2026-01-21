/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author EBER
 */
public class UsuarioDAO {
    
    public Usuario login (String user,String password){
        Usuario credencial = new Usuario(user ,password);
        String[] usuario  = new String[2];
        String[] contraseña  = new String[2];
        int contador = 0;
        String url = "jdbc:sqlite:data/almacen.db";
        try(Connection conexion = DriverManager.getConnection(url)){
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT usuario,password FROM usuarios");
            while(rs.next()&& contador<2){
                usuario[contador] = rs.getString("usuario");
                contraseña[contador] = rs.getString("password");
                contador++;
            }
            
            boolean condicion1 = credencial.getUsuario().equals(usuario[0])&&credencial.getPassword().equals(contraseña[0]);
            boolean condicion2 = credencial.getUsuario().equals(usuario[1])&&credencial.getPassword().equals(contraseña[1]);
            
            if(condicion1 || condicion2){
                return credencial;
            }
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return null;
    }
        
}
