/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.proyectociclo4.controlador;

import com.java.proyectociclo4.dao.DaoRespuesta;
import com.java.proyectociclo4.dao.impl.DaoCategoriaImpl;
import com.java.proyectociclo4.dao.impl.DaoFormularioImpl;
import com.java.proyectociclo4.dao.impl.DaoRespuestaImpl;
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
    private DaoCategoriaImpl daoCategoriaImpl;
    private DaoFormularioImpl daoFormularioImpl;
    private DaoRespuestaImpl daoRespuestaImpl;
    private Integer clienteId = 1;
    private DefaultTableModel modeloTablaValor;
    private DefaultTableModel modeloTablaContenidoCategoriaFecha;
    private DefaultTableModel modeloTablaCategorias;

    public ReporteErroresControlador(DaoCategoriaImpl daoCategoriaImpl, DaoFormularioImpl daoFormularioImpl, DaoRespuestaImpl daoRespuestaImpl, ReporteErrores vista) {
        this.daoCategoriaImpl = daoCategoriaImpl;
        this.daoFormularioImpl = daoFormularioImpl;
        this.daoRespuestaImpl = daoRespuestaImpl;
        this.vista = vista;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public void start() {
        this.iniciarTabla();
        this.rellenarTabla();
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
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
        Object[] cols3 = {"Id", "Nombre"};
        modeloTablaCategorias = new DefaultTableModel(data, cols);
        this.vista.tablaCategorias.setModel(modeloTablaCategorias);
    }
//conf

    private void rellenarTabla() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
