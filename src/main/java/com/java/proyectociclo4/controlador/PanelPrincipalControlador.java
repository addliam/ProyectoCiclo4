/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.proyectociclo4.controlador;

import com.java.proyectociclo4.dao.impl.DaoCategoriaImpl;
import com.java.proyectociclo4.dao.impl.DaoFormularioImpl;
import com.java.proyectociclo4.entity.Categoria;
import com.java.proyectociclo4.entity.Formulario;
import com.java.proyectociclo4.vista.PanelPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        Object[] cols = {"Id", "Direccion", "Url web"};
        //direccion significa slug
        modeloTablaF = new DefaultTableModel(data, cols);
        this.vista.tableFormulario.setModel(modeloTablaF);
        //iniciando tabla categoria
        Object[] cols2 = {"Id", "Nombre"};
        //direccion significa slug
        modeloTablaC = new DefaultTableModel(data, cols2);
        this.vista.tableCategoria.setModel(modeloTablaC);
    }

    public void rellenarTablaFormulario() {
        List<Formulario> formularios = this.modelo2.leerFormularioPorCliente(clienteId);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        //saber que boton se presiono
        JButton btn = (JButton) e.getSource();
        if (btn == this.vista.btnCrearNuevoFormulario) {
            System.out.println("btnCrearNuevoFormulario");
        } else if (btn == this.vista.btnModificarCategorias) {
            System.out.println("btnModificarCategorias");
        }
    }
}
