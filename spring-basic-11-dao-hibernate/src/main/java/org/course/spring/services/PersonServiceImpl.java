package org.course.spring.services;

import java.util.List;

import org.course.spring.beans.Hobby;
import org.course.spring.beans.Person;
import org.course.spring.dao.PersonDao;

public class PersonServiceImpl implements PersonService {

	private PersonDao personDao;

	@Override
	public Person create(Person person) {
		return personDao.create(person);
	}

	@Override
	public Person read(Long id) {
		return personDao.read(id);
	}

	@Override
	public void update(Person person) {
		personDao.update(person);
	}

	@Override
	public void delete(Person person) {
		personDao.delete(person);
	}

	@Override
	public List<Person> findAll() {
		return personDao.findAll();
	}

	@Override
	public Long countAll() {
		return personDao.countAll();
	}

	@Override
	public List<Person> findByName(String name) {
		return personDao.findByName(name);
	}

	@Override
	public List<Hobby> findHobbiesByPerson(Long id) {
		return personDao.findHobbiesByPerson(id);
	}

	@Override
	public List<Hobby> findHobbiesByPersonOp2(Long id) {
		return personDao.findHobbiesByPersonOp2(id);
	}

	@Override
	public List<Hobby> findHobbiesByPersonOp3(Long id) {
		return personDao.findHobbiesByPersonOp3(id);
	}
	
	public PersonDao getPersonDao() {
		return personDao;
	}
	
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
}
