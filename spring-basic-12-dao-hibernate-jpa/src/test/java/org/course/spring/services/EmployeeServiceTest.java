package org.course.spring.services;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.course.spring.beans.ActivityPart;
import org.course.spring.beans.Employee;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeServiceTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceTest.class);

	private static ApplicationContext ctx;

	@BeforeClass
	public static void beforeInitTesting() {
		ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		LOGGER.info("Contexto cargado");
		loadDataTest();
	}
	
	private static void loadDataTest() {
		EmployeeService employeeService = (EmployeeService) ctx.getBean("employeeService");
		final Integer MAX_ELEMENTOS = 5;
        for(int i = 0; i < MAX_ELEMENTOS; i++) {
        	employeeService.create(new Employee("Name" + i,"xyz@abc.com"));
        }
            
		// TODO Auto-generated method stub
		
	}
	
	private EmployeeService employeeService;
	
	@Before
	public void beforeTest() {
		employeeService = (EmployeeService) ctx.getBean("employeeService");
	}

	@Test
	public void testFindAll() {
		List<Employee> employees = employeeService.findAll();
        LOGGER.info("Se han encontrado {} empleados.", employees.size());
        for (Employee e : employees) {
        	LOGGER.info("El nombre del empleado es {} y su clave es {}",e.getName(), e.getId());
        }
	}

	@Test
	public void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	public void testAsignActivityPart() {
		Random r = new Random();
        Employee employee = new Employee("Employee with activities" + System.currentTimeMillis(),"abc@xyz.com");
        ActivityPart activityPart = new ActivityPart(r.nextDouble(), "Activity" + System.currentTimeMillis());
        
        employeeService.asignActivityPart(employee, activityPart);
        
        List<ActivityPart> activities = employeeService.findActivitiesBy(employee);
        LOGGER.info("se han encontrado {} partes de actividad.",activities.size());
        for (ActivityPart a : activities) {
        	LOGGER.info("El nombre de la actividad es {} y se realizó en {} horas",a.getName(), a.getHours());
        }
        
	}

	@Test
	public void testFindActivitiesBy() {
		fail("Not yet implemented");
	}

}
