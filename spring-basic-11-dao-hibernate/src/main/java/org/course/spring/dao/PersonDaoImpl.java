package org.course.spring.dao;

import java.util.List;

import org.course.spring.beans.Hobby;
import org.course.spring.beans.Person;
import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao {
 
	@Override
    public Person create(Person person) {
        getHibernateTemplate().saveOrUpdate(person);
        return person;
    }
    
	@Override
    public Person read(Long id) {
        return (Person)getHibernateTemplate().load(Person.class, id);
    }

	@Override
    public void update(Person person) {
        getHibernateTemplate().update(person);
    }

	@Override
    public void delete(Person person) {
        getHibernateTemplate().delete(person);
    }

	@SuppressWarnings("unchecked")
	@Override
    public List<Person> findAll() {
        return (List<Person>) getHibernateTemplate().find("from Person p order by p.name");
    }
	
	@Override
	public Long countAll() {
		return (Long) (getHibernateTemplate().find("select count(*) from Person")).get(0);
	}
    

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findByName(final String name) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Person>>() {
			public List<Person> doInHibernate(Session session) {
				Query query = session.createQuery("from Person p where p.name like :name");
				query.setString("name", "%" + name + "%");
				return query.list();
			}
		});
	}

    @SuppressWarnings("unchecked")
    @Override
    public List<Hobby> findHobbiesByPerson(Long id) {
        return (List<Hobby>) getHibernateTemplate().find("select p.internalHobbies from Person p where p.id = ?",  new Object[] { id });
    }

    @Override
	public List<Hobby> findHobbiesByPersonOp2(final Long id) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Hobby>>() {
			public List<Hobby> doInHibernate(Session session) {
				Person person = (Person) session.load(Person.class, id);
				return person.getHobbies();
			}
		});
	}

	@Override
	public List<Hobby> findHobbiesByPersonOp3(Long id) {
		return ((Person) getHibernateTemplate().load(Person.class, id)).getHobbies();
	}
}
