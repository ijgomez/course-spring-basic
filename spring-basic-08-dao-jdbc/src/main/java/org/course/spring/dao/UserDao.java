package org.course.spring.dao;

import java.util.Collection;

import org.course.spring.beans.User;
import org.course.spring.exceptions.UserException;
import org.springframework.dao.DataAccessException;

public interface UserDao {
	
	void insertarUser(User user) throws DataAccessException, UserException;

	void actualizarUser(User user) throws DataAccessException;

	void borrarUser(User user) throws DataAccessException;

	Integer contarUsers() throws DataAccessException;

	Integer contarUsersUsandoParametros(String name) throws DataAccessException;

	User encontrarUser(Integer id) throws DataAccessException;

	Collection<User> encontrarTodos() throws DataAccessException;

	Integer insertarUserDevolviendoLaClavePrimaria(User user) throws DataAccessException;
	
}
