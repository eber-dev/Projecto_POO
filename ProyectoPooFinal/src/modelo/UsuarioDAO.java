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
    
    public String[][] login (){
        String[][] credenciales = new String[2][2];
        String[] usuario = new String[2];
        String[] contraseña = new String[2];
        int a = 0;
        String url = "jdbc:sqlite:data/almacen.db";
        try(Connection conexion = DriverManager.getConnection(url);
            Statement stmt = conexion.createStatement()){
              ResultSet rs = stmt.executeQuery("SELECT usuario,password FROM usuarios");
              while(rs.next()&& a<2){
                   usuario[a] = rs.getString("usuario");
                   contraseña[a] = rs.getString("password");
                   a++;
              }
              
              for(int i=0; i<credenciales.length;i++){
                  credenciales[0][i]=usuario[i];
              }
              
              for(int i = 0;i<credenciales.length;i++){
                  credenciales[1][i] = contraseña[i];
              }
                    
        }catch(SQLException e){
            e.printStackTrace();
        }   
        return credenciales;
    }
    
}
