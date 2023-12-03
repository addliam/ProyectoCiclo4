package com.java.proyectociclo4.test;

import com.java.proyectociclo4.dao.impl.DaoCategoriaImpl;
import com.java.proyectociclo4.entity.Categoria;
import java.util.List;

/**
 * @author Gherika
 */
public class TestCategoriaImpl {

    public static void main(String[] args) {
        DaoCategoriaImpl dao = new DaoCategoriaImpl();
        /*List<Categoria> categorias = dao.categoriaSelecPorCliente(1);
        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }

        List<Categoria> categorias2 = dao.categoriaSelecPorFormulario(2);
        for (Categoria categoria : categorias2) {
            System.out.println(categoria);
        }*/

 /*Categoria c1 = new Categoria();
        c1.setNombre("test714");
        c1.setClienteId(1);
        dao.categoriaCrear(c1);
         */
 /*
         */
 /*
        Categoria c1 = new Categoria();
        c1.setNombre("Nombre actualizado");
        c1.setCategoriaId("9");
        dao.categoriaUpdate(c1);
         */
        Categoria c = dao.categoriaLeer("5");
        System.out.println(c);
    }
}
