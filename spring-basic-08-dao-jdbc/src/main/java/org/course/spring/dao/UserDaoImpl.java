package org.course.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.course.spring.beans.User;
import org.course.spring.beans.UserImpl;
import org.course.spring.exceptions.UserException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao{

	@Override
    public Integer countAll() throws DataAccessException {
        return getJdbcTemplate().queryForObject("select count(*) from user", Integer.class);
    }

	@Override
    public Integer countByName(String nombre) throws DataAccessException {
        return getJdbcTemplate().queryForObject("select count(*) from user where name like ?", new Object[]{"%"+nombre+"%"}, Integer.class);
    }

	@Override
    public User read(Integer id) throws DataAccessException {
        User persona = (User) getJdbcTemplate().queryForObject("select * from user where id = ?",new Object[]{id}, new UserRowMapper());
        return persona;
    }

	@Override
    public Collection<User> findAll() throws DataAccessException {
        return getJdbcTemplate().query("select * from user", new UserRowMapper());
    }

	@Override
    public void create(User persona) throws DataAccessException, UserException {
        getJdbcTemplate().update("insert into user (name) values (?)", new Object[]{persona.getName()});
    }

	@Override
    public void update(User persona) throws DataAccessException {
        getJdbcTemplate().update("update user set name = ? where id = ?", new Object[]{persona.getName(),persona.getId()});
    }

	@Override
    public void delete(User persona) throws DataAccessException {
        getJdbcTemplate().update("delete from user where id = ?", new Object[]{persona.getId()});
    }

	@Override
    public Integer createByObject(final User persona) throws DataAccessException {
        KeyHolder holder = new GeneratedKeyHolder();
        getJdbcTemplate().update(new PreparedStatementCreator() {

        	@Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("insert into user (name) values (?)", new String[] {"id"});
                ps.setString(1, persona.getName());
                return ps;                
            }
            
        },holder);
        return  holder.getKey().intValue();
    }
    
    private static final class UserRowMapper implements RowMapper<User> {

    	@Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
    		User persona = new UserImpl();
            persona.setId(resultSet.getInt("id"));
            persona.setName(resultSet.getString("name"));
            return persona;
        }
    	
    }
}
