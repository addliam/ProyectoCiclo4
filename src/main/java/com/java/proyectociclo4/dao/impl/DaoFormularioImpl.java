package com.java.proyectociclo4.dao.impl;

import com.java.proyectociclo4.dao.DaoFormulario;
import com.java.proyectociclo4.entity.Categoria;
import com.java.proyectociclo4.entity.Formulario;
import com.java.proyectociclo4.util.ConexionBaseDatos;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gaygo
 */
public class DaoFormularioImpl implements DaoFormulario {

    private final ConexionBaseDatos conexionBaseDatos;

    public DaoFormularioImpl() {
        this.conexionBaseDatos = new ConexionBaseDatos();
    }

    @Override
    public Formulario crearFormulario(Formulario formulario) {
        Formulario formulario1 = null;
        StringBuilder sql = new StringBuilder();

        // Ctrl + Shift + Abajo (atajo duplicar linea)        
        sql.append("INSERT INTO formularios( ")
                .append("formulario_id,")
                .append("cliente_id,")
                .append("slug,")
                .append("url_web")
                .append(") VALUES (?,?,?,?)");

        try (Connection con = conexionBaseDatos.connecta()) {
            PreparedStatement ps = con.prepareCall(sql.toString());
            ps.setString(1, formulario.getFormularioId());
            ps.setInt(2, formulario.getClienteId());
            ps.setString(3, formulario.getSlug());
            ps.setString(4, formulario.getUrlWeb());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    formulario = new Formulario(rs.getString(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getString(4));
                } else {
                    formulario = null;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return formulario;
    }

    @Override

    public Formulario leerFormulario(Integer id) {
        Formulario form = null;
        StringBuilder sql = new StringBuilder();

        // Ctrl + Shift + Abajo (atajo duplicar linea)        
        sql.append("SELECT ")
                .append("formulario_id,")
                .append("cliente_id,")
                .append("slug,")
                .append("url_web,")
                .append(" FROM formularios WHERE formulario_id = ?");

        try (Connection con = conexionBaseDatos.connecta()) {
            PreparedStatement ps = con.prepareCall(sql.toString());
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    form = new Formulario(rs.getString(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getString(4));
                } else {
                    form = null;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return form;
    }

    @Override
    public List<Formulario> leerFormularioPorCliente(Integer clienteId) {
        List<Formulario> formularios = new ArrayList<>();

        try (Connection connection = conexionBaseDatos.connecta(); PreparedStatement statement = connection.prepareStatement("SELECT * FROM formularios WHERE cliente_id = ?"); ResultSet resultSet = statement.executeQuery()) {

            statement.setInt(1, clienteId);

            while (resultSet.next()) {
                Formulario formulario = mapResultSetToFormulario(resultSet);
                formularios.add(formulario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return formularios;
    }

    private Formulario mapResultSetToFormulario(ResultSet resultSet) throws SQLException {
        String formularioId = resultSet.getString("formulario_id");
        Integer clienteId = resultSet.getInt("cliente_id");
        String slug = resultSet.getString("slug");
        String urlWeb = resultSet.getNString("url_web");

        return new Formulario(formularioId, clienteId, slug, urlWeb);
    }
}
