package org.course.spring.dao;

import java.util.List;

import org.course.spring.beans.Aficion;
import org.course.spring.beans.Persona;
import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class PersonaDaoHibernate extends HibernateDaoSupport implements PersonaDao {
    public PersonaDaoHibernate() {
    }

    public List getPersonas() {
        return getHibernateTemplate().find("from Persona p order by p.nombre");
    }

    public Persona insertPersona(Persona una) {
        getHibernateTemplate().saveOrUpdate(una);
        return una;
    }

    public void updatePersona(Persona una) {
        getHibernateTemplate().update(una);
    }

    public void deletePersona(Persona una) {
        getHibernateTemplate().delete(una);
    }

    public Persona getPersona(Integer id) {
        return (Persona)getHibernateTemplate().load(Persona.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Persona> getPorNombreParecido(final String nombre) {
        return getHibernateTemplate().executeFind(new HibernateCallback() {
                    public Object doInHibernate(Session session) {
                        Query query = 
                            session.createQuery("from Persona p where p.nombre like :nombre");
                        query.setString("nombre", "%" + nombre + "%");
                        return query.list();
                    }
                });
    }

    public Long getNumeroDePersonas() {
        List lista = 
            getHibernateTemplate().find("select count(*) from Persona");
        return (Long)lista.get(0);
    }

    @SuppressWarnings("unchecked")
    public List<Aficion> getAficiones(Integer id) {
        return getHibernateTemplate().find("select p.aficionesInternas from Persona p where p.id = ?", 
                                           new Object[] { id });
    }

    @SuppressWarnings("unchecked")
    public List<Aficion> getAficionesDeOtraManera(final Integer id) {
        return getHibernateTemplate().executeFind(new HibernateCallback(){
                    public Object doInHibernate(Session session) {
                        Persona p = (Persona)session.load(Persona.class,id);
                        return p.getAficiones();
                    }
                });
    }

    public List<Aficion> getAficionesDeOtraManeraMas(Integer id) {
        Persona p = (Persona)getHibernateTemplate().load(Persona.class,id);
        return p.getAficiones();
    }
}
