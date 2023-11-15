package com.java.proyectociclo4.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author liamy
 */
public class ConexionBaseDatos {
    public Connection connecta() throws SQLException{
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String url = "jdbc:postgresql://isabelle.db.elephantsql.com/ghwnmpic";
        String username = "ghwnmpic";
        String password = "Kz3r8ZtQSt1-fi1poWdJS2-NnxMvrC4_";

        Connection conexion = null;
        
        try {
            conexion = DriverManager.getConnection(url, username, password);
            }
        catch (java.sql.SQLException e) {
            throw new SQLException(e.getMessage());
        }        
        return conexion;
    }
}
