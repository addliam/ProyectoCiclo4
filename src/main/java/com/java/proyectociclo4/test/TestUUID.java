
package com.java.proyectociclo4.test;

import java.util.UUID;

/**
 *
 * @author PC
 */
public class TestUUID {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final String uuid = UUID.randomUUID().toString().replace("-", "");
        System.out.println("uuid = " + uuid);
    }
    
}
