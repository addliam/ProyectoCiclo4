/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.proyectociclo4.controlador;

import com.java.proyectociclo4.dao.impl.DaoCategoriaImpl;
import com.java.proyectociclo4.dao.impl.DaoFormularioCategoriaImpl;
import com.java.proyectociclo4.dao.impl.DaoFormularioImpl;
import com.java.proyectociclo4.dao.impl.DaoRespuestaImpl;
import com.java.proyectociclo4.entity.Categoria;
import com.java.proyectociclo4.entity.Formulario;
import com.java.proyectociclo4.vista.CrearFormulario;
import com.java.proyectociclo4.vista.GestionCategoria;
import com.java.proyectociclo4.vista.PanelPrincipal;
import com.java.proyectociclo4.vista.ReporteErrores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ocxros
 */
public class PanelPrincipalControlador implements ActionListener {
    
    private DaoCategoriaImpl modelo;
    private PanelPrincipal vista;
    private DaoFormularioImpl modelo2;
    private Integer clienteId = 1;
    private DefaultTableModel modeloTablaF;
    private DefaultTableModel modeloTablaC;
    private List<Formulario> formularios;
    
    public Integer getClienteId() {
        return clienteId;
    }
    
    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }
    
    public PanelPrincipalControlador(DaoCategoriaImpl modelo, DaoFormularioImpl modelo2, PanelPrincipal vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.modelo2 = modelo2;
    }
    
    public void start() {
        //mapear funcionalidad del boton
        this.iniciarTablas();
        this.funcionalidadTablaFormulario();
        this.vista.btnCrearNuevoFormulario.addActionListener(this);
        this.vista.btnModificarCategorias.addActionListener(this);
        this.rellenarTablaCategoria();
        this.rellenarTablaFormulario();
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
    
    private void iniciarTablas() {
        //iniciando tabla formularios
        Object[][] data = null;
        Object[][] data2 = null;
        
        Object[] cols = {"Id", "Direccion", "Url web"};
        //direccion significa slug
        modeloTablaF = new DefaultTableModel(data, cols);
        this.vista.tableFormulario.setModel(modeloTablaF);
        //dimensiones
        this.vista.tableFormulario.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.vista.tableFormulario.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.vista.tableFormulario.getColumnModel().getColumn(2).setPreferredWidth(250);
        //iniciando tabla categoria
        Object[] cols2 = {"Id", "Nombre"};
        //direccion significa slug
        modeloTablaC = new DefaultTableModel(data2, cols2);
        this.vista.tableCategoria.setModel(modeloTablaC);
        this.vista.tableCategoria.getColumnModel().getColumn(0).setMinWidth(30);
        this.vista.tableCategoria.getColumnModel().getColumn(0).setMaxWidth(45);
        this.vista.tableCategoria.getColumnModel().getColumn(0).setPreferredWidth(60);
        this.vista.tableCategoria.getColumnModel().getColumn(1).setMinWidth(100);
        this.vista.tableCategoria.getColumnModel().getColumn(1).setMaxWidth(150);
        this.vista.tableCategoria.getColumnModel().getColumn(1).setPreferredWidth(180);
        
    }
    
    public void rellenarTablaFormulario() {
        formularios = this.modelo2.leerFormularioPorCliente(clienteId);
        for (Formulario formulario : formularios) {
            Object[] fila = {formulario.getFormularioId(), formulario.getSlug(), formulario.getUrlWeb()};
            modeloTablaF.addRow(fila);
        }
    }
    
    public void rellenarTablaCategoria() {
        List<Categoria> categorias = this.modelo.categoriaSelecPorCliente(clienteId);
        for (Categoria categoria : categorias) {
            Object[] fila = {categoria.getCategoriaId(), categoria.getNombre()};
            
            modeloTablaC.addRow(fila);
            
        }
        //como reducir el ancho de las colummas java swing

    }
    
    private void funcionalidadTablaFormulario() {
        // Deshabilitar la edición de celdas
        this.vista.tableFormulario.setDefaultEditor(Object.class, null);
        this.vista.tableFormulario.addMouseListener(
                new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e
            ) {
                // Verificar si fue un doble clic (botón izquierdo, doble clic)
                if (e.getClickCount() == 2) {
                    // row empieza en 0
                    int row = vista.tableFormulario.rowAtPoint(e.getPoint());
                    // calcular formularioId
                    Integer formId = Integer.valueOf(formularios.get(row).getFormularioId());
                    mostrarReporteErroresControlador(formId);
                }
            }
        }
        );
    }
    
    private void mostrarReporteErroresControlador(Integer formId) {
        DaoCategoriaImpl daoCategoriaImpl = new DaoCategoriaImpl();
        DaoFormularioImpl daoFormularioImpl = new DaoFormularioImpl();
        DaoRespuestaImpl daoRespuestaImpl = new DaoRespuestaImpl();
        ReporteErrores vistaRE = new ReporteErrores();
        ReporteErroresControlador controladorRE = new ReporteErroresControlador(daoCategoriaImpl, daoFormularioImpl, daoRespuestaImpl, vistaRE);
        // Setear el clienteId para que sepa como retornar
        controladorRE.setClienteId(this.clienteId);
        controladorRE.setFormularioId(formId);
        controladorRE.start();
        this.vista.dispose();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //saber que boton se presiono
        JButton btn = (JButton) e.getSource();
        if (btn == this.vista.btnCrearNuevoFormulario) {
            //crearformularioControlador
            DaoFormularioImpl daoFormularioImpl = new DaoFormularioImpl();
            DaoFormularioCategoriaImpl daoFormularioCategoriaImpl = new DaoFormularioCategoriaImpl();
            DaoCategoriaImpl daoCategoriaImpl = new DaoCategoriaImpl();
            CrearFormulario crearFormulario = new CrearFormulario();
            CrearFormularioControlador controlador = new CrearFormularioControlador(modelo2, daoFormularioCategoriaImpl, modelo, crearFormulario);
            controlador.setClienteId(this.clienteId);
            controlador.start();
            this.vista.dispose();
        } else if (btn == this.vista.btnModificarCategorias) {
            DaoCategoriaImpl daoCategoriaImpl = new DaoCategoriaImpl();
            GestionCategoria gestionCategoria = new GestionCategoria();
            GestionCategoriasControlador controlador = new GestionCategoriasControlador(daoCategoriaImpl, gestionCategoria);
            controlador.setUsuarioId(this.clienteId);
            controlador.start();
            this.vista.dispose();
        }
    }
}
