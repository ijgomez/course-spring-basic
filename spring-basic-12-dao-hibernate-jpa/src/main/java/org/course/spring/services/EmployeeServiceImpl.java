package org.course.spring.services;

import java.util.List;

import org.course.spring.beans.Employee;
import org.course.spring.beans.ActivityPart;
import org.course.spring.dao.EmployeeDao;

public class EmployeeServiceImpl implements EmployeeService {
	
    private EmployeeDao employeeDao;
    
    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
    
    @Override
    public Employee create(Employee empleado) {
        return employeeDao.create(empleado);
    }
    
    @Override
    public void asignActivityPart(Employee empleado, ActivityPart parteActividad) {
        employeeDao.asignActivityPart(empleado,parteActividad);
    }
    
    @Override
    public List<ActivityPart> findActivitiesBy(Employee empleado)  {
        return employeeDao.findActivitiesBy(empleado);
    }

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

}
