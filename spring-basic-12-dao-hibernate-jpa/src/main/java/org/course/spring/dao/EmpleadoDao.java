/*
 * EmpleadoDao.java
 *
 * Created on 20 de junio de 2007, 13:48
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.course.spring.dao;

import java.util.List;

import org.course.spring.beans.Empleado;
import org.course.spring.beans.ParteActividad;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Administrador
 */
public interface EmpleadoDao {
    List<Empleado> getEmpleados() throws DataAccessException;
    Empleado insertarEmpleado(Empleado empleado) throws DataAccessException;
    void asignarParteActividad(Empleado empleado, ParteActividad parteActividad) throws DataAccessException;    
    List<ParteActividad> getActividades(Empleado empleado) throws DataAccessException;
}
