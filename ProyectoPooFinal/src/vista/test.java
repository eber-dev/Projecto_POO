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
        
        productoDAO dao = new productoDAO();
        producto producto = new producto("Teclado 2.0",90,8,4);
        
        /*if(dao.insertar(producto)){
            System.out.println("Producto insertado exitosamente");
        }*/
        
        if(dao.actualizar_precio(56, 120)){
            System.out.println("El precio fue cambiado exitosamente");
        }else{
            System.out.println("BAKA BAKA BAKA muuuu");
        }
        
        
    }
}
