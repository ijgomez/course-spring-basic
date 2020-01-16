/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.course.spring.beans;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class Usuario implements Serializable {
    private Long id;
    
    private List<Rol> lista;

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Rol> getLista() {
        return lista;
    }

    public void setLista(List<Rol> lista) {
        this.lista = lista;
    }
    
    
}
