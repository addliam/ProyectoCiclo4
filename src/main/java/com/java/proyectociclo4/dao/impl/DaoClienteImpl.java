package com.java.proyectociclo4.dao.impl;

import com.java.proyectociclo4.dao.DaoCliente;
import com.java.proyectociclo4.entity.Cliente;
import com.java.proyectociclo4.util.ConexionBaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author liamy
 */

/*
 Recursos
 https://javajhon.blogspot.com/2019/10/dao.html
 */
public class DaoClienteImpl implements DaoCliente {

    private final ConexionBaseDatos conexionBaseDatos;

    public DaoClienteImpl() {
        this.conexionBaseDatos = new ConexionBaseDatos();
    }

    @Override
    public Cliente clienteLeer(Integer id) {
        Cliente cliente = null;
        StringBuilder sql = new StringBuilder();

        // Ctrl + Shift + Abajo (atajo duplicar linea)        
        sql.append("SELECT ")
                .append("cliente_id,")
                .append("email,")
                .append("usuario,")
                .append("password")
                .append(" FROM clientes WHERE cliente_id = ?");

        try (Connection con = conexionBaseDatos.connecta()) {
            PreparedStatement ps = con.prepareCall(sql.toString());
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cliente = new Cliente(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4));
                } else {
                    cliente = null;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return cliente;
    }

    @Override
    public Cliente clienteCrear(Cliente cliente) {
        Cliente cl = null;
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO clientes (")
                .append("email,")
                .append("usuario,")
                .append("password)")
                .append(" VALUES (?,?,?)");

        try (Connection con = conexionBaseDatos.connecta()) {
            // para retornar el id debemos cambiar prepareCall por prepareStatement y agregar un 2do parametro Statement.RETURN_GENERATED_KEYS (no olvidar import java.sql.Statement;)
            PreparedStatement ps = con.prepareStatement(sql.toString(),
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getEmail());
            ps.setString(2, cliente.getUsuario());
            ps.setString(3, cliente.getPassword());
            // ejecutar INSERT
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas == 0) {
                System.out.println("La inserción fallo, ningun registro afectado.");
            }
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    // asignar objeto con valores al objeto vacio inicialmente
                    cl = cliente;
                    cl.setClienteId(id);
                } else {
                    System.out.println("La inserción fallo, no se pudo obtener el ID generado.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return cl;
    }

    @Override
    public Cliente autenticar(String usuario, String password) {
        // si falla autenticacion retorna nulo
        // TODO: Autenticar con hash de contrasena, en lugar de texto plano
        Cliente cliente = null;
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT ")
                .append("cliente_id,")
                .append("email,")
                .append("usuario,")
                .append("password")
                .append(" FROM clientes WHERE email = ? AND password = ?");

        try (Connection con = conexionBaseDatos.connecta()) {
            PreparedStatement ps = con.prepareCall(sql.toString());
            ps.setString(1, usuario);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cliente = new Cliente(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4));
                } else {
                    // falla autenticacion
                    cliente = null;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return cliente;
    }

    public String clienteCrear(Object cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
