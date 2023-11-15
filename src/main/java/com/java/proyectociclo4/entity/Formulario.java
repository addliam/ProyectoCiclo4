
package com.java.proyectociclo4.entity;

/**
 *
 * @author Daygo
 */
public class Formulario {
    
    private String formulariold;
    private Integer cliented;
    private String slug;
    private String urlWeb;

    @Override
    public String toString() {
        return "Formulario : " + formulariold + 
               "\nCliented : " + cliented + 
               "\nSlug : " + slug + 
               "\nUrlWeb=" + urlWeb + '}';
    }

    public Formulario(String formulariold, Integer cliented, String slug, String urlWeb) {
        this.formulariold = formulariold;
        this.cliented = cliented;
        this.slug = slug;
        this.urlWeb = urlWeb;
    }

    public String getFormulariold() {
        return formulariold;
    }

    public void setFormulariold(String formulariold) {
        this.formulariold = formulariold;
    }

    public Integer getCliented() {
        return cliented;
    }

    public void setCliented(Integer cliented) {
        this.cliented = cliented;
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
