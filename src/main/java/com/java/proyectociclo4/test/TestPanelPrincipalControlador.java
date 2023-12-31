/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.java.proyectociclo4.test;

import com.java.proyectociclo4.controlador.PanelPrincipalControlador;
import com.java.proyectociclo4.dao.impl.DaoCategoriaImpl;
import com.java.proyectociclo4.dao.impl.DaoFormularioCategoriaImpl;
import com.java.proyectociclo4.dao.impl.DaoFormularioImpl;
import com.java.proyectociclo4.vista.PanelPrincipal;

/**
 *
 * @author Ocxros
 */
public class TestPanelPrincipalControlador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PanelPrincipal vista = new PanelPrincipal();
        DaoCategoriaImpl modelo = new DaoCategoriaImpl();
        DaoFormularioImpl modelo2 = new DaoFormularioImpl();
        PanelPrincipalControlador controlador = new PanelPrincipalControlador(modelo, modelo2, vista);
        controlador.start();
    }

}
