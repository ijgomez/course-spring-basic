package org.course.spring.services;

import java.util.List;

import org.course.spring.beans.User;
import org.course.spring.dao.UserDao;
import org.springframework.dao.DataAccessException;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@Override
	public List<User> findAll() throws DataAccessException {
		return userDao.findAll();
	}

	@Override
	public User create(User user) throws DataAccessException {
		return userDao.create(user);
	}

	@Override
	public User update(User user) throws DataAccessException {
		return userDao.update(user);
	}

	@Override
	public User read(Long id) throws DataAccessException {
		return userDao.read(id);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
