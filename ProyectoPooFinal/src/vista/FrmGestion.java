/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.ExportarExcel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Movimiento;
import java.awt.Font;
import java.io.IOException;
import javax.swing.JOptionPane;
import modelo.MovimientosDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;
import modelo.producto;
import modelo.productoDAO;
import java.time.LocalDate;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author EBER
 */
public class FrmGestion extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmGestion.class.getName());

    /**
     * Creates new form FrmGestion
     */
    private static List<Movimiento>lista1 = new ArrayList<>();
    private static List<producto>lista2 = new ArrayList<>();
    private static List<Usuario>lista3 = new ArrayList<>();
    private double contador1 = 0;
    private double contador2 = 0;
    DefaultTableModel modelo1,modelo2,modelo3,modelo4;
    producto producto;
    Usuario user;
    Movimiento compra;
    
    public FrmGestion() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        modelo1 = (DefaultTableModel)TablaIngresos.getModel();
        modelo2 = (DefaultTableModel)TablaSalidas.getModel();
        modelo3 = (DefaultTableModel)TablaLista.getModel();
        modelo4 = (DefaultTableModel) TablaUsuarios.getModel();
        TablaIngresos.getTableHeader().setReorderingAllowed(false);
        TablaIngresos.getTableHeader().setResizingAllowed(false);
        TablaIngresos.getTableHeader().setFont(new Font("Arial",Font.PLAIN,16));
        TablaSalidas.getTableHeader().setReorderingAllowed(false);
        TablaSalidas.getTableHeader().setResizingAllowed(false);
        TablaSalidas.getTableHeader().setFont(new Font("Arial",Font.PLAIN,16));
        TablaLista.getTableHeader().setReorderingAllowed(false);
        TablaLista.getTableHeader().setResizingAllowed(false);
        TablaLista.getTableHeader().setFont(new Font("Arial",Font.PLAIN,16));
        TablaUsuarios.getTableHeader().setReorderingAllowed(false);
        TablaUsuarios.getTableHeader().setResizingAllowed(false);
        TablaUsuarios.getTableHeader().setFont(new Font("Arial",Font.PLAIN,16));
        IngresosSalidas();
        lista();
        usuarios();
        limitarspiner();
        indicadores();
    }
    
    public void IngresosSalidas(){
        MovimientosDAO mov = new MovimientosDAO();
        lista1= mov.listar();
        modelo1.setRowCount(0);
        modelo2.setRowCount(0);
        
        for(Movimiento p: lista1){
            if(p.getTipo().equals("ENTRADA")){
                modelo1.addRow(new Object[]{p.getId_movimiento(),p.getId_producto(),p.getTipo(),p.getCantidad(),p.getFecha()});
            }
            if(p.getTipo().equals("SALIDA")){
                modelo2.addRow(new Object[]{p.getId_movimiento(),p.getId_producto(),p.getTipo(),p.getCantidad(),p.getFecha()});
            }
        }
    }
    
    public void lista(){
        productoDAO prod = new productoDAO();
        lista2 = prod.listar();
        modelo3.setRowCount(0);
        
        for(producto p: lista2){
            modelo3.addRow(new Object[]{p.getId(),p.getNombre(),p.getPrecio(),p.getStock(),p.getId_categoria()});
        }
        
        
    }
    
    public void usuarios(){
        UsuarioDAO u = new UsuarioDAO();
        lista3 = u.listar();
        modelo4.setRowCount(0);
        for(Usuario p: lista3){
            modelo4.addRow(new Object[]{p.getId_usuario(),p.getNombre(),p.getApellido(),p.getUsuario(),p.getPassword(),p.getRol()});
        }
    }
    
    public void limitarspiner(){
        SpinnerNumberModel spin1 = new SpinnerNumberModel(1,1,7,1);
        SpinnerNumberModel spin2 = new SpinnerNumberModel(1,1,7,1);
        ActualizarCategoria.setModel(spin1);
        CategoriaNuevo.setModel(spin2);
    }
    
    public void indicadores(){
        productoDAO prod = new productoDAO();
        MovimientosDAO mov = new MovimientosDAO();
        List<Movimiento> reg = mov.listar();
        List<producto> cat = prod.listar();
        for(Movimiento p: reg){
            for(producto c:cat){
                switch(p.getTipo()){
                    case "ENTRADA":
                        if(c.getId()==p.getId_producto()){
                            contador1+=(p.getCantidad()*c.getPrecio());
                        }
                        break;
                    case "SALIDA":
                        if(c.getId()==p.getId_producto()){
                            contador2+=(p.getCantidad()*c.getPrecio());
                        }
                        break;
                }
            }
            MostrarIngresos.setText(String.format("S/ %,.2f", contador1));
            MostrarSalidas.setText(String.format("S/ %,.2f", contador2));
            MostrarGanancia.setText(String.format("S/ %,.2f", contador1-contador2));
            
        }
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel14 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        CerrarSesion = new javax.swing.JButton();
        Multipanel = new javax.swing.JTabbedPane();
        MovimientoVentas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaIngresos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaSalidas = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        Eleccion = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        Exportar = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        MostrarIngresos = new javax.swing.JLabel();
        MostrarSalidas = new javax.swing.JLabel();
        MostrarGanancia = new javax.swing.JLabel();
        StockProductos = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaLista = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        actualizar1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        CampoNombre = new javax.swing.JTextField();
        CampoPrecio = new javax.swing.JTextField();
        CampoStock = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        CategoriaNuevo = new javax.swing.JSpinner();
        AgregarProducto = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        ActualizarProducto = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        EliminarID = new javax.swing.JTextField();
        EliminarProducto = new javax.swing.JButton();
        ActualizarNombre = new javax.swing.JTextField();
        ActualizarPrecio = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        ActualizarCategoria = new javax.swing.JSpinner();
        jLabel33 = new javax.swing.JLabel();
        ActualizarStock = new javax.swing.JTextField();
        RecibirID = new javax.swing.JTextField();
        GestionUsuarios = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaUsuarios = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        actualizar2 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        CampoUsuario = new javax.swing.JTextField();
        EliminarUsuario = new javax.swing.JButton();
        TipoRol = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        CampoContraseña = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        CambiarPrivilegios = new javax.swing.JButton();
        ActualizarContraseña = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel14.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel14.setText("Categoria del producto:");

        jLabel22.setText("jLabel22");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel9.setText("GESTION ADMINISTRATIVA");

        CerrarSesion.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        CerrarSesion.setText("Cerrar Sesion");
        CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionActionPerformed(evt);
            }
        });

        Multipanel.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/icons/ventas (1).png"))); // NOI18N

        TablaIngresos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        TablaIngresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_mov", "ID_prod", "Tipo", "Cantidad", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaIngresos);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel6.setText("Ver Movimientos:");

        TablaSalidas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        TablaSalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_mov", "ID_prod", "Tipo", "Cantidad", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(TablaSalidas);

        jLabel26.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel26.setText("Exportar a Excel:");

        Eleccion.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        Eleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Ingresos", "Salidas" }));

        jLabel25.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel25.setText("Ingresos:");

        jLabel27.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel27.setText("Salidas:");

        Exportar.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        Exportar.setText("Exportar");
        Exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportarActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel28.setText("Ingresos:");

        jLabel35.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel35.setText("Salidas:");

        jLabel36.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel36.setText("Ganancia total");

        MostrarIngresos.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        MostrarSalidas.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        MostrarGanancia.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        javax.swing.GroupLayout MovimientoVentasLayout = new javax.swing.GroupLayout(MovimientoVentas);
        MovimientoVentas.setLayout(MovimientoVentasLayout);
        MovimientoVentasLayout.setHorizontalGroup(
            MovimientoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MovimientoVentasLayout.createSequentialGroup()
                .addGroup(MovimientoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MovimientoVentasLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1))
                    .addGroup(MovimientoVentasLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(MovimientoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addGroup(MovimientoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Eleccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Exportar))
                            .addComponent(jLabel35)
                            .addGroup(MovimientoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(MostrarGanancia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(MostrarSalidas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(MostrarIngresos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(MovimientoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel25))
                .addGap(21, 21, 21))
        );
        MovimientoVentasLayout.setVerticalGroup(
            MovimientoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MovimientoVentasLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(MovimientoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(MovimientoVentasLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(MovimientoVentasLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MostrarIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MostrarSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MostrarGanancia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Eleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Exportar)
                        .addGap(34, 34, 34))))
        );

        Multipanel.addTab("Movimientos de Ventas", MovimientoVentas);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/icons/stock (1).png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel7.setText("Lista de Productos:");

        TablaLista.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        TablaLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Precio", "Stock", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(TablaLista);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel8.setText("Actualizar Producto:");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel10.setText("Añadir Nuevo Producto:");

        actualizar1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        actualizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/icons/productos.png"))); // NOI18N
        actualizar1.setText("Actualizar");
        actualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizar1ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel15.setText("Nombre:");

        jLabel16.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel16.setText("Precio:");

        jLabel17.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel17.setText("Stock:");

        CampoNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        CampoPrecio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        CampoStock.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel18.setText("Categoria:");

        CategoriaNuevo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        AgregarProducto.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        AgregarProducto.setText("Agregar Producto");
        AgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarProductoActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel29.setText("Precio:");

        jLabel30.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel30.setText("Categoria:");

        jLabel32.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel32.setText("Nombre:");

        ActualizarProducto.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        ActualizarProducto.setText("Actualizar Producto");
        ActualizarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarProductoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel11.setText("Eliminar Producto:");

        jLabel34.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel34.setText("ID:");

        EliminarID.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        EliminarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarIDActionPerformed(evt);
            }
        });

        EliminarProducto.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        EliminarProducto.setText("Eliminar");
        EliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarProductoActionPerformed(evt);
            }
        });

        ActualizarNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        ActualizarPrecio.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jLabel31.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel31.setText("Stock:");

        ActualizarCategoria.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel33.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel33.setText("ID:");

        ActualizarStock.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        RecibirID.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        javax.swing.GroupLayout StockProductosLayout = new javax.swing.GroupLayout(StockProductos);
        StockProductos.setLayout(StockProductosLayout);
        StockProductosLayout.setHorizontalGroup(
            StockProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StockProductosLayout.createSequentialGroup()
                .addGroup(StockProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(StockProductosLayout.createSequentialGroup()
                        .addContainerGap(16, Short.MAX_VALUE)
                        .addGroup(StockProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(StockProductosLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(actualizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(StockProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(StockProductosLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel34))))
                    .addGroup(StockProductosLayout.createSequentialGroup()
                        .addGroup(StockProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(StockProductosLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(StockProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8)
                                    .addGroup(StockProductosLayout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addGap(18, 18, 18)
                                        .addComponent(ActualizarPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ActualizarStock, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(StockProductosLayout.createSequentialGroup()
                                        .addComponent(jLabel30)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ActualizarCategoria)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel33)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(RecibirID, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(StockProductosLayout.createSequentialGroup()
                                        .addComponent(jLabel32)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ActualizarNombre))))
                            .addGroup(StockProductosLayout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(ActualizarProducto)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(StockProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StockProductosLayout.createSequentialGroup()
                                .addComponent(AgregarProducto)
                                .addGap(70, 70, 70))
                            .addGroup(StockProductosLayout.createSequentialGroup()
                                .addGroup(StockProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(StockProductosLayout.createSequentialGroup()
                                        .addGroup(StockProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel16))
                                        .addGap(18, 18, 18)
                                        .addGroup(StockProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(CampoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(StockProductosLayout.createSequentialGroup()
                                                .addComponent(CampoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel17)
                                                .addGap(12, 12, 12)
                                                .addComponent(CampoStock, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))))
                                    .addGroup(StockProductosLayout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CategoriaNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(StockProductosLayout.createSequentialGroup()
                                        .addGap(112, 112, 112)
                                        .addComponent(EliminarID, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(EliminarProducto))
                                    .addComponent(jLabel10))
                                .addGap(9, 9, 9)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        StockProductosLayout.setVerticalGroup(
            StockProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StockProductosLayout.createSequentialGroup()
                .addGroup(StockProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(StockProductosLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actualizar1))
                    .addGroup(StockProductosLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(StockProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(EliminarID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(EliminarProducto))))
                .addGroup(StockProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StockProductosLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StockProductosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(StockProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(CampoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(ActualizarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(StockProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(CampoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(CampoStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(ActualizarPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(ActualizarStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(StockProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addGroup(StockProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(CategoriaNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ActualizarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel33)
                        .addComponent(RecibirID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(StockProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AgregarProducto)
                    .addComponent(ActualizarProducto))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        Multipanel.addTab("Gestion de Stock", StockProductos);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/icons/registrados (1).png"))); // NOI18N

        TablaUsuarios.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        TablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido", "Usuario", "Contraseña", "Rol"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TablaUsuarios);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setText("Usuarios Registrados");

        actualizar2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        actualizar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/icons/productos.png"))); // NOI18N
        actualizar2.setText("Actualizar");
        actualizar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizar2ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel21.setText("Ingrese el ID del usuario:");

        jLabel19.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel19.setText("Modificar Privilegios ");

        jLabel20.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel20.setText("Renovar Contraseña");

        CampoUsuario.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        CampoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoUsuarioActionPerformed(evt);
            }
        });

        EliminarUsuario.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        EliminarUsuario.setText("Eliminar Usuario");
        EliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarUsuarioActionPerformed(evt);
            }
        });

        TipoRol.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        TipoRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "USER", "ADMIN" }));
        TipoRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoRolActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel23.setText("Ingrese la nueva contraseña:");

        CampoContraseña.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        CampoContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoContraseñaActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel24.setText("Seleccione el tipo de usuario:");

        CambiarPrivilegios.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        CambiarPrivilegios.setText("Cambiar privilegios");
        CambiarPrivilegios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CambiarPrivilegiosActionPerformed(evt);
            }
        });

        ActualizarContraseña.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        ActualizarContraseña.setText("Actualizar Contraseña");
        ActualizarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarContraseñaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GestionUsuariosLayout = new javax.swing.GroupLayout(GestionUsuarios);
        GestionUsuarios.setLayout(GestionUsuariosLayout);
        GestionUsuariosLayout.setHorizontalGroup(
            GestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionUsuariosLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(GestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(GestionUsuariosLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(GestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(actualizar2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel24)
                            .addComponent(TipoRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CambiarPrivilegios))))
                .addGroup(GestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GestionUsuariosLayout.createSequentialGroup()
                        .addGroup(GestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GestionUsuariosLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(CampoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(GestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)))
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GestionUsuariosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(GestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GestionUsuariosLayout.createSequentialGroup()
                                    .addComponent(EliminarUsuario)
                                    .addGap(101, 101, 101))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GestionUsuariosLayout.createSequentialGroup()
                                    .addComponent(jLabel20)
                                    .addGap(155, 155, 155)))
                            .addGroup(GestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(CampoContraseña, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(ActualizarContraseña)))))
        );
        GestionUsuariosLayout.setVerticalGroup(
            GestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionUsuariosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(GestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(GestionUsuariosLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actualizar2))
                    .addGroup(GestionUsuariosLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(GestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(CampoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EliminarUsuario))
                .addGap(18, 18, 18)
                .addGroup(GestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TipoRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(GestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ActualizarContraseña)
                    .addComponent(CambiarPrivilegios))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        Multipanel.addTab("Usuarios Registrados", GestionUsuarios);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/icons/panel gestion (1).png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addComponent(jLabel9)
                .addGap(126, 126, 126)
                .addComponent(CerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(36, 36, 36))
            .addComponent(Multipanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(CerrarSesion)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGap(12, 12, 12)
                .addComponent(Multipanel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionActionPerformed
        // TODO add your handling code here:
        FrmLogin log = new FrmLogin();
        log.setVisible(true);
        dispose();
    }//GEN-LAST:event_CerrarSesionActionPerformed

    private void CampoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoUsuarioActionPerformed

    private void TipoRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoRolActionPerformed

    private void CampoContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoContraseñaActionPerformed

    private void ExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportarActionPerformed
        // TODO add your handling code here:
        ExportarExcel obj;
        try{
            obj= new ExportarExcel();
            String opcion = Eleccion.getSelectedItem().toString();
            switch(opcion){
                case "Ingresos":
                    obj.exportarExcel(TablaIngresos);
                    break;
                case "Salidas":
                    obj.exportarExcel(TablaSalidas);
                    break;
            }
        }catch(IOException e){
            System.out.println("Error: "+ e);
        }
    }//GEN-LAST:event_ExportarActionPerformed

    private void AgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarProductoActionPerformed
        // TODO add your handling code here:
        MovimientosDAO mov = new MovimientosDAO();
        productoDAO p = new productoDAO();
        LocalDate fecha_actual =LocalDate.now();
        String fecha = fecha_actual.toString();
        String nombre = CampoNombre.getText();
        double precio = Double.parseDouble(CampoPrecio.getText());
        int stock = Integer.parseInt(CampoStock.getText());
        int nuevo = (Integer) CategoriaNuevo.getValue();
        
        producto = new producto(nombre,precio,stock,nuevo);
        if(p.insertar(producto)){
            JOptionPane.showMessageDialog(this, "Se añadio el producto correctamente");
            List<producto> total = p.listar();
            for(producto m: total){
                if(nombre.equals(m.getNombre())){
                    compra = new Movimiento(m.getId(),"SALIDA",stock,fecha);
                }
            }
            mov.insertar(compra);
        }else{
            JOptionPane.showMessageDialog(this, "No se pudo añadir el producto");
        }

    }//GEN-LAST:event_AgregarProductoActionPerformed

    private void EliminarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EliminarIDActionPerformed

    private void ActualizarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarProductoActionPerformed
        // TODO add your handling code here:
        productoDAO p = new productoDAO();
        String nombre = ActualizarNombre.getText();
        double precio = Double.parseDouble(ActualizarPrecio.getText());
        int stock = Integer.parseInt(ActualizarStock.getText());
        int nuevo = (Integer) ActualizarCategoria.getValue();
        int id = Integer.parseInt(RecibirID.getText());
        
        producto = new producto(id,nombre,precio,stock,nuevo);
        if(p.actualizar(producto)){
            JOptionPane.showMessageDialog(this, "Se actualizaron los valores del producto");
        }else{
            JOptionPane.showMessageDialog(this, "Hubo un error al ejecutar los cambios");
        }
    }//GEN-LAST:event_ActualizarProductoActionPerformed

    private void EliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarProductoActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(EliminarID.getText());
        productoDAO p = new productoDAO();
        if(p.eliminar(id)){
            JOptionPane.showMessageDialog(this, "El producto fue eliminado correctamente");
        }else{
            JOptionPane.showMessageDialog(this, "No se pudo eliminar el producto");
        }
    }//GEN-LAST:event_EliminarProductoActionPerformed

    private void actualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizar1ActionPerformed
        // TODO add your handling code here:
        lista();
    }//GEN-LAST:event_actualizar1ActionPerformed

    private void EliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarUsuarioActionPerformed
        // TODO add your handling code here:
        UsuarioDAO u = new UsuarioDAO();
        int id_usuario = Integer.parseInt(CampoUsuario.getText());
        if(u.eliminar(id_usuario)){
            JOptionPane.showMessageDialog(this, "Credenciales eliminadas correctamente");
        }else{
            JOptionPane.showMessageDialog(this, "Hubo un error al eliminar las credenciales");
        }
    }//GEN-LAST:event_EliminarUsuarioActionPerformed

    private void CambiarPrivilegiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CambiarPrivilegiosActionPerformed
        // TODO add your handling code here:
        UsuarioDAO u = new UsuarioDAO();
        int id_usuario = Integer.parseInt(CampoUsuario.getText());
        String privilegio = TipoRol.getSelectedItem().toString();
        
        user = new Usuario(id_usuario,privilegio);
        if(u.actualizarprivilegios(user)){
            JOptionPane.showMessageDialog(this, "Se modificaron los privilegios del usuario con ID" + id_usuario);
        }else{
            JOptionPane.showMessageDialog(this, "No se pudieron modificar los privilegios");
        }
        
    }//GEN-LAST:event_CambiarPrivilegiosActionPerformed

    private void ActualizarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarContraseñaActionPerformed
        // TODO add your handling code here:
        UsuarioDAO u = new UsuarioDAO();
        String clave = CampoContraseña.getText();
        int id_usuario = Integer.parseInt(CampoUsuario.getText());
        user = new Usuario(clave,id_usuario);
        if(u.actualizarpassword(user)){
            JOptionPane.showMessageDialog(this, "La contraseña se actualizo correctamente");
        }else{
            JOptionPane.showMessageDialog(this, "No se pudo actualizar la contraseña");
        }
    }//GEN-LAST:event_ActualizarContraseñaActionPerformed

    private void actualizar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizar2ActionPerformed
        // TODO add your handling code here:
        usuarios();
    }//GEN-LAST:event_actualizar2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrmGestion().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner ActualizarCategoria;
    private javax.swing.JButton ActualizarContraseña;
    private javax.swing.JTextField ActualizarNombre;
    private javax.swing.JTextField ActualizarPrecio;
    private javax.swing.JButton ActualizarProducto;
    private javax.swing.JTextField ActualizarStock;
    private javax.swing.JButton AgregarProducto;
    private javax.swing.JButton CambiarPrivilegios;
    private javax.swing.JTextField CampoContraseña;
    private javax.swing.JTextField CampoNombre;
    private javax.swing.JTextField CampoPrecio;
    private javax.swing.JTextField CampoStock;
    private javax.swing.JTextField CampoUsuario;
    private javax.swing.JSpinner CategoriaNuevo;
    private javax.swing.JButton CerrarSesion;
    private javax.swing.JComboBox<String> Eleccion;
    private javax.swing.JTextField EliminarID;
    private javax.swing.JButton EliminarProducto;
    private javax.swing.JButton EliminarUsuario;
    private javax.swing.JButton Exportar;
    private javax.swing.JPanel GestionUsuarios;
    private javax.swing.JLabel MostrarGanancia;
    private javax.swing.JLabel MostrarIngresos;
    private javax.swing.JLabel MostrarSalidas;
    private javax.swing.JPanel MovimientoVentas;
    private javax.swing.JTabbedPane Multipanel;
    private javax.swing.JTextField RecibirID;
    private javax.swing.JPanel StockProductos;
    private javax.swing.JTable TablaIngresos;
    private javax.swing.JTable TablaLista;
    private javax.swing.JTable TablaSalidas;
    private javax.swing.JTable TablaUsuarios;
    private javax.swing.JComboBox<String> TipoRol;
    private javax.swing.JButton actualizar1;
    private javax.swing.JButton actualizar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
