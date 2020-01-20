package org.course.spring.services;

import java.util.Collection;
import java.util.List;

import org.course.spring.beans.Comercial;
import org.course.spring.beans.Contact;
import org.springframework.dao.DataAccessException;

public interface ClientService {
	
    void associate(Comercial comercial, Contact contacto) throws DataAccessException;

    List<Contact> findContactsBy(Comercial comercial) throws DataAccessException;

    Collection<Comercial> findAllComercials() throws DataAccessException;

    Collection<Contact> findAllContacts() throws DataAccessException;

    Long create(Comercial c) throws DataAccessException;

    Long create(Contact c) throws DataAccessException;    
}
