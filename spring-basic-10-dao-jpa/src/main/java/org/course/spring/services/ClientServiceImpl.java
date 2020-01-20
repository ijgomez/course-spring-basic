package org.course.spring.services;

import java.util.Collection;
import java.util.List;

import org.course.spring.beans.Comercial;
import org.course.spring.beans.Contact;
import org.course.spring.dao.ComercialDao;
import org.course.spring.dao.ContactDao;
import org.springframework.dao.DataAccessException;

public class ClientServiceImpl implements  ClientService{
    
    private ContactDao contactDao;
    
    private ComercialDao comercialDao;
    
    @Override
    public Collection<Comercial> findAllComercials() throws DataAccessException {
        return comercialDao.findAll();
    }

    @Override
    public Long create(Comercial c) throws DataAccessException {
        comercialDao.create(c);
        return c.getId();
    }

    @Override
    public Collection<Contact> findAllContacts() throws DataAccessException {
        return contactDao.findAll();
    }

    @Override
    public Long create(Contact c) throws DataAccessException {
        contactDao.create(c);
        return c.getId();
    }

    @Override
    public void associate(Comercial comercial, Contact contacto) throws DataAccessException {
        comercialDao.associate(comercial,contacto);
    }

    @Override
    public List<Contact> findContactsBy(Comercial comercial) throws DataAccessException {
        return comercialDao.read(comercial.getId()).getContacts();
    }

	public ContactDao getContactDao() {
		return contactDao;
	}

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	public ComercialDao getComercialDao() {
		return comercialDao;
	}

	public void setComercialDao(ComercialDao comercialDao) {
		this.comercialDao = comercialDao;
	}

}
