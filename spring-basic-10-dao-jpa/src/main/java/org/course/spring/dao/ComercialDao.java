package org.course.spring.dao;

import java.util.Collection;

import org.course.spring.beans.Comercial;
import org.course.spring.beans.Contact;
import org.springframework.dao.DataAccessException;

public interface ComercialDao {
    
	Collection<Comercial> findAll() throws DataAccessException;
    
    Long create(Comercial c) throws DataAccessException;
    
    void associate(Comercial comercial, Contact contacto) throws DataAccessException;
    
    Comercial read(Long id) throws DataAccessException;
}
