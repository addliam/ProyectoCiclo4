/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.java.proyectociclo4.test;

import com.java.proyectociclo4.controlador.CrearFormularioControlador;
import com.java.proyectociclo4.dao.impl.DaoCategoriaImpl;
import com.java.proyectociclo4.dao.impl.DaoFormularioCategoriaImpl;
import com.java.proyectociclo4.dao.impl.DaoFormularioImpl;
import com.java.proyectociclo4.vista.CrearFormulario;

/**
 *
 * @author Daygo
 */
public class TestCrearFormularioControlador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        DaoFormularioImpl modelo = new DaoFormularioImpl();
        DaoFormularioCategoriaImpl modelo2 = new DaoFormularioCategoriaImpl();
        DaoCategoriaImpl modelo3 = new DaoCategoriaImpl();
        CrearFormulario vista = new CrearFormulario();
        //public CrearFormularioControlador(DaoFormularioImpl modelo,
        //DaoFormularioCategoriaImpl modelo2,DaoCategoriaImpl modelo3, CrearFormulario vista) {
        CrearFormularioControlador controlador = new CrearFormularioControlador(modelo, modelo2, modelo3, vista);
        controlador.start();
    }
    
}
