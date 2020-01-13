package org.course.spring.services;

import java.util.Collection;
import java.util.List;

import org.course.spring.beans.Comercial;
import org.course.spring.beans.Contact;
import org.course.spring.dao.ComercialDao;
import org.course.spring.dao.ContactDao;
import org.springframework.dao.DataAccessException;

public class ClientServiceImpl implements  ClientService{
    
    private ContactDao contactoDao;
    
    private ComercialDao comercialDao;
    
   
    public void setContactoDao(ContactDao contactoDao) {
        this.contactoDao = contactoDao;
    }
    
    public void setComercialDao(ComercialDao comercialDao) {
        this.comercialDao = comercialDao;
    }
    
    @Override
    public Collection<Comercial> getTodosLosComerciales() throws DataAccessException {
        return comercialDao.getTodosLosComerciales();
    }

    @Override
    public Long insertarComercial(Comercial c) throws DataAccessException {
        comercialDao.insertarComercial(c);
        return c.getId();
    }

    @Override
    public Collection<Contact> getTodosLosContactos() throws DataAccessException {
        return contactoDao.getTodosLosContactos();
    }

    @Override
    public Long insertarContacto(Contact c) throws DataAccessException {
        contactoDao.insertarContacto(c);
        return c.getId();
    }

    @Override
    public void asignarContacto(Comercial comercial, Contact contacto) throws DataAccessException {
        comercialDao.asignarContacto(comercial,contacto);
    }

    @Override
    public List<Contact> getContactosDeUnComercial(Comercial comercial) throws DataAccessException {
        return comercialDao.getComercial(comercial.getId()).getContacts();
    }
    
}
