package org.course.spring.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.course.spring.beans.Employee;
import org.course.spring.beans.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class InheritanceDaoImpl implements InheritanceDao {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
	public void test() {

        Person person = new Person();
        person.setName("Name1");
        
        entityManager.persist(person);
        
        Employee e1 = new Employee();
        e1.setName("Name1");
        e1.setAccount(1.0);
        
        entityManager.persist(e1);
        
        Employee e2 = new Employee();
        e2.setName("Name2");
        e2.setAccount(2.0);
        
        entityManager.persist(e2);
        
         Employee e3 = new Employee();
        e3.setAccount(2.0);
        
        entityManager.persist(e3);
        
        List<Person> persons = entityManager.createQuery("select p from PersonSingleTable as p").getResultList();
        for (Person p : persons) {
            System.out.println(p.getClass().getSimpleName());
        }
    }
}
