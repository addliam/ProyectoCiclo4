/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.proyectociclo4.controlador;

import com.java.proyectociclo4.dao.DaoRespuesta;
import com.java.proyectociclo4.dao.impl.DaoCategoriaImpl;
import com.java.proyectociclo4.dao.impl.DaoFormularioImpl;
import com.java.proyectociclo4.dao.impl.DaoRespuestaImpl;
import com.java.proyectociclo4.entity.Categoria;
import com.java.proyectociclo4.entity.Formulario;
import com.java.proyectociclo4.entity.Respuesta;
import com.java.proyectociclo4.entity.RespuestaCategoria;
import com.java.proyectociclo4.vista.ReporteErrores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
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
    private Integer formularioId = 1;
    private DefaultTableModel modeloTablaFormulario;
    private DefaultTableModel modeloTablaRespuestas;
    private DefaultTableModel modeloTablaCategorias;

    public ReporteErroresControlador(DaoCategoriaImpl daoCategoriaImpl, DaoFormularioImpl daoFormularioImpl, DaoRespuestaImpl daoRespuestaImpl, ReporteErrores vista) {
        this.daoCategoriaImpl = daoCategoriaImpl;
        this.daoFormularioImpl = daoFormularioImpl;
        this.daoRespuestaImpl = daoRespuestaImpl;
        this.vista = vista;
    }

    public void start() {
        this.iniciarTabla();
        this.rellenarTablaCategoria();
        this.rellenarTablaInformacionFormulario();
        this.rellenarTablaRespuestas();
        //mostrarvista
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }

    public void iniciarTabla() {
        //iniciando tabla panel formulario
        Object[][] data = null;

        Object[] cols = {"Item", "Valor"};
        //direccion significa slug
        modeloTablaFormulario = new DefaultTableModel(data, cols);
        this.vista.tablaFormulario.setModel(modeloTablaFormulario);
        //iniciando tabla respuestas
        Object[] cols2 = {"Id", "Contenido", "Categoria", "Email"};
        modeloTablaRespuestas = new DefaultTableModel(data, cols2);
        this.vista.tablaRespuestas.setModel(modeloTablaRespuestas);
        //iniciando tabla categoria
        Object[] cols3 = {"Id", "Nombre"};
        modeloTablaCategorias = new DefaultTableModel(data, cols3);
        this.vista.tablaCategorias.setModel(modeloTablaCategorias);
    }

    private void rellenarTablaCategoria() {
        List<Categoria> categorias = daoCategoriaImpl.categoriaSelecPorFormulario(formularioId);
        for (Categoria categoria : categorias) {
            Object[] fila = {categoria.getCategoriaId(), categoria.getNombre()};
            modeloTablaCategorias.addRow(fila);
        }
    }

    public void rellenarTablaInformacionFormulario() {
        Formulario formulario = daoFormularioImpl.leerFormulario(formularioId);
        Object[] fila = {"Id", formulario.getFormularioId()};
        Object[] fila2 = {"Slug", formulario.getSlug()};
        Object[] fila3 = {"URL Web", formulario.getUrlWeb()};
        modeloTablaFormulario.addRow(fila);
        modeloTablaFormulario.addRow(fila2);
        modeloTablaFormulario.addRow(fila3);

    }

    public void rellenarTablaRespuestas() {
        List<RespuestaCategoria> respuestas = daoRespuestaImpl.respuestaCategoriaSelecPorFormulario(formularioId);
        for (RespuestaCategoria respuesta : respuestas) {
            Object[] fila = {respuesta.getRespuestaId(), respuesta.getContenido(), respuesta.getNombre(), respuesta.getUsuarioEmail()};
            modeloTablaRespuestas.addRow(fila);
            System.out.println(fila);

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Integer getFormularioId() {
        return formularioId;
    }

    public void setFormularioId(Integer formularioId) {
        this.formularioId = formularioId;
    }

}