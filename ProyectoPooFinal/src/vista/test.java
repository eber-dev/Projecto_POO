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
import java.util.ArrayList;
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
        UsuarioDAO d = new UsuarioDAO();
        List<Usuario> val = d.listar();
        
        for(Usuario p: val){
            System.out.println(p.getNombre());
        }
        
        /*Usuario u = new Usuario("Juan","Perez","juanperez","1234","USER");*/
        
        /*if(d.eliminar(3)){
            System.out.println("Nice");
        }else{
            System.out.println("no");
        }*/
        
        
        
        
        
    }
        
}
