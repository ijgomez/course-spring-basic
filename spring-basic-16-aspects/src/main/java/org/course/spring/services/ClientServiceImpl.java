package org.course.spring.services;

import java.io.Serializable;

import org.course.spring.annotations.Fiscalizable;
import org.course.spring.annotations.Registrable;
import org.course.spring.beans.Client;
import org.course.spring.beans.Account;

public class ClientServiceImpl implements Serializable, ClientService {

	private static final long serialVersionUID = -4871122138699265126L;

	public Client getCliente(Long id) {
        return null;
    }

    @Registrable
    @Fiscalizable
    public void ingresar(Client client, Account account, Double amount) {
    }

    @Registrable(siHayError = true)
    public Double reintegrar(Client client, Account account, Double amount) {
        return null;
    }

    public Double getSaldoMedio(Client client) {
        return null;
    }
}