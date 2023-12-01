/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.proyectociclo4.controlador;

import com.java.proyectociclo4.dao.DaoRespuesta;
import com.java.proyectociclo4.entity.Respuesta;
import com.java.proyectociclo4.vista.ReporteErrores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author xfabi
 */
public class ReporteErroresControlador implements ActionListener {

    private ReporteErrores vista;
    private DaoRespuesta modelo;
    private Integer clienteId = 1;
    private DefaultTableModel modeloTablaValor;
    private DefaultTableModel modeloTablaContenidoCategoriaFecha;
    private DefaultTableModel modelotablaNombre;

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public void star() {
        this.iniciarTabla();
        this.rellenarTabla();
    }

    public void iniciarTabla() {
        //iniciando tabla panel formulario
        Object[][] data = null;

        Object[] cols = {"Item", "Valor"};
        //direccion significa slug
        modeloTablaValor = new DefaultTableModel(data, cols);
        this.vista.tablaItemValor.setModel(modeloTablaValor);
        //iniciando tabla respuestas
        Object[] cols2 = {"Contenido", "Categoria", "Fecha"};
        modeloTablaContenidoCategoriaFecha = new DefaultTableModel(data, cols);
        this.vista.tablaContenidoCategoriaFecha.setModel(modeloTablaContenidoCategoriaFecha);
        //iniciando tabla categoria
        Object[] cols3 = {"Nombre"};
        modelotablaNombre = new DefaultTableModel(data, cols);
        this.vista.tablaNombre.setModel(modelotablaNombre);
    }
//conf

    private void rellenarTabla() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
