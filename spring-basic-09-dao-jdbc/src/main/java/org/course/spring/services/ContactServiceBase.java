package org.course.spring.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.course.spring.beans.Contact;
import org.course.spring.beans.ContactImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;

public abstract class ContactServiceBase extends JdbcDaoSupport implements ContactService {

	private static final long serialVersionUID = -4637553508063752597L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(ContactServiceBase.class);
	
	private List<Contact> contacts = new ArrayList<Contact>();
    
	private ConsultaContactos consultaContactos;
    
	private NuevoContacto nuevoContacto;
    
	private ActualizarContacto actualizarContacto;
    
    @Override
    protected void initDao() {
        consultaContactos = new ConsultaContactos(getDataSource());
        nuevoContacto = new NuevoContacto(getDataSource());
        actualizarContacto = new ActualizarContacto(getDataSource());
    }

    @SuppressWarnings("unchecked")
    public List<Contact> getContactos() throws DataAccessException {
        synchronized (this.contacts) {
            LOGGER.info("Cargando los contactos de la base de datos");
            contacts.clear();
            contacts.addAll(consultaContactos.execute());
            return contacts;
        }
    }

    @Override
    public void insertarContacto(Contact c) throws DataAccessException {
        nuevoContacto.insert(c);
    }

    @Override
    public void actualizarContacto(Contact c) throws DataAccessException {
        actualizarContacto.update(c);
    }

    protected class ConsultaContactos extends MappingSqlQuery {
        protected ConsultaContactos(DataSource ds, String sql) {
            super(ds, sql);
        }

        protected ConsultaContactos(DataSource ds) {
            super(ds, "SELECT id,name,comments FROM contacts ORDER BY name");
            compile();
        }

        protected Object mapRow(ResultSet rs, int rownum) throws SQLException {
            Contact contacto = new ContactImpl();
            contacto.setId(new Integer(rs.getInt("id")));
            contacto.setNombre(rs.getString("name"));
            contacto.setComentario(rs.getString("comments"));
            return contacto;
        }
    }

    protected class NuevoContacto extends SqlUpdate {

        protected NuevoContacto(DataSource ds) {
            super(ds, "INSERT INTO contacts (name,comments) VALUES(?,?)");
            declareParameter(new SqlParameter(Types.VARCHAR));
            declareParameter(new SqlParameter(Types.VARCHAR));
            compile();
        }

        protected void insert(Contact contacto) {
            Object[] objs = new Object[] { contacto.getNombre(), contacto.getComentario() };
            super.update(objs);
            obtenerId(contacto);
        }

        private void obtenerId(Contact contacto) {
            contacto.setId(getJdbcTemplate().queryForInt(getIdentidad()));
        }

    }

    protected class ActualizarContacto extends SqlUpdate {

        protected ActualizarContacto(DataSource ds) {
            super(ds, "UPDATE contacts SET name=?,comments =? WHERE id=?");
            declareParameter(new SqlParameter(Types.VARCHAR));
            declareParameter(new SqlParameter(Types.VARCHAR));
            declareParameter(new SqlParameter(Types.INTEGER));
            compile();
        }

        protected int update(Contact contact) {
            return this.update(new Object[] { 
            		contact.getNombre(), 
            		contact.getComentario(), 
            		contact.getId() 
            	});
        }
    }

    protected abstract String getIdentidad();
}
