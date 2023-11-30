
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.java.proyectociclo4.test;

import com.java.proyectociclo4.dao.impl.DaoRespuestaImpl;
import com.java.proyectociclo4.entity.Respuesta;
import java.util.List;

/**
 *
 * @author xfabi
 */
public class TestDaoRespuestaImpl {

    public static void main(String[] args) {
        DaoRespuestaImpl dao = new DaoRespuestaImpl();
        List<Respuesta> respuestas = dao.respuestaSelecPorFormulario(1);
        for (Respuesta respuesta : respuestas) {
            System.out.println(respuesta);
        }
    }
}
