/*
 * ServicioClienteImpl.java
 *
 * Created on 27-sep-2007, 12:05:48
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.course.spring.services;

import java.io.Serializable;

import org.course.spring.annotations.Fiscalizable;
import org.course.spring.annotations.Registrable;
import org.course.spring.beans.Cliente;
import org.course.spring.beans.Cuenta;

/**
 *
 * @author user
 */
public class ServicioClienteImpl implements Serializable, ServicioCliente {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4871122138699265126L;

	public Cliente getCliente(Long clienteId) {
        return null;
    }

    @Registrable
    @Fiscalizable
    public void ingresar(Cliente cliente, Cuenta cuenta, Double importe) {
    }

    @Registrable(siHayError = true)
    public Double reintegrar(Cliente cliente, Cuenta cuenta, Double importe) {
        return null;
    }

    public Double getSaldoMedio(Cliente cliente) {
        return null;
    }
}