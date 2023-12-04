package com.java.proyectociclo4.dao.impl;

import com.java.proyectociclo4.dao.DaoFormulario;
import com.java.proyectociclo4.entity.Formulario;
import com.java.proyectociclo4.util.ConexionBaseDatos;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Daygo
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
                .append("cliente_id,")
                .append("slug,")
                .append("url_web")
                .append(") VALUES (?,?,?)");

        try (Connection con = conexionBaseDatos.connecta()) {
            PreparedStatement ps = con.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
            ps.setInt   (1, formulario.getClienteId());
            ps.setString(2, formulario.getSlug());
            ps.setString(3, formulario.getUrlWeb());
            int affectedRows = ps.executeUpdate();
            
            if (affectedRows == 0) {
                throw new SQLException("La inserción falló, ningún registro afectado.");
                
            }
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    formulario.setFormularioId(String.valueOf(id));
                } else {
                    throw new SQLException("La inserción falló, no se pudo obtener el ID generado.");
                }
            }
                   //Falla obtencion de ID
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return formulario;
    }

    @Override
    
     public  Formulario leerFormulario(Integer id) {
        Formulario form = null;
        StringBuilder sql = new StringBuilder();

        // Ctrl + Shift + Abajo (atajo duplicar linea)        
        sql.append("SELECT ")
                .append("formulario_id,")
                .append("cliente_id,")
                .append("slug,")
                .append("url_web")
                .append(" FROM formularios WHERE formulario_id = ?");

        try (Connection con = conexionBaseDatos.connecta()) {
            PreparedStatement ps = con.prepareCall(sql.toString());
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    form = new Formulario(
                            rs.getInt   (2),
                            rs.getString(3),
                            rs.getString(4));
                    form.setFormularioId(rs.getString(1));
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

         try (Connection connection = conexionBaseDatos.connecta();
             ) {
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM formularios WHERE cliente_id = ?");
             statement.setInt(1, clienteId);
             ResultSet resultSet = statement.executeQuery();
                       
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
        String urlWeb = resultSet.getString("url_web");
        
        Formulario form = new Formulario(clienteId, slug, urlWeb);
        form.setFormularioId(formularioId);
        return form;
}}
