package com.hotel.repositorios.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.entidades.Reserva;
import com.hotel.repositorios.ReservaRepositorio;

@Repository
public class ReservaRepositorioImpl implements ReservaRepositorio {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Reserva> obtenerTodos() {
        Session session = sessionFactory.getCurrentSession();
        
        return session.createQuery("from Reserva", Reserva.class).list();
    }

    @Override
    public Reserva obtenerPorId(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Reserva.class, id);
    }

    @Override
    public void guardar(Reserva reserva) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(reserva);
    }

    @Override
    public void eliminar(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Reserva reserva = session.get(Reserva.class, id);
        if (reserva != null) {
            session.delete(reserva);
        }
    }
}