/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.java.proyectociclo4.test;

import com.java.proyectociclo4.dao.impl.DaoFormularioImpl;
import com.java.proyectociclo4.entity.Formulario;
import java.util.List;

/**
 *
 * @author Daygo
 */
public class TestDaoFormularioImpl {


    public static void main(String[] args) {
        //leer formulario
        DaoFormularioImpl daoFormularioImpl = new DaoFormularioImpl();
        Formulario fm = daoFormularioImpl.leerFormulario(2);
        
        //crear formulario
        Formulario fm1 = new Formulario( 1, "11bf5b37-e0b8-42e0-8dcf-dc8c4aefc003", "http://google.com");
        Formulario authFormulario = daoFormularioImpl.crearFormulario(fm1);
        
        //leer formulario por cliente
        DaoFormularioImpl daoFormImpl = new DaoFormularioImpl();       
        Integer clienteId = 1;
        List<Formulario> formularios = daoFormImpl.leerFormularioPorCliente(clienteId);
        for (Formulario formulario : formularios) {
            System.out.println(formulario);
        }
    }
    }


    

