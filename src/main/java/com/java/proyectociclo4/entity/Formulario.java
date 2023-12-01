package com.java.proyectociclo4.entity;

import java.util.UUID;

/**
 *
 * @author Daygo
 */
public class Formulario {

    private String formularioId;
    private Integer clienteId;
    private String slug=this.generarUuid();
    private String urlWeb;

    @Override
    public String toString() {
        return "FormularioID : " + formularioId
                + "\nCliented : " + clienteId
                + "\nSlug : " + slug
                + "\nUrlWeb=" + urlWeb + '}';
    }

    public Formulario(String formularioId, Integer cliented, String slug, String urlWeb) {
        this.formularioId = formularioId;
        this.clienteId = cliented;
        this.slug = slug;
        this.urlWeb = urlWeb;
    }
    
    public Formulario(Integer cliented, String slug, String urlWeb) {
        this.clienteId = cliented;
        this.slug = slug;
        this.urlWeb = urlWeb;
    }

    public Formulario(Integer clienteId, String urlWeb) {
        this.clienteId = clienteId;
        this.urlWeb = urlWeb;
    }
        
    private String generarUuid(){
        final String uuid = UUID.randomUUID().toString();
        return uuid;
        
    }
    public String getFormularioId() {
        return formularioId;
    }
 

    public void setFormularioId(String formularioId) {
        this.formularioId = formularioId;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getUrlWeb() {
        return urlWeb;
    }

    public void setUrlWeb(String urlWeb) {
        this.urlWeb = urlWeb;
    }

}
