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
            ResultSet rs = stmt.executeQuery("SELECT id,nombre,precio,stock,id_categoria FROM productos");
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                int id_categoria = rs.getInt("id_categoria");
                
                producto p = new producto(id,nombre,precio,stock,id_categoria);
                lista.add(p);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return lista;
        
    }
    
    public boolean insertar(producto p) {
        String sql = "INSERT INTO productos(nombre, precio, stock,id_categoria) VALUES (?, ?, ?,?)";
        String url = "jdbc:sqlite:data/almacen.db";

        try (Connection conexion = DriverManager.getConnection(url);
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setInt(4, p.getId_categoria());

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean actualizar(producto p){
        String sql = "UPDATE productos SET nombre = ?, precio = ?, stock = ?, id_categoria = ? "
               + "WHERE id = ?";

        String url = "jdbc:sqlite:data/almacen.db";
        
        try(Connection conexion = DriverManager.getConnection(url);
         PreparedStatement ps = conexion.prepareStatement(sql)) {
            
            ps.setString(1, p.getNombre());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setInt(4, p.getId_categoria());

            ps.setInt(5, p.getId());

            int filas = ps.executeUpdate();
            return filas > 0;

        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean actualizar_nombre(int id, String Nombre){
        String sql = "UPDATE productos SET nombre = ? "+"WHERE id = ?";
        String url = "jdbc:sqlite:data/almacen.db";
        
        try(Connection conexion = DriverManager.getConnection(url);
         PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setString(1,Nombre);
            ps.setInt(2, id);
            
            int filas = ps.executeUpdate();
            return filas>0;
            
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        
    }
    
    public boolean actualizar_precio(int id,double precio){
        String sql = "UPDATE productos SET precio = ?"+"WHERE id = ?";
        String url = "jdbc:sqlite:data/almacen.db";
        
        try(Connection conexion = DriverManager.getConnection(url);
         PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setDouble(1, precio);
            ps.setInt(2, id);
            
            int filas = ps.executeUpdate();
            return filas>0;
            
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean eliminar(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";
        String url = "jdbc:sqlite:data/almacen.db";

        try (Connection conexion = DriverManager.getConnection(url);
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, id);

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
}

    
    
    
    
    

    
    
}
