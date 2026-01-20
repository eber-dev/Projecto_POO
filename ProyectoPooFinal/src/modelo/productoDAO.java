/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author EBER
 */
public class productoDAO {
    public List<producto> listar(){
        List<producto> lista = new ArrayList<>();
        String url = "jdbc:sqlite:data/almacen.db";
        try(Connection conexion = DriverManager.getConnection(url)){
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id,nombre,precio,stock FROM productos");
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                
                producto p = new producto(id,nombre,precio,stock);
                lista.add(p);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return lista;
        
    }
    
    public List<producto> insertar(producto p){
        List<producto> lista = new ArrayList<>();
        String url = "jdbc:sqlite:data/almacen.db";
        String agregar = "INSERT INTO producto(nombre,producto,stock) VALUES (?,?,?)";
        try(Connection conexion = DriverManager.getConnection(url)){
            PreparedStatement ps = conexion.prepareStatement(agregar);
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            
            ps.executeUpdate();
            
            lista = listar();
        }catch(SQLException e){
            e.printStackTrace();
        }

        
        return lista;
    }
    
    
}
