
package com.java.proyectociclo4.controlador;

import com.java.proyectociclo4.dao.impl.DaoCategoriaImpl;
import com.java.proyectociclo4.dao.DaoFormularioCategoria;
import com.java.proyectociclo4.dao.impl.DaoFormularioCategoriaImpl;
import com.java.proyectociclo4.dao.impl.DaoFormularioImpl;
import com.java.proyectociclo4.entity.Categoria;
import com.java.proyectociclo4.entity.Formulario;
import com.java.proyectociclo4.entity.FormularioCategoria;
import java.awt.event.ActionListener;
import javax.swing.DefaultButtonModel;
import com.java.proyectociclo4.vista.CrearFormulario;
import com.java.proyectociclo4.vista.PanelPrincipal;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;



/**
 *
 * @author Daygo
 */
public class CrearFormularioControlador implements ActionListener{
    
    private DaoFormularioImpl modelo;
    private CrearFormulario vista;
    private Integer clienteId = 1;
    private DaoFormularioCategoriaImpl modelo2;
    private DaoCategoriaImpl modelo3;
    private DefaultButtonModel modeloTabla;
    private Integer formularioId;
    

    public CrearFormularioControlador(DaoFormularioImpl modelo,DaoFormularioCategoriaImpl modelo2,DaoCategoriaImpl modelo3, CrearFormulario vista) {
        this.modelo = modelo;
        this.modelo2 = modelo2;
        this.modelo3 = modelo3;
        this.vista = vista;
    }


    public void start() {
        
        //mapear funcionalidad del boton
        this.vista.btnCrearFormulario.addActionListener(this);
        System.out.println("Iniciando");
        this.crearRadioButtonsDinamicos();
        this.vista.btnAtras.addActionListener(this);
        this.vista.btnCrearFormulario.addActionListener(this);
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        
        //Llamando metodos
    }
    
    private void crearNuevoFormulario(){
        
        String urlWeb = this.vista.txtLinkPagina.getText();
        Formulario fm1 = new Formulario( clienteId, urlWeb);
        Formulario formularioCreado = this.modelo.crearFormulario(fm1);
        
        formularioId = Integer.valueOf(formularioCreado.getFormularioId());
    }
    
    private void obtenerCategorias(){
        
        List<Categoria> categorias = this.modelo3.categoriaSelecPorCliente(clienteId);        
        for (Categoria categoria : categorias) {
            System.out.println(categoria);            
        }
    }
    
    private void asignarCategoriasFormulario(){
        
        //For seleccion dependiendo de categoria escogida
        FormularioCategoria fc = new FormularioCategoria();        
        fc.setCategoriaId(4);
        fc.setFormularioId(formularioId);
        String menForm = this.modelo2.formularioCategoriaCrear(fc);
            
    }
    
    private void crearRadioButtonsDinamicos() {
        
        
        // Crear un grupo para los radio buttons
    this.vista.group.add(new JRadioButton("one"));
    this.vista.group.add(new JRadioButton("two"));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    JButton btn = (JButton) e.getSource();
        if (btn == this.vista.btnCrearFormulario) {
            crearNuevoFormulario();
        }
        if (btn == this.vista.btnAtras){
            PanelPrincipal vista1 = new PanelPrincipal();
            DaoCategoriaImpl modelo1 = new DaoCategoriaImpl();
            DaoFormularioImpl modelo2 = new DaoFormularioImpl();
            PanelPrincipalControlador controlador = new PanelPrincipalControlador(modelo1, modelo2, vista1);
            // Establecer variable requerida (clienteId)
            controlador.setClienteId(this.clienteId);
            // iniciar y mostrar nuevo frame
            controlador.start();
            // ocultar frame actual
            this.vista.dispose();
        }
    }
    

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }
    
    
    
}
