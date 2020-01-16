/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.course.spring.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.course.spring.beans.Usuario;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Administrador
 */
public class UsuarioDAOImpl implements IUsuarioDAO {

    @PersistenceContext
    private EntityManager em;
    
    public List<Usuario> getListaUsuarios() throws DataAccessException {
        Query q = em.createQuery("select e from Usuario as e");
        return q.getResultList();
    }

    public Usuario addUsuario(Usuario usuario) throws DataAccessException {
        em.persist(usuario);
        return usuario;
    }

    public Usuario setUsuario(Usuario usuario) throws DataAccessException {
        em.refresh(usuario);
        return usuario;
    }

    public Usuario getUsuario(Long id) throws DataAccessException {
        return em.find(Usuario.class, id);
    }

}
