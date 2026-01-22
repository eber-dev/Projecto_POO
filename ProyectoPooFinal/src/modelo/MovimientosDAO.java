/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
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
public class MovimientosDAO {
    public List<Movimiento> listar(){
        List<Movimiento> lista = new ArrayList<>();
        String url = "jdbc:sqlite:data/almacen.db";
        try(Connection conexion = DriverManager.getConnection(url)){
            Statement stmt = conexion.createStatement();
            stmt.execute("PRAGMA foreign_keys = ON");
            ResultSet rs = stmt.executeQuery("SELECT id_movimiento,id_producto,tipo,cantidad,fecha FROM movimientos_stock");
            while(rs.next()){
                int id_movimiento = rs.getInt("id_movimiento");
                int id_producto = rs.getInt("id_producto");
                String tipo = rs.getString("tipo");
                int cantidad = rs.getInt("cantidad");
                String fecha = rs.getString("fecha");
                
                Movimiento mov = new Movimiento(id_movimiento,id_producto,tipo,cantidad,fecha);
                lista.add(mov);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return lista;
    }
    
    public boolean insertar(Movimiento m){
        String sql = "INSERT INTO movimientos_stock(id_producto,tipo,cantidad,fecha) VALUES (?, ?, ?,?)";
        String url = "jdbc:sqlite:data/almacen.db";
        
        try(Connection conexion = DriverManager.getConnection(url);
             PreparedStatement ps = conexion.prepareStatement(sql)){
            
            try (Statement stmt = conexion.createStatement()) {
                stmt.execute("PRAGMA foreign_keys = ON");
            }
            
            ps.setInt(1, m.getId_producto());
            ps.setString(2,m.getTipo());
            ps.setInt(3, m.getCantidad());
            ps.setString(4, m.getFecha());
            
            int filas = ps.executeUpdate();
            return filas>0;
            
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
}
