/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.course.spring.beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chema
 */
public class Usuario extends Persona {

    private String clave;
    private List<Rol> roles;
    private Perfil perfil;

    public Usuario() {
    }

    public Usuario(String nombre, String clave) {
        super(nombre);
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public List<Rol> getRoles() {
        if (roles == null) {
            roles = new ArrayList<Rol>();
        }
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return super.toString() + " " + clave + " " + getPerfil();
    }
}
