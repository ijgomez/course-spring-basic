package org.course.spring.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.course.spring.beans.Employee;
import org.course.spring.beans.ActivityPart;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    
	@PersistenceContext
    private EntityManager em;
    
	@SuppressWarnings("unchecked")
	@Override
    public List<Employee> findAll() throws DataAccessException {        
        Query query = em.createQuery("select e from Employee as e");
        return query.getResultList();
    }

	@Override
    public Employee create(Employee employee) throws DataAccessException {
        em.persist(employee);
        return employee;
    }

	@Override
    public void asignActivityPart(Employee employee, ActivityPart activityPart) throws DataAccessException {
		employee.setActivities(new ArrayList<>());
		employee.getActivities().add(activityPart);
        activityPart.setEmployee(employee);
        em.persist(employee);
    }

	@Override
    public List<ActivityPart> findActivitiesBy(Employee employee) throws DataAccessException {
        Employee e = em.find(Employee.class,employee.getId());
        return e.getActivities();
    }
    
}
