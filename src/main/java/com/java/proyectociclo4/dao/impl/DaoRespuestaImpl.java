
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.proyectociclo4.dao.impl;

import com.java.proyectociclo4.dao.DaoRespuesta;
import com.java.proyectociclo4.entity.Respuesta;
import com.java.proyectociclo4.util.ConexionBaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xfabi
 */
public class DaoRespuestaImpl implements DaoRespuesta {

    private final ConexionBaseDatos conexionBaseDatos;

    public DaoRespuestaImpl() {
        this.conexionBaseDatos = new ConexionBaseDatos();
    }

    @Override
    public List<Respuesta> respuestaSelecPorFormulario(Integer formularioId) {
        List<Respuesta> respuestas = new ArrayList<>();

        try (Connection connection = conexionBaseDatos.connecta()) {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM respuestas WHERE formulario_id = ?");
            statement.setInt(1, formularioId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Respuesta respuesta = mapResultSetToRespuesta(resultSet);
                respuestas.add(respuesta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return respuestas;
    }

    private Respuesta mapResultSetToRespuesta(ResultSet resultSet) throws SQLException {
        String respuestaId = resultSet.getString("respuesta_id");
        Integer formularioId = resultSet.getInt("formulario_id");
        String contenido = resultSet.getString("contenido");
        Integer categoriaId = resultSet.getInt("categoria_id");
        String usuarioEmail = resultSet.getString("usuario_email");

        return new Respuesta(respuestaId, formularioId, contenido, categoriaId, usuarioEmail);
    }
}
