package com.java.proyectociclo4.test;

import com.java.proyectociclo4.dao.impl.DaoClienteImpl;
import com.java.proyectociclo4.entity.Cliente;

/**
 *
 * @author liamy
 */
public class TestDaoClienteImpl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DaoClienteImpl daoCliente = new DaoClienteImpl();
        Cliente cl = daoCliente.clienteLeer(2);
//        System.out.println(cl);
        Cliente authCliente = daoCliente.autenticar("testx@gmail.com", "password");
        System.out.println(authCliente);
    }

}
