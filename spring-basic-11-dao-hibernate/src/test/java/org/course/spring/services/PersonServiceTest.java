package org.course.spring.services;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;

import org.course.spring.beans.Hobby;
import org.course.spring.beans.Person;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

public class PersonServiceTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceTest.class);

	private static ApplicationContext ctx;

	private PersonService personService;

	@BeforeClass
	public static void beforeInitTesting() {
		ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		LOGGER.info("Contexto cargado");
		loadDataTest();
	}

	@Before
	public void beforeTest() {
		personService = (PersonService) ctx.getBean("personService");
	}

	@Test
	public void testCreate() {
		
		Person person = new Person();
		person.setName("randomName");
		Hobby hobby = new Hobby();
		hobby.setName("randomHobby");
		hobby.setPerson(person);
		person.setInternalHobbies(new HashSet<>());
		person.getInternalHobbies().add(hobby);
		
		person = personService.create(person);
		
		assertNotNull(person.getId());
	}

	@Test
	public void testRead() {
		Person person = personService.read(1L);
		
		assertNotNull(person);
	}

	@Test
	public void testUpdate() {
		Person person = personService.read(3L);
		assertNotNull(person);
		
		person.setName("newup");
		
		personService.update(person);
		
		person = personService.read(3L);
		assertNotNull(person);
		assertEquals("newup", person.getName());
	}

	@Test
	public void testDelete() {
		Person person = personService.read(1L);
		assertNotNull(person);
		
		personService.delete(person);
		
	}

	@Test
	public void testFindAll() {
		for (Person person: personService.findAll()) {
			assertNotNull(person);
			assertNotNull(person.getId());
        }
	}

	@Test
	public void testCountAll() {
		assertTrue(personService.countAll() > 0);
	}

	@Test
	public void testFindByName() {
		for (Person person: personService.findByName("randomName")) {
			assertNotNull(person);
			assertNotNull(person.getId());
        }
	}

	@Test
	public void testFindHobbiesByPerson() {
		List<Hobby> hobbies = personService.findHobbiesByPerson(2L);
        for (Hobby hobby: hobbies) {
        	assertNotNull(hobby);
			assertNotNull(hobby.getId());
        }
	}

	@Test
	public void testFindHobbiesByPersonOp2() {
		List<Hobby> hobbies = personService.findHobbiesByPersonOp2(2L);
        for (Hobby hobby: hobbies) {
        	assertNotNull(hobby);
			assertNotNull(hobby.getId());
        }
	}

	@Test
	public void testFindHobbiesByPersonOp3() {
		List<Hobby> hobbies = personService.findHobbiesByPersonOp3(2L);
        for (Hobby hobby: hobbies) {
        	assertNotNull(hobby);
			assertNotNull(hobby.getId());
        }
	}
	
	@Test(expected = DataAccessException.class)
	public void testAspects() {
		personService.read(20000L);
	}

	private static void loadDataTest() {
		PersonService s = (PersonService) ctx.getBean("personService");
		for (int i = 0; i < 10; i++) {
			Person person = new Person();
			person.setName("randomName" + i);
			Hobby hobby = new Hobby();
			hobby.setName("randomHobby" + i);
			hobby.setPerson(person);
			person.setInternalHobbies(new HashSet<>());
			person.getInternalHobbies().add(hobby);
			s.create(person);
		}
	}

}
