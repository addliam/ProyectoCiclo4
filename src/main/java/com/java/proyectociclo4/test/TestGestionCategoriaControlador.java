/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.proyectociclo4.test;

import com.java.proyectociclo4.controlador.GestionCategoriasControlador;
import com.java.proyectociclo4.dao.impl.DaoCategoriaImpl;
import com.java.proyectociclo4.vista.GestionCategoria;

/**
 *
 * @author Yobana
 */
public class TestGestionCategoriaControlador {

    public static void main(String[] args) {

        DaoCategoriaImpl modelo = new DaoCategoriaImpl();
        GestionCategoria vista = new GestionCategoria();
        GestionCategoriasControlador controlador = new GestionCategoriasControlador(modelo, vista);
        controlador.start();

    }
}
