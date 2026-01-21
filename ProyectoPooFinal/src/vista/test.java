/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import modelo.UsuarioDAO;
import modelo.producto;
import modelo.productoDAO;
import java.util.Scanner;

/**
 *
 * @author EBER
 */
public class test {
    public static void main(String[] args) {
        
        /*productoDAO dao = new productoDAO();
        producto producto = new producto("Teclado 2.0",90,8,4);*/
        
        
        UsuarioDAO credenciales = new UsuarioDAO();
        String[][] fijas = credenciales.login();
        
            System.out.println(fijas[0][0]); // 1
            System.out.println(fijas[0][1]); // 2
            System.out.println(fijas[1][0]); // 3
            System.out.println(fijas[1][1]); // 4

        
        
        /*if(dao.insertar(producto)){
            System.out.println("Producto insertado exitosamente");
        }*/   
    }
}
