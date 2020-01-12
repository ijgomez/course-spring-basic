package org.course.spring.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.course.spring.beans.Contact;
import org.course.spring.beans.ContactImpl;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;


public abstract class ContactServiceBase extends JdbcDaoSupport implements ContactService {

	private static final long serialVersionUID = -4637553508063752597L;
	private List<Contact> contactos = new ArrayList<Contact>();
    private ConsultaContactos consultaContactos;
    private NuevoContacto nuevoContacto;
    private ActualizarContacto actContacto;
    private Log log = LogFactory.getLog(ContactServiceBase.class);

    @Override
    protected void initDao() {
        consultaContactos = new ConsultaContactos(getDataSource());
        nuevoContacto = new NuevoContacto(getDataSource());
        actContacto = new ActualizarContacto(getDataSource());
    }

    public ContactServiceBase() {
    }

    @SuppressWarnings("unchecked")
    public List<Contact> getContactos() throws DataAccessException {
        synchronized (this.contactos) {
            log.info("Cargando los contactos de la base de datos");
            contactos.clear();
            contactos.addAll(consultaContactos.execute());
            return contactos;
        }
    }

    public void insertarContacto(Contact c) throws DataAccessException {
        nuevoContacto.insert(c);
    }

    public void actualizarContacto(Contact c) throws DataAccessException {
        actContacto.update(c);
    }

    protected class ConsultaContactos extends MappingSqlQuery {
        protected ConsultaContactos(DataSource ds, String sql) {
            super(ds, sql);
        }

        protected ConsultaContactos(DataSource ds) {
            super(ds, 
                  "SELECT id,nombre,comentario FROM contactos ORDER BY nombre");
            compile();
        }

        protected Object mapRow(ResultSet rs, int rownum) throws SQLException {
            Contact contacto = new ContactImpl();
            contacto.setId(new Integer(rs.getInt("id")));
            contacto.setNombre(rs.getString("nombre"));
            contacto.setComentario(rs.getString("comentario"));
            return contacto;
        }
    }

    protected class NuevoContacto extends SqlUpdate {

        protected NuevoContacto(DataSource ds) {
            super(ds, "INSERT INTO contactos (nombre,comentario) VALUES(?,?)");
            declareParameter(new SqlParameter(Types.VARCHAR));
            declareParameter(new SqlParameter(Types.VARCHAR));
            compile();
        }

        protected void insert(Contact contacto) {
            Object[] objs = 
                new Object[] { contacto.getNombre(), contacto.getComentario() };
            super.update(objs);
            obtenerId(contacto);
        }

        private void obtenerId(Contact contacto) {
            contacto.setId(getJdbcTemplate().queryForInt(getIdentidad()));
        }

    }

    protected class ActualizarContacto extends SqlUpdate {

        protected ActualizarContacto(DataSource ds) {
            super(ds, "UPDATE contactos SET nombre=?,comentario=? WHERE id=?");
            declareParameter(new SqlParameter(Types.VARCHAR));
            declareParameter(new SqlParameter(Types.VARCHAR));
            declareParameter(new SqlParameter(Types.INTEGER));
            compile();
        }

        protected int update(Contact contacto) {
            return this.update(new Object[] { contacto.getNombre(), 
                                              contacto.getComentario(), 
                                              contacto.getId() });
        }
    }

    protected abstract String getIdentidad();
}
