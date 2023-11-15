/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.proyectociclo4.controlador;

import com.java.proyectociclo4.dao.impl.DaoClienteImpl;
import com.java.proyectociclo4.entity.Cliente;
import com.java.proyectociclo4.vista.InicioSesion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author liamy
 */
public class InicioSesionControlador implements ActionListener {

    private InicioSesion vista;
    private DaoClienteImpl modelo;

    public InicioSesionControlador(InicioSesion vista, DaoClienteImpl modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    public void start() {
        this.vista.btnIniciarSesion.addActionListener(this);
        this.vista.btnIniciarSesion.setName("login");
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton o = (JButton) e.getSource();
        String name = o.getName();
        if ("login".equals(name)) {

            Cliente cl = modelo.autenticar(
                    this.vista.txtUsuario.getText(),
                    this.vista.txtContrasena.getText());
            if (cl == null) {
                System.out.println("[-] Fallo autenticacion");
            } else {
                System.out.println(cl);
            }
        }
    }

}
