/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.proyectociclo4.entity;

/**
 *
 * @author xfabi
 */
public class RespuestaCategoria extends Respuesta {

    private String nombre;

    @Override
    public String toString() {
        return super.toString() + "/nRespuestaCategoria{" + "nombre=" + nombre + '}';
    }

    public RespuestaCategoria(String respuestaId, Integer formularioId, String contenido, Integer categoriaId, String usuarioEmail, String nombre) {
        super(respuestaId, formularioId, contenido, categoriaId, usuarioEmail);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
