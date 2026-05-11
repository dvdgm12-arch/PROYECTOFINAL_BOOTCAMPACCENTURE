package com.hotel.repositorios.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.entidades.Usuario;
import com.hotel.repositorios.UsuarioRepositorio;

@Repository
public class UsuarioRepositorioImpl implements UsuarioRepositorio {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Usuario obtenerPorUsername(String username) {
        Session miSesion = sessionFactory.getCurrentSession();
        
       
        Query<Usuario> laQuery = miSesion.createQuery("from Usuario where username=:elNombre", Usuario.class);
        laQuery.setParameter("elNombre", username);
        
        Usuario user = null;
        try {
            user = laQuery.getSingleResult();
        } catch (Exception e) {
            user = null;
        }
        
        return user;
    }

    @Override
    public void actualizar(Usuario usuario) {
        Session miSesion = sessionFactory.getCurrentSession();
        miSesion.update(usuario);
    }

    @Override
    public Usuario obtenerPorId(Integer id) {
        Session miSesion = sessionFactory.getCurrentSession();
        return miSesion.get(Usuario.class, id);
    }
}


