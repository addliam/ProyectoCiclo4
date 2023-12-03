/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.proyectociclo4.controlador;

/**
 * @author Gherika
 */
import com.java.proyectociclo4.dao.impl.DaoCategoriaImpl;
import com.java.proyectociclo4.dao.impl.DaoFormularioImpl;
import com.java.proyectociclo4.entity.Categoria;
import com.java.proyectociclo4.vista.EditarCategoria;
import com.java.proyectociclo4.vista.GestionCategoria;
import com.java.proyectociclo4.vista.PanelPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestionCategoriasControlador implements ActionListener {

    private DaoCategoriaImpl modelo;
    private GestionCategoria vista;
    private Integer usuarioId = 1;
    private DefaultTableModel modeloTabla;
    List<Categoria> categorias;

    public GestionCategoriasControlador(DaoCategoriaImpl modelo, GestionCategoria vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void start() {
        //mapear funcionalidad del boton
        this.vista.btnCrearNuevaCategoria.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        System.out.println("Iniciando");
        //llamando metodos
        this.iniciarTabla();
        this.rellenarTablaCategoria();
        //mostrar el formulario
        funcionalidadTablaCategoria();
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }

    private void iniciarTabla() {
        Object[][] data = null;
        Object[] cols = {"ID", "Nombre", "Editar", "Eliminar"};
        this.vista.tablaCategorias.setDefaultEditor(Object.class, null);
        modeloTabla = new DefaultTableModel(data, cols);
        this.vista.tablaCategorias.setModel(modeloTabla);
    }

    public void rellenarTablaCategoria() {
        modeloTabla.setRowCount(0);
        categorias = this.modelo.categoriaSelecPorCliente(usuarioId);
        for (Categoria categoria : categorias) {
            Object[] fila = {categoria.getCategoriaId(), categoria.getNombre(), "Editar", "Eliminar"};
            // Object[] fila = {categoria.getCategoriaId(), categoria.getNombre()};
            modeloTabla.addRow(fila);
        }
    }

    private void funcionalidadTablaCategoria() {
        // Deshabilitar la edición de celdas

        this.vista.tablaCategorias.addMouseListener(
                new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e
            ) {
                // Verificar si fue un doble clic (botón izquierdo, doble clic)
                if (e.getClickCount() == 2) {
                    // row empieza en 0
                    int row = vista.tablaCategorias.rowAtPoint(e.getPoint());
                    int column = vista.tablaCategorias.columnAtPoint(e.getPoint());
                    Integer categoriaId = Integer.valueOf(categorias.get(row).getCategoriaId());
                    System.out.println(categoriaId);
                    if (column == 2) {
                        //opcion de editar
                        EditarCategoria editarCategoriaFrame = new EditarCategoria();
                        editarCategoriaFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                        editarCategoriaFrame.setCategoriaId(categoriaId);
                        editarCategoriaFrame.start();
                        editarCategoriaFrame.setLocationRelativeTo(null);
                        editarCategoriaFrame.setVisible(true);
                    }
                    if (column == 3) {
                        //Opcion de eliminar
                        String nombreCategoria = categorias.get(row).getNombre();
                        String mensaje = "¿Estas seguro de eliminar esta categoria " + nombreCategoria + " ?";
                        int reply = JOptionPane.showConfirmDialog(null, mensaje, "Confirmacion", JOptionPane.YES_NO_OPTION);

                        if (reply == JOptionPane.YES_OPTION) {
                            eliminarCategoria(categoriaId);
                            JOptionPane.showMessageDialog(null, "Se elimino la categoria correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "Cancelaste la eliminacion");
                        }

                    }
                }
            }
        }
        );
    }

    private void eliminarCategoria(Integer categoriaId) {
        Categoria c1 = new Categoria();
        c1.setCategoriaId(String.valueOf(categoriaId));
        modelo.categoriaEliminar(c1);

    }

    private void clickBtnCrearNuevaCategoria() {
        String nuevoNombre = this.vista.txtCategoriaNombre.getText();
        System.out.println(nuevoNombre);
        Categoria c1 = new Categoria();
        c1.setNombre(nuevoNombre);
        c1.setClienteId(usuarioId);
        modelo.categoriaCrear(c1);
        System.out.println(c1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Saber qué botón se presionó
        JButton btn = (JButton) e.getSource();
        if (btn == this.vista.btnCrearNuevaCategoria) {
            clickBtnCrearNuevaCategoria();
            // Lógica para el botón de crear nueva categoría
        }
        if (btn == this.vista.btnActualizar) {
            rellenarTablaCategoria();
        }
        if (btn == this.vista.btnAtras) {
            PanelPrincipal vista1 = new PanelPrincipal();
            DaoCategoriaImpl modelo1 = new DaoCategoriaImpl();
            DaoFormularioImpl modelo2 = new DaoFormularioImpl();
            PanelPrincipalControlador controlador = new PanelPrincipalControlador(modelo1, modelo2, vista1);
            // Establecer variable requerida (clienteId)
            controlador.setClienteId(this.usuarioId);
            // iniciar y mostrar nuevo frame
            controlador.start();
            // ocultar frame actual
            this.vista.dispose();
        }

    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
}
