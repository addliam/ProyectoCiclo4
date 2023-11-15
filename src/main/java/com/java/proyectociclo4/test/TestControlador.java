/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.proyectociclo4.test;

import com.java.proyectociclo4.controlador.InicioSesionControlador;
import com.java.proyectociclo4.dao.impl.DaoClienteImpl;
import com.java.proyectociclo4.vista.InicioSesion;

/**
 *
 * @author liamy
 */
public class TestControlador {

    public static void main(String[] args) {
        InicioSesion vista = new InicioSesion();
        DaoClienteImpl modelo = new DaoClienteImpl();
        InicioSesionControlador c1 = new InicioSesionControlador(vista, modelo);
        c1.start();
    }
}
