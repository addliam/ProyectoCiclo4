package com.java.proyectociclo4.test;

import com.java.proyectociclo4.dao.impl.DaoFormularioCategoriaImpl;
import com.java.proyectociclo4.entity.FormularioCategoria;

/**
 *
 * @author Ocxros
 */
public class TestDaoFormularioCategoriaImpl {

    public static void main(String[] args) {
        DaoFormularioCategoriaImpl daoFormularioCategoriaImpl = new DaoFormularioCategoriaImpl();
        //daoFormularioCategoriaImpl.formularioCategoriaLeer("1");
        FormularioCategoria fmc = daoFormularioCategoriaImpl.formularioCategoriaLeer(2);
        FormularioCategoria authFormularioCategoria = daoFormularioCategoriaImpl.formularioCategoriaCrear("formularioCategoria");
        System.out.println(authFormularioCategoria);
    }

}
