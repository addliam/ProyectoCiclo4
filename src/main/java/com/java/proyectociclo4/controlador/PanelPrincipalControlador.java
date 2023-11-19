/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.proyectociclo4.controlador;

import com.java.proyectociclo4.dao.impl.DaoFormularioCategoriaImpl;
import com.java.proyectociclo4.vista.PanelPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author ocxros
 */
public class PanelPrincipalControlador implements ActionListener {

    private DaoFormularioCategoriaImpl modelo;
    private PanelPrincipal vista;

    public PanelPrincipalControlador(DaoFormularioCategoriaImpl modelo, PanelPrincipal vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void start() {
        //mapear funcionalidad del boton
        this.vista.btnCrearNuevoFormulario.addActionListener(this);
        this.vista.btnModificarCategorias.addActionListener(this);
        //llamando metodos
        this.rellenarTablaCategoria();
        this.rellenarTablaFormulario();
        //mostrar el formulario
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }

    public void rellenarTablaFormulario() {
        //pendiente 

    }

    public void rellenarTablaCategoria() {

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
