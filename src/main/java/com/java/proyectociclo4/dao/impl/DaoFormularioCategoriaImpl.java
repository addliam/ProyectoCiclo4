package com.java.proyectociclo4.dao.impl;

import com.java.proyectociclo4.dao.DaoFormularioCategoria;
import com.java.proyectociclo4.entity.FormularioCategoria;
import com.java.proyectociclo4.util.ConexionBaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Ocxros
 */
public class DaoFormularioCategoriaImpl implements DaoFormularioCategoria {

    private final ConexionBaseDatos conexionBaseDatos;

    public DaoFormularioCategoriaImpl() {
        this.conexionBaseDatos = new ConexionBaseDatos();
    }

    @Override
    public String formularioCategoriaCrear(FormularioCategoria formularioCategoria) {
        FormularioCategoria formularioCategoria1 = null;
        StringBuilder sql = new StringBuilder();

        // Ctrl + Shift + Abajo (atajo duplicar linea)        
        sql.append("INSERT INTO formulario_categorias(")
                .append("formulario_id,")
                .append("categoria_id")
                .append(") VALUES (?,?)");
        System.out.println(sql.toString());
        try (Connection con = conexionBaseDatos.connecta()) {
            PreparedStatement ps = con.prepareCall(sql.toString());
            ps.setInt(1, formularioCategoria.getFormularioId());
            ps.setInt(2, formularioCategoria.getCategoriaId());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    formularioCategoria1 = new FormularioCategoria(rs.getString(1),
                            rs.getInt(2),
                            rs.getInt(3));
                } else {
                    formularioCategoria1 = null;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }

    @Override
    public FormularioCategoria formularioCategoriaLeer(Integer id) {
        FormularioCategoria formCategoria = null;
        StringBuilder sql = new StringBuilder();

        // Ctrl + Shift + Abajo (atajo duplicar linea)        
        sql.append("SELECT ")
                .append("formulario_categoria_id,")
                .append("formulario_id,")
                .append("categoria_id")
                .append(" FROM formulario_categorias WHERE formulario_categoria_id = ?");
        System.out.println(sql.toString());
        try (Connection con = conexionBaseDatos.connecta()) {
            PreparedStatement ps = con.prepareCall(sql.toString());
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    formCategoria = new FormularioCategoria(rs.getString(1),
                            rs.getInt(2),
                            rs.getInt(3));
                } else {
                    formCategoria = null;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return formCategoria;
    }

}
