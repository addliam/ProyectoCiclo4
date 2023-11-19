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
        //FormularioCategoria fmc = daoFormularioCategoriaImpl.formularioCategoriaLeer(3);
        //System.out.println(fmc);
        FormularioCategoria fc1 = new FormularioCategoria();
        fc1.setCategoriaId(4);
        fc1.setFormularioId(1);
        String menForm = daoFormularioCategoriaImpl.formularioCategoriaCrear(fc1);

    }

}
