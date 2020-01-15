/*
 * Cuenta.java
 *
 * Created on 25 de junio de 2007, 14:19
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.course.spring.beans;

/**
 *
 * @author Administrador
 */
public interface Cuenta {
    Cliente getCliente();
    Double getSaldo();    
    void ingresar(Double importe);
    Double reintegrar(Double importe);
}
