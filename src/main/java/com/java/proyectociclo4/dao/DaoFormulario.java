
package com.java.proyectociclo4.dao;

import com.java.proyectociclo4.entity.Formulario;
import java.util.List;

/**
 *
 * @author Daygo
 */
public interface DaoFormulario {
    
    public Formulario crearFormulario(Formulario formulario);
    public Formulario leerFormulario (Integer id);
    public List<Formulario> leerFormularioPorCliente(Integer clienteId);
    
    
}
