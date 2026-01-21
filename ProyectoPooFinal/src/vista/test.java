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
import modelo.Usuario;

/**
 *
 * @author EBER
 */
public class test {
    public static void main(String[] args) {
        String a,b;
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese su usuario: ");
        a= lector.nextLine();
        System.out.println("Ingrese su contraseña: ");
        b= lector.nextLine();
        UsuarioDAO dao = new UsuarioDAO();
        dao.login(a,b);
        
    }
        
}
