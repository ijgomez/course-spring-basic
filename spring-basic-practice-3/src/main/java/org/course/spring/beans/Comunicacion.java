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
public class Comunicacion implements Serializable{

    private String tipo;

    public Comunicacion() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public boolean comunicar(String mensaje){
        System.out.println("Establecer comunicacion original.");
        return false;
    }
    
}
