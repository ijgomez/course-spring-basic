/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.course.spring.beans;

import java.io.Serializable;

/**
 *
 * @author Administrador
 */
public class Rol implements Serializable {

    private String rol;

    public Rol() {
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
