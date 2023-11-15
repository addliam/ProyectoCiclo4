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

    private String respuestaid;
    private String usuarioEmail;
    private Integer formularioId;
    private String contenido;
    private Integer categoriaId;

    public Respuesta(String Respuestaid, String usuarioEmail, Integer formularioId, String contenido, Integer categoriaId) {
        this.respuestaid = Respuestaid;
        this.usuarioEmail = usuarioEmail;
        this.formularioId = formularioId;
        this.contenido = contenido;
        this.categoriaId = categoriaId;
    }

    @Override
    public String toString() {
        return "respuestaid:" + respuestaid + "\nusuarioEmail:" + usuarioEmail + "\nformularioId:" + formularioId
                + "\ncontenido:" + contenido + "\ncategoriaId:" + categoriaId;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getRespuestaid() {
        return respuestaid;
    }

    public void setRespuestaid(String Respuestaid) {
        this.respuestaid = Respuestaid;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
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

}
