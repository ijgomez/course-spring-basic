package org.course.spring.services;

import java.util.List;

import org.course.spring.beans.Aficion;
import org.course.spring.beans.Persona;
import org.course.spring.dao.PersonaDao;

public class ServicioPersonaImpl implements ServicioPersona {
    private PersonaDao personaDao;

    public ServicioPersonaImpl() {
    }

    @SuppressWarnings("unchecked")
    public List getPersonas() {
        return personaDao.getPersonas();
    }

    public Persona insertPersona(Persona una) {
        return personaDao.insertPersona(una);
    }

    public void updatePersona(Persona una) {
        personaDao.updatePersona(una);
    }

    public void deletePersona(Persona una) {
        personaDao.deletePersona(una);
    }

    public Persona getPersona(Integer id) {
        return personaDao.getPersona(id);
    }

    @SuppressWarnings("unchecked")
    public List getPorNombreParecido(String nombre) {
        return personaDao.getPorNombreParecido(nombre);
    }

    public void setPersonaDao(PersonaDao personaDao) {
        this.personaDao = personaDao;
    }

    public Long getNumeroDePersonas() {
        return personaDao.getNumeroDePersonas();
    }

    public List<Aficion> getAficiones(Integer id) {
        return personaDao.getAficiones(id);
    }

    public List<Aficion> getAficionesDeOtraManera(Integer id) {
        return personaDao.getAficionesDeOtraManera(id);
    }

    public List<Aficion> getAficionesDeOtraManeraMas(Integer id) {
        return personaDao.getAficionesDeOtraManeraMas(id);
    }
}
