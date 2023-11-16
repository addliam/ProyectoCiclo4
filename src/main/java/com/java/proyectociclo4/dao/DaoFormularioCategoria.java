package com.java.proyectociclo4.dao;

import com.java.proyectociclo4.entity.FormularioCategoria;

/**
 *
 * @author Ocxros
 */
public interface DaoFormularioCategoria {

    public String formularioCategoriaCrear(FormularioCategoria formularioCategoria);

    public FormularioCategoria formularioCategoriaLeer(Integer id);
}
