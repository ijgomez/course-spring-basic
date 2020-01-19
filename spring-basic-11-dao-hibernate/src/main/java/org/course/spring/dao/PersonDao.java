package org.course.spring.dao;

import java.util.List;

import org.course.spring.beans.Hobby;
import org.course.spring.beans.Person;

public interface PersonDao {
    
    Person create(Person person);
    
    Person read(Long id);

    void update(Person person);

    void delete(Person person);

    List<Person> findAll();
    
    Long countAll();

    List<Person> findByName(String name);
    
    List<Hobby> findHobbiesByPerson(Long id);

    List<Hobby> findHobbiesByPersonOp2(Long id);

    List<Hobby> findHobbiesByPersonOp3(Long id);
}
