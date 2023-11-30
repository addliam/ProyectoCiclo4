/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.proyectociclo4.dao;

import com.java.proyectociclo4.entity.Respuesta;
import com.java.proyectociclo4.entity.RespuestaCategoria;
import java.util.List;

/**
 *
 * @author xfabi
 */
public interface DaoRespuesta {

    public List<Respuesta> respuestaSelecPorFormulario(Integer formularioId);

    public List<RespuestaCategoria> respuestaCategoriaSelecPorFormulario(Integer formularioId);
}
