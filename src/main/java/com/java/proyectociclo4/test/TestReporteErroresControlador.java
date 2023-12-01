/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.java.proyectociclo4.test;

import com.java.proyectociclo4.controlador.ReporteErroresControlador;
import com.java.proyectociclo4.dao.DaoFormulario;
import com.java.proyectociclo4.dao.DaoRespuesta;
import com.java.proyectociclo4.dao.impl.DaoCategoriaImpl;
import com.java.proyectociclo4.dao.impl.DaoFormularioImpl;
import com.java.proyectociclo4.dao.impl.DaoRespuestaImpl;
import com.java.proyectociclo4.vista.ReporteErrores;

/**
 *
 * @author xfabi
 */
public class TestReporteErroresControlador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DaoCategoriaImpl daoCategoriaImpl = new DaoCategoriaImpl();
        DaoFormularioImpl daoFormularioImpl = new DaoFormularioImpl();
        DaoRespuestaImpl daoRespuestaImpl = new DaoRespuestaImpl();
        ReporteErrores vista = new ReporteErrores();
        ReporteErroresControlador controlador = new ReporteErroresControlador(daoCategoriaImpl, daoFormularioImpl, daoRespuestaImpl, vista);
        controlador.start();
    }

}
