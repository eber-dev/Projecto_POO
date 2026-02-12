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
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EBER
 */
public class UsuarioDAO {
    public List<Usuario>listar(){
        List<Usuario> lista = new ArrayList<>();
        String url = "jdbc:sqlite:data/almacen.db";
        try(Connection conexion = DriverManager.getConnection(url)){
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_usuario,nombre,apellido,usuario,password,rol FROM usuarios");
            while(rs.next()){
                int id_usuario = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String usuario = rs.getString("usuario");
                String password = rs.getString("password");
                String rol = rs.getString("rol");
                
                Usuario credencial = new Usuario(id_usuario,nombre,apellido,usuario,password,rol);
                
                lista.add(credencial);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return lista;
    }
    
    public boolean insertar(Usuario u){
        String sql = "INSERT INTO usuarios(nombre,apellido,usuario,password,rol) VALUES (?,?,?,?,?)";
        String url = "jdbc:sqlite:data/almacen.db";
        
        try(Connection conexion= DriverManager.getConnection(url);
            PreparedStatement ps = conexion.prepareStatement(sql)){
            
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellido());
            ps.setString(3, u.getUsuario());
            ps.setString(4, u.getPassword());
            ps.setString(5, u.getRol());
            
            int filas = ps.executeUpdate();
            return filas>0;
            
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }

    }
    
    public boolean actualizarprivilegios(Usuario u){
        String sql = "UPDATE usuarios SET rol = ?" + "WHERE id_usuario = ?";
        String url = "jdbc:sqlite:data/almacen.db";
        
        try(Connection conexion = DriverManager.getConnection(url);
            PreparedStatement ps = conexion.prepareStatement(sql)){
            
            try(Statement stmt = conexion.createStatement()){
                stmt.execute("PRAGMA foreign_keys = ON");
            }
            
            ps.setString(1, u.getRol());
            ps.setInt(2, u.getId_usuario());
            
            int filas = ps.executeUpdate();
            return filas>0;
            
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean actualizarpassword(Usuario u){
        String sql = "UPDATE usuarios SET password = ?"+"WHERE id_usuario = ?";
        String url = "jdbc:sqlite:data/almacen.db";
        
        try(Connection conexion = DriverManager.getConnection(url);
            PreparedStatement ps = conexion.prepareStatement(sql)){
            
            try(Statement stmt = conexion.createStatement()){
                stmt.execute("PRAGMA foreign_keys = ON");
            }
            
            ps.setString(1, u.getPassword());
            ps.setInt(2, u.getId_usuario());
            
            int filas = ps.executeUpdate();
            return filas>0;
            
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean eliminar(int id){
        String sql = "DELETE FROM usuarios WHERE id_usuario = ?";
        String url = "jdbc:sqlite:data/almacen.db";
        
        try(Connection conexion = DriverManager.getConnection(url);
            PreparedStatement ps = conexion.prepareStatement(sql)){
            
            ps.setInt(1, id);
            
            int filas = ps.executeUpdate();
            return filas>0;
            
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }


    }
    
    
        
}
