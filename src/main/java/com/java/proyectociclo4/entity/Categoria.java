/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.proyectociclo4.entity;

/**
 * @author Gherika
 */
public class Categoria {
    
        //Atributos
    
        private String categoriaId;
        private Integer clienteId;
        private String nombre;
        private Boolean activo;
        
    
    //Constructor
        
    public Categoria(String categoriaId, Integer clienteId, String nombre, Boolean activo) {
        this.categoriaId = categoriaId;
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.activo = activo;
    }
    
    //Getter and Setter
    
    public String getCategoriaId() {
        return categoriaId;
    }
    public void setCategoriaId(String categoriaId) {
        this.categoriaId = categoriaId;
    }
    public Integer getClienteId() {
        return clienteId;
    }
    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Boolean getActivo() {
        return activo;
    }
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
