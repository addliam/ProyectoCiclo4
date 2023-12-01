/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.proyectociclo4.controlador;

import com.java.proyectociclo4.dao.impl.DaoCategoriaImpl;
import com.java.proyectociclo4.dao.impl.DaoClienteImpl;
import com.java.proyectociclo4.dao.impl.DaoFormularioImpl;
import com.java.proyectociclo4.entity.Cliente;
import com.java.proyectociclo4.vista.InicioSesion;
import com.java.proyectociclo4.vista.PanelPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

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
                JOptionPane.showMessageDialog(null, "Fallo la autenticacion. Email o password incorrectos.", "Error autenticacion", JOptionPane.ERROR_MESSAGE);
            } else {
                // Cambiar de frame
                PanelPrincipal vista1 = new PanelPrincipal();
                DaoCategoriaImpl modelo1 = new DaoCategoriaImpl();
                DaoFormularioImpl modelo2 = new DaoFormularioImpl();
                PanelPrincipalControlador controlador = new PanelPrincipalControlador(modelo1, modelo2, vista1);
                // Establecer variable requerida (clienteId)
                controlador.setClienteId(cl.getClienteId());
                // iniciar y mostrar nuevo frame
                controlador.start();
                // ocultar frame actual
                this.vista.dispose();
            }
        }
    }

}
