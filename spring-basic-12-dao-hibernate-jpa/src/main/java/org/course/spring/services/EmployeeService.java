package org.course.spring.services;

import java.util.List;

import org.course.spring.beans.ActivityPart;
import org.course.spring.beans.Employee;
import org.springframework.dao.DataAccessException;

public interface EmployeeService {
	
	List<Employee> findAll() throws DataAccessException;

	Employee create(Employee empleado) throws DataAccessException;

	void asignActivityPart(Employee empleado, ActivityPart parteActividad) throws DataAccessException;

	List<ActivityPart> findActivitiesBy(Employee empleado) throws DataAccessException;

}
