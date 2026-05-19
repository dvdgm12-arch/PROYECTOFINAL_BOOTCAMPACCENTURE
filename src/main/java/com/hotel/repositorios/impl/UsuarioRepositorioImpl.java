package com.hotel.repositorios.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hotel.entidades.Usuario;
import com.hotel.repositorios.UsuarioRepositorio;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 

@Repository
public class UsuarioRepositorioImpl implements UsuarioRepositorio {

    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Obtener por username.
     *
     * @param username the username
     * @return the usuario
     */
    @Override
    public Usuario obtenerPorUsername(String username) {
        Session miSesion = sessionFactory.getCurrentSession();
        Query<Usuario> laQuery = miSesion.createQuery("from Usuario where username=:elNombre", Usuario.class);
        laQuery.setParameter("elNombre", username);
        
        try {
            return laQuery.getSingleResult();
        } catch (Exception e) {
            return null; 
        }
    }

    /**
     * Actualizar.
     *
     * @param usuario the usuario
     */
    @Override
    public void actualizar(Usuario usuario) {
        sessionFactory.getCurrentSession().update(usuario);
    }

    /**
     * Obtener por id.
     *
     * @param id the id
     * @return the usuario
     */
    @Override
    public Usuario obtenerPorId(Integer id) {
        return sessionFactory.getCurrentSession().get(Usuario.class, id);
    }
}


