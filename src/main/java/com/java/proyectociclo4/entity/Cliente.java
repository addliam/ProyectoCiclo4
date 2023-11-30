package com.java.proyectociclo4.entity;

/**
 *
 * @author liamy
 */
public class Cliente {

    private Integer clienteId;
    private String email;
    private String usuario; // nombre de cliente
    private String password;

    @Override
    public String toString() {
        return String.format("Cliente ID: %d%nEmail: %s%nUsuario: %s%nPassword: %s",
                clienteId, email, usuario, password);
    }

    public Cliente(Integer clienteId, String email, String usuario, String password) {
        this.clienteId = clienteId;
        this.email = email;
        this.usuario = usuario;
        this.password = password;
    }

    // constructor sin id
    public Cliente(String email, String usuario, String password) {
        this.email = email;
        this.usuario = usuario;
        this.password = password;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
