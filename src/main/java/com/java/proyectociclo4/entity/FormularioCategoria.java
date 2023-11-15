
package com.java.proyectociclo4.entity;

public class FormularioCategoria {
    private String formularioCategoria;
    private String formularioId;
    private String categoriaId;

    @Override
    public String toString() {
        return "Categoria del Formulario : " + formularioCategoria +
                "\nId Formulario : " + formularioId + 
                "\nId Categoria : " + categoriaId;
    }

    public FormularioCategoria(String formularioCategoria, String formularioId, String categoriaId) {
        this.formularioCategoria = formularioCategoria;
        this.formularioId = formularioId;
        this.categoriaId = categoriaId;
    }

    public String getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(String categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getFormularioCategoria() {
        return formularioCategoria;
    }

    public void setFormularioCategoria(String formularioCategoria) {
        this.formularioCategoria = formularioCategoria;
    }

    public String getFormularioId() {
        return formularioId;
    }

    public void setFormularioId(String formularioId) {
        this.formularioId = formularioId;
    }
    
    
}
