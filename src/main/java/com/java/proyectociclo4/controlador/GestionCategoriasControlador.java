package com.java.proyectociclo4.controlador;

/**
 * @author Gherika
 */
import com.java.proyectociclo4.dao.impl.DaoCategoriaImpl;
import com.java.proyectociclo4.vista.GestionCategoria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class GestionCategoriasControlador implements ActionListener {

    private DaoCategoriaImpl modelo;
    private GestionCategoria vista;

    public GestionCategoriasControlador(DaoCategoriaImpl modelo, GestionCategoria vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void start() {
        //mapear funcionalidad del boton
        this.vista.btnCrearNuevaCategoria.addActionListener(this);
        this.vista.btnModificarCatego.addActionListener(this);
        this.vista.btnEliminarCategoria.addActionListener(this);

        //llamando metodos
        this.rellenarTablaCategoria();

        //mostrar el formulario
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }

    public void rellenarTablaCategoria() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Saber qué botón se presionó
        JButton btn = (JButton) e.getSource();

        if (btn == this.vista.btnCrearNuevaCategoria) {
            System.out.println("btnCrearNuevaCategoria");
            // Lógica para el botón de crear nueva categoría

        } else if (btn == this.vista.btnModificarCatego) {
            System.out.println("btnModificarCategorias");
            // Lógica para el botón de modificar categoría

        } else if (btn == this.vista.btnEliminarCategoria) {
            System.out.println("btnEliminarCategoria");
            // Lógica para el botón de eliminar categoría
            // Agrega aquí la llamada al método correspondiente o cualquier otra lógica necesaria
            // Por ejemplo:
            eliminarCategoriaSeleccionada();
        }
    }

    private void eliminarCategoriaSeleccionada() {

    }

}
