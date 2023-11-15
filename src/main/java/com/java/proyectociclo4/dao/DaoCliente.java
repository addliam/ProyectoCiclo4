package com.java.proyectociclo4.dao;

import com.java.proyectociclo4.entity.Cliente;

/**
 *
 * @author liamy
 */

/*
 Recursos
 https://javajhon.blogspot.com/2019/10/dao.html
 */
public interface DaoCliente {

    public Cliente clienteLeer(Integer id);

    public String clienteCrear(Cliente cliente);

    public Cliente autenticar(String usuario, String password);
}
