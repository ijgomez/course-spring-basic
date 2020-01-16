/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.course.spring.services;

import java.util.List;

import org.course.spring.beans.Usuario;
import org.course.spring.dao.IUsuarioDAO;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Administrador
 */
public class UsuarioServiceImpl implements UsuarioService {

    private IUsuarioDAO usuarioDAO;
    
    public List<Usuario> getListaUsuarios() throws DataAccessException {
        return usuarioDAO.getListaUsuarios();
    }

    public Usuario addUsuario(Usuario usuario) throws DataAccessException {
        return usuarioDAO.addUsuario(usuario);
    }

    public Usuario setUsuario(Usuario usuario) throws DataAccessException {
        return usuarioDAO.setUsuario(usuario);
    }

    public Usuario getUsuario(Long id) throws DataAccessException {
        return usuarioDAO.getUsuario(id);
    }

    public IUsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

}
