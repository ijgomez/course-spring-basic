/*
 * EmpleadoDaoImpl.java
 *
 * Created on 20 de junio de 2007, 13:51
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.course.spring.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.course.spring.beans.Empleado;
import org.course.spring.beans.ParteActividad;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrador
 */
@Repository
public class EmpleadoDaoImpl implements EmpleadoDao{
    @PersistenceContext
    private EntityManager em;
    /** Creates a new instance of EmpleadoDaoImpl */
    public EmpleadoDaoImpl() {
    }
    
    public List<Empleado> getEmpleados() throws DataAccessException {        
        Query query = em.createQuery("select e from Empleado as e");
        return query.getResultList();
    }
    
    public Empleado insertarEmpleado(Empleado empleado) throws DataAccessException {
        em.persist(empleado);
        return empleado;
    }
    
    public void asignarParteActividad(Empleado empleado, ParteActividad parteActividad) throws DataAccessException {
        empleado.getActividades().add(parteActividad);
        parteActividad.setEmpleado(empleado);
        em.persist(empleado);
    }
    
    public List<ParteActividad> getActividades(Empleado empleado) throws DataAccessException {
        Empleado e = em.find(Empleado.class,empleado.getId());
        return e.getActividades();
    }
    
}
