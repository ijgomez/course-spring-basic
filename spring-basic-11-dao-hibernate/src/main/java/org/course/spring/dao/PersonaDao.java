package org.course.spring.dao;

import java.util.List;

import org.course.spring.beans.Aficion;
import org.course.spring.beans.Persona;

public interface PersonaDao {
    List<Persona> getPersonas();

    Persona insertPersona(Persona una);

    void updatePersona(Persona una);

    void deletePersona(Persona una);

    Persona getPersona(Integer id);

    List<Persona> getPorNombreParecido(String nombre);

    Long getNumeroDePersonas();
    
    List<Aficion> getAficiones(Integer id);

    List<Aficion> getAficionesDeOtraManera(Integer id);

    List<Aficion> getAficionesDeOtraManeraMas(Integer id);
}
