/*
 * EmployeeDao.java
 *
 * Created on 20 de junio de 2007, 13:48
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.course.spring.dao;

import java.util.List;

import org.course.spring.beans.Employee;
import org.course.spring.beans.ActivityPart;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Administrador
 */
public interface EmployeeDao {
    List<Employee> findAll() throws DataAccessException;
    Employee create(Employee empleado) throws DataAccessException;
    void asignActivityPart(Employee empleado, ActivityPart parteActividad) throws DataAccessException;    
    List<ActivityPart> findActivitiesBy(Employee empleado) throws DataAccessException;
}
