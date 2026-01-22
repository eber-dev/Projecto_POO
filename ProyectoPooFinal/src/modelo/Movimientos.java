/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author EBER
 */
public class Movimientos {
    private int id_movimiento;
    private int id_producto;
    private String tipo;
    private int cantidad;
    private String fecha;
    
    public Movimientos(int id_movimiento, int id_producto, String tipo,int cantidad, String fecha){
        this.id_movimiento = id_movimiento;
        this.id_producto = id_producto;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }
    
    public Movimientos(int id_producto, String tipo, int cantidad, String fecha){
        this.id_producto = id_producto;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public int getId_movimiento() {
        return id_movimiento;
    }

    public void setId_movimiento(int id_movimiento) {
        this.id_movimiento = id_movimiento;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
