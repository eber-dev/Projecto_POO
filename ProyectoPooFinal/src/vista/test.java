/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author EBER
 */
public class test {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:data/almacen.db";
        
        try(Connection conn = DriverManager.getConnection(url)){
            if(conn !=null){
                System.out.println("Conexion Exitosa");
            }
        }catch(SQLException e){
            System.out.println("Error de conexion");
            e.printStackTrace();
        }
        
    }
    
}
