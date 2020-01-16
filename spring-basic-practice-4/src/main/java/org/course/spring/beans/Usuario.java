/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.course.spring.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Administrador
 */
@Entity
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Rol> lista = new ArrayList<Rol>();

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

    @Override
    public String toString() {
        return String.format("ID=[%s] NOMBRE=[%s]", this.getId(), this.getNombre());
    }
    
    
}
