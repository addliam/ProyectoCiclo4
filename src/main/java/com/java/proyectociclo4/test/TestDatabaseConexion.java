package com.java.proyectociclo4.test;

import com.java.proyectociclo4.util.ConexionBaseDatos;
import java.sql.Connection;

/**
 *
 * @author liamy
 */
public class TestDatabaseConexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConexionBaseDatos conectaBaseDatos = new ConexionBaseDatos();
        try {
            Connection cx = conectaBaseDatos.connecta();
            System.out.println("[-] Conexion a base de datos exitosa");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
