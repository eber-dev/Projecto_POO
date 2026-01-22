/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import modelo.UsuarioDAO;
import modelo.producto;
import modelo.productoDAO;
import java.util.Scanner;
import modelo.Movimiento;
import modelo.MovimientosDAO;
import modelo.Usuario;

/**
 *
 * @author EBER
 */
public class test {
    public static void main(String[] args) throws SQLException {
        /*String a,b;
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese su usuario: ");
        a= lector.nextLine();
        System.out.println("Ingrese su contraseña: ");
        b= lector.nextLine();
        UsuarioDAO dao = new UsuarioDAO();
        dao.login(a,b);*/
        
        MovimientosDAO mov = new MovimientosDAO();
        /*List<Movimiento> transaccion = mov.listar();
        
        for(Movimiento e: transaccion){
            System.out.println(e.getTipo());
        }*/
        
        Movimiento ga = new Movimiento(6,"ENTRADA",18,"2026-01-22");
        if(mov.insertar(ga)){
            System.out.println("mal");
        }else{
            System.out.println("nice");
        }     
    }
        
}
