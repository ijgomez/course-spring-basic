package org.course.spring.services;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.course.spring.annotations.Fiscalizable;
import org.course.spring.annotations.Registrable;
import org.course.spring.beans.Client;
import org.course.spring.beans.Account;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly=true)
public class ClientServiceImpl implements ClientService {
    
	@PersistenceContext()
    private EntityManager em;
    
    public Client getCliente(Long clienteId) {
        return null;
    }
    
    @Registrable
    @Fiscalizable
    @Transactional(readOnly=false,propagation=Propagation.REQUIRED)
    public void ingresar(Client client, Account account, Double amount) {
        account.setAmount(amount);
        
        client.setAccounts(new ArrayList<>());
        client.getAccounts().add(account);
        account.setClient(client);
        
        em.persist(client);
    }
    
    @Registrable(siHayError = true)
    @Transactional(readOnly=false,propagation=Propagation.REQUIRED)    
    public Double reintegrar(Client client, Account account, Double amount) {
        return null;
    }
    
    public Double getSaldoMedio(Client client) {
        return null;
    }
    
}
