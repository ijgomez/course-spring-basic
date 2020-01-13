/*
 * ContactDao.java
 *
 * Created on 5 de junio de 2007, 12:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.course.spring.dao;

import java.util.Collection;

import org.course.spring.beans.Contact;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author user
 */
public interface ContactDao {
    Collection<Contact> getTodosLosContactos() throws DataAccessException;
    Long insertarContacto(Contact c) throws DataAccessException;    
}
