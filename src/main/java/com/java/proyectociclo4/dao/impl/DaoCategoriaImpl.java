/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.proyectociclo4.dao.impl;

/**
 * @author Gherika
 */

import com.java.proyectociclo4.dao.DaoCategoria;
import com.java.proyectociclo4.entity.Categoria;
import com.java.proyectociclo4.util.ConexionBaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoCategoriaImpl implements DaoCategoria {

   private final ConexionBaseDatos conexionBaseDatos;

    public DaoCategoriaImpl() {
        this.conexionBaseDatos = new ConexionBaseDatos();
    }

    @Override
    public List<Categoria> categoriaSelecPorCliente(Integer clienteId) {
        List<Categoria> categorias = new ArrayList<>();

        try (Connection connection = conexionBaseDatos.connecta();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM categorias WHERE cliente_id = ?");
             ResultSet resultSet = statement.executeQuery()) {

            statement.setInt(1, clienteId);

            while (resultSet.next()) {
                Categoria categoria = mapResultSetToCategoria(resultSet);
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categorias;
    }

    @Override
    public List<Categoria> categoriaSelecPorFormulario(Integer formularioId) {
        // Implementar según tus necesidades
        return new ArrayList<>();
    }

    @Override
    public String categoriaCrear(Categoria categoria) {
        try (Connection connection = conexionBaseDatos.connecta();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO categorias VALUES (?, ?, ?, ?)")) {
            statement.setString(1, categoria.getCategoriaId());
            statement.setInt(2, categoria.getClienteId());
            statement.setString(3, categoria.getNombre());
            statement.setBoolean(4, categoria.getActivo());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al crear la categoría";
        }
        return "Categoría creada exitosamente";
    }

    @Override
    public Categoria categoriaLeer(String id) {
        Categoria categoria = null;

        try (Connection connection = conexionBaseDatos.connecta();
             PreparedStatement statement = connection.prepareStatement("SELECT * "
                     + "FROM categorias WHERE categoria_id = ?");
             ResultSet resultSet = statement.executeQuery()) {

            statement.setString(1, id);

            if (resultSet.next()) {
                categoria = mapResultSetToCategoria(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoria;
    }

    @Override
    public String categoriaUpdate(Categoria categoria) {
        try (Connection connection = conexionBaseDatos.connecta();
             PreparedStatement statement = connection.prepareStatement("UPDATE categorias "
                     + "SET cliente_id = ?, nombre = ?, activo = ? WHERE categoria_id = ?")) {
            statement.setInt(1, categoria.getClienteId());
            statement.setString(2, categoria.getNombre());
            statement.setBoolean(3, categoria.getActivo());
            statement.setString(4, categoria.getCategoriaId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al actualizar la categoría";
        }
        return "Categoría actualizada exitosamente";
    }

    @Override
    public String categoriaEliminar(Categoria categoria) {
        try (Connection connection = conexionBaseDatos.connecta();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM categorias "
                     + "WHERE categoria_id = ?")) {
            statement.setString(1, categoria.getCategoriaId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al eliminar la categoría";
        }

        return "Categoría eliminada exitosamente";
    }

    private Categoria mapResultSetToCategoria(ResultSet resultSet) throws SQLException {
        String categoriaId = resultSet.getString("categoria_id");
        Integer clienteId = resultSet.getInt("cliente_id");
        String nombre = resultSet.getString("nombre");
        Boolean activo = resultSet.getBoolean("activo");

        return new Categoria(categoriaId, clienteId, nombre, activo);
    }
}


