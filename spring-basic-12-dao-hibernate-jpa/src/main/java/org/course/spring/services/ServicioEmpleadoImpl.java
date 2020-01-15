/*
 * ServicioEmpleadoImpl.java
 *
 * Created on 20 de junio de 2007, 14:02
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.course.spring.services;

import java.util.List;

import org.course.spring.beans.Empleado;
import org.course.spring.beans.ParteActividad;
import org.course.spring.dao.EmpleadoDao;

/**
 *
 * @author Administrador
 */
public class ServicioEmpleadoImpl implements ServicioEmpleado{
    private EmpleadoDao empleadoDao;
    /** Creates a new instance of ServicioEmpleadoImpl */
    public ServicioEmpleadoImpl() {
    }
    
    public List<Empleado> getEmpleados() {
        return empleadoDao.getEmpleados();
    }
    
    public Empleado insertarEmpleado(Empleado empleado) {
        return empleadoDao.insertarEmpleado(empleado);
    }
    
    public void asignarParteActividad(Empleado empleado, ParteActividad parteActividad) {
        empleadoDao.asignarParteActividad(empleado,parteActividad);
    }
    
    public void setEmpleadoDao(EmpleadoDao empleadoDao) {
        this.empleadoDao = empleadoDao;
    }
    
    public List<ParteActividad> getActividades(Empleado empleado)  {
        return empleadoDao.getActividades(empleado);
    }
    
}
