package com.java.proyectociclo4.entity;

public class FormularioCategoria {

    private String formularioCategoriaId;
    private Integer formularioId;
    private Integer categoriaId;

    @Override
    public String toString() {
        return "Categoria del Formulario : " + formularioCategoriaId
                + "\nId Formulario : " + formularioId
                + "\nId Categoria : " + categoriaId;
    }

    public FormularioCategoria() {
    }

    public FormularioCategoria(String formularioCategoriaId, Integer formularioId, Integer categoriaId) {
        this.formularioCategoriaId = formularioCategoriaId;
        this.formularioId = formularioId;
        this.categoriaId = categoriaId;
    }

    public String getFormularioCategoriaId() {
        return formularioCategoriaId;
    }

    public void setFormularioCategoriaId(String formularioCategoriaId) {
        this.formularioCategoriaId = formularioCategoriaId;
    }

    public Integer getFormularioId() {
        return formularioId;
    }

    public void setFormularioId(Integer formularioId) {
        this.formularioId = formularioId;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    
    

   

}
