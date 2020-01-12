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
    public Integer contarUsers() throws DataAccessException {
        return getJdbcTemplate().queryForInt("select count(*) from personas");
    }

	@Override
    public Integer contarUsersUsandoParametros(String nombre) throws DataAccessException {
        return getJdbcTemplate().queryForInt("select count(*) from personas where nombre like ?", new Object[]{"%"+nombre+"%"});
    }

	@Override
    public User encontrarUser(Integer id) throws DataAccessException {
        User persona = (User) getJdbcTemplate().queryForObject("select * from personas where id = ?",new Object[]{id}, new UserRowMapper());
        return persona;
    }

	@SuppressWarnings("unchecked")
	@Override
    public Collection<User> encontrarTodos() throws DataAccessException {
        return getJdbcTemplate().query("select * from personas", new UserRowMapper());
    }

	@Override
    public void insertarUser(User persona) throws DataAccessException, UserException {
        getJdbcTemplate().update("insert into personas (nombre) values (?)", new Object[]{persona.getName()});
    }

	@Override
    public void actualizarUser(User persona) throws DataAccessException {
        getJdbcTemplate().update("update personas set nombre = ? where id = ?", new Object[]{persona.getName(),persona.getId()});
    }

	@Override
    public void borrarUser(User persona) throws DataAccessException {
        getJdbcTemplate().update("delete from personas where id = ?", new Object[]{persona.getId()});
    }

	@Override
    public Integer insertarUserDevolviendoLaClavePrimaria(final User persona) throws DataAccessException {
        KeyHolder holder = new GeneratedKeyHolder();
        getJdbcTemplate().update(new PreparedStatementCreator() {

        	@Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("insert into personas (nombre) values (?)", new String[] {"id"});
                ps.setString(1, persona.getName());
                return ps;                
            }
            
        },holder);
        return  holder.getKey().intValue();
    }
    
    private static final class UserRowMapper implements RowMapper {

    	@Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            UserImpl persona = new UserImpl();
            persona.setId(resultSet.getInt("id"));
            persona.setName(resultSet.getString("nombre"));
            return persona;
        }
    	
    }
}
