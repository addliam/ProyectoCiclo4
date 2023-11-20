package com.java.proyectociclo4.dao.impl;

/**
 * @author Gherika
 */
import com.java.proyectociclo4.dao.DaoCategoria;
import com.java.proyectociclo4.entity.Categoria;
import com.java.proyectociclo4.entity.Cliente;
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
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM categorias WHERE cliente_id = ?");
        try (Connection con = conexionBaseDatos.connecta()) {
            PreparedStatement ps = con.prepareCall(sql.toString());
            ps.setInt(1, clienteId);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    Categoria categoria = mapResultSetToCategoria(resultSet);
                    categorias.add(categoria);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return categorias;
    }

    @Override
    public List<Categoria> categoriaSelecPorFormulario(Integer formularioId) {
        List<Categoria> categorias = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT c.categoria_id, c.cliente_id, c.nombre, c.activo FROM formulario_categorias fc INNER JOIN categorias c ON fc.categoria_id=c.categoria_id WHERE fc.formulario_id=?");
        try (Connection con = conexionBaseDatos.connecta()) {
            PreparedStatement ps = con.prepareCall(sql.toString());
            ps.setInt(1, formularioId);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    Categoria categoria = mapResultSetToCategoria(resultSet);
                    categorias.add(categoria);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return categorias;
    }

    @Override
    public String categoriaCrear(Categoria categoria) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO categorias (cliente_id, nombre) VALUES (?,?)");
        try (Connection con = conexionBaseDatos.connecta()) {
            PreparedStatement ps = con.prepareCall(sql.toString());
            ps.setInt(1, categoria.getClienteId());
            ps.setString(2, categoria.getNombre());
            int columnas = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }

    @Override
    public Categoria categoriaLeer(String id) {
        Categoria categoria = null;
        //pendiente
        return categoria;
    }

    @Override
    public String categoriaUpdate(Categoria categoria) {
        //pendiente
        return "Categoría actualizada exitosamente";
    }

    @Override
    public String categoriaEliminar(Categoria categoria) {
        //pendiente
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
