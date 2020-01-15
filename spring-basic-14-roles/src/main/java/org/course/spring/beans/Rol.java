/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.course.spring.beans;

import java.io.Serializable;

/**
 *
 * @author Chema
 */
public class Rol implements Serializable {

    private String nombre;

    public Rol() {
    }

    public Rol(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
