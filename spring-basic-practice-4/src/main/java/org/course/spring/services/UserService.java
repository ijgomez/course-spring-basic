package org.course.spring.services;

import java.util.List;

import org.course.spring.beans.User;
import org.springframework.dao.DataAccessException;

public interface UserService {

    List<User> findAll() throws DataAccessException;
    
    User create(User user) throws DataAccessException;
    
    User update(User user) throws DataAccessException;
    
    User read(Long id) throws DataAccessException;
    
    
}
