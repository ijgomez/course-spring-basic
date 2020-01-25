package org.course.spring.dao;

import java.util.Collection;

import org.course.spring.beans.User;
import org.course.spring.exceptions.UserException;
import org.springframework.dao.DataAccessException;

public interface UserDao {
	
	void create(User user) throws DataAccessException, UserException;

	void update(User user) throws DataAccessException;

	void delete(User user) throws DataAccessException;

	Integer countAll() throws DataAccessException;

	Integer countByName(String name) throws DataAccessException;

	User read(Integer id) throws DataAccessException;

	Collection<User> findAll() throws DataAccessException;

	Integer createByObject(User user) throws DataAccessException;
	
}
