/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import modelo.producto;
import modelo.productoDAO;

/**
 *
 * @author EBER
 */
public class test {
    public static void main(String[] args) {
        
        /*producto p = new producto("Mouse", 25.5, 10);
        productoDAO dao = new productoDAO();

        if (dao.insertar(p)) {
            System.out.println("Insertado correctamente");
        }*/
        
        
        
        productoDAO dao = new productoDAO();
        List<producto> productos =dao.listar();
        
        for(producto p: productos){
            System.out.println(p.getNombre());
            System.out.println(p.getId());
        }
        
        /*String url = "jdbc:sqlite:data/almacen.db";
        
        try(Connection conn = DriverManager.getConnection(url)){
            if(conn !=null){
                System.out.println("Conexion Exitosa");
            }
        }catch(SQLException e){
            System.out.println("Error de conexion");
            e.printStackTrace();
        }*/
        
    }
    
}
