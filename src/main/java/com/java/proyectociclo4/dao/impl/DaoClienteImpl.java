package com.java.proyectociclo4.dao.impl;

import com.java.proyectociclo4.dao.DaoCliente;
import com.java.proyectociclo4.entity.Cliente;
import com.java.proyectociclo4.util.ConexionBaseDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    public String clienteCrear(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet.");
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
