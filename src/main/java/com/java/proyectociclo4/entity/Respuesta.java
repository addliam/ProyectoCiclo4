/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.proyectociclo4.entity;

/**
 *
 * @author xfabi
 */
public class Respuesta {

    private String respuestaId;
    private Integer formularioId;
    private String contenido;
    private Integer categoriaId;
    private String usuarioEmail;

    @Override
    public String toString() {
        return "Respuesta{" + "respuestaId=" + respuestaId + ", formularioId=" + formularioId + ", contenido=" + contenido + ", categoriaId=" + categoriaId + ", usuarioEmail=" + usuarioEmail + '}';
    }

    public Respuesta(String respuestaId, Integer formularioId, String contenido, Integer categoriaId, String usuarioEmail) {
        this.respuestaId = respuestaId;
        this.formularioId = formularioId;
        this.contenido = contenido;
        this.categoriaId = categoriaId;
        this.usuarioEmail = usuarioEmail;
    }

    public String getRespuestaId() {
        return respuestaId;
    }

    public void setRespuestaId(String respuestaId) {
        this.respuestaId = respuestaId;
    }

    public Integer getFormularioId() {
        return formularioId;
    }

    public void setFormularioId(Integer formularioId) {
        this.formularioId = formularioId;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

}
