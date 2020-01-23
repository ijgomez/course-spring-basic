package org.course.spring.services;

import org.course.spring.annotations.Fiscalizable;
import org.course.spring.annotations.Registrable;
import org.course.spring.beans.Client;
import org.course.spring.beans.Account;

public interface ClientService {
    
	Client getCliente(Long clienteId);
    
	@Registrable
    @Fiscalizable
    void ingresar(Client client, Account account, Double amount);
    
	@Registrable(siHayError=true)    
    public Double reintegrar(Client client, Account account, Double amount);
    
	public Double getSaldoMedio(Client client);
}
