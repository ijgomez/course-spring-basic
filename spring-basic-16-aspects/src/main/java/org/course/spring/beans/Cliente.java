/*
 * Cliente.java
 *
 * Created on 25 de junio de 2007, 14:19
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.course.spring.beans;

import java.util.List;

/**
 *
 * @author Administrador
 */
public interface Cliente {
    List<Cuenta> getCuentas();
    Cuenta getCuenta(Long cuentaId);
    void setNombre(String nombre);
    String getNombre();
}
