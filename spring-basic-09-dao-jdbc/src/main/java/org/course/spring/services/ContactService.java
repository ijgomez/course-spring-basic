package org.course.spring.services;

import java.io.Serializable;

import java.util.List;

import org.course.spring.beans.Contact;
import org.springframework.dao.DataAccessException;


public interface ContactService extends Serializable {
	
    List<Contact> findAll() throws DataAccessException;
    
    void create(Contact contact) throws DataAccessException;
    
    void update(Contact contact) throws DataAccessException;
}
