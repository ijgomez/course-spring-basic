/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.course.spring.dao;

import java.util.List;

import org.course.spring.beans.Usuario;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Administrador
 */
public interface IUsuarioDAO {

    List<Usuario> getListaUsuarios() throws DataAccessException;
    
    Usuario addUsuario(Usuario usuario) throws DataAccessException;
    
    Usuario setUsuario(Usuario usuario) throws DataAccessException;
    
    Usuario getUsuario(Long id) throws DataAccessException;
    
    
}
