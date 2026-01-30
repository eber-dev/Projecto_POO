/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.util.List;
import modelo.producto;
import modelo.productoDAO;
import vista.FrmProductos;

/**
 *
 * @author EBER
 */
public class ControladorProducto {
    public static void CargarLaptops(FrmProductos prod){
        productoDAO laptop = new productoDAO();
        List<producto> lap = laptop.listar();  
        prod.agregarItem(lap);
        prod.setVisible(true);
    }

    
}
