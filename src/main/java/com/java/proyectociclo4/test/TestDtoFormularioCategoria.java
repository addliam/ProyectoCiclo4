package com.java.proyectociclo4.test;

import com.java.proyectociclo4.entity.FormularioCategoria;

public class TestDtoFormularioCategoria {

    public static void main(String[] args) {
        FormularioCategoria fc = new FormularioCategoria("cliente", "10101010", "02");

        System.out.println(fc);
    }

}
