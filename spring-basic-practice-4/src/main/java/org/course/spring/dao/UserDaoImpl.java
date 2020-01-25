package org.course.spring.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.course.spring.beans.User;
import org.springframework.dao.DataAccessException;

public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;
    
    @SuppressWarnings("unchecked")
    @Override
	public List<User> findAll() throws DataAccessException {
        Query q = em.createQuery("select e from User as e");
        return q.getResultList();
    }

    @Override
    public User create(User user) throws DataAccessException {
        em.persist(user);
        return user;
    }

    @Override
    public User update(User user) throws DataAccessException {
        em.refresh(user);
        return user;
    }

    @Override
    public User read(Long id) throws DataAccessException {
        return em.find(User.class, id);
    }

}
