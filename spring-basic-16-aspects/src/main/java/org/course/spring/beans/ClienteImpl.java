/*
 * ClienteImpl.java
 *
 * Created on 27-sep-2007, 12:03:52
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.course.spring.beans;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author user
 */
public class ClienteImpl implements Serializable, Cliente {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5900649152677408506L;

	public List<Cuenta> getCuentas() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Cuenta getCuenta(Long cuentaId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getNombre() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}