/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.java.proyectociclo4.dao;

/**
 * @author Gherika
 */
import com.java.proyectociclo4.entity.Categoria;
import java.util.List;

public interface DaoCategoria {

    public List<Categoria> categoriaSelecPorCliente(Integer clienteId);

    public List<Categoria> categoriaSelecPorFormulario(Integer formularioId);

    public String categoriaCrear(Categoria categoria);

    public Categoria categoriaLeer(String id);

    public String categoriaUpdate(Categoria categoria);

    public String categoriaEliminar(Categoria categoria);
}
