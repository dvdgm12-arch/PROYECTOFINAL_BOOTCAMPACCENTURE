package com.hotel.repositorios.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.entidades.Habitacion;
import com.hotel.repositorios.HabitacionRepositorio;

@Repository
public class HabitacionRepositorioImpl implements HabitacionRepositorio {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Habitacion> obtenerTodas() {
        Session miSesion = sessionFactory.getCurrentSession();
        return miSesion.createQuery("from Habitacion", Habitacion.class).getResultList();
    }

    @Override
    public Habitacion obtenerPorId(int id) {
        Session miSesion = sessionFactory.getCurrentSession();
        return miSesion.get(Habitacion.class, id);
    }

    @Override
    public void guardar(Habitacion habitacion) {
    	// UTILIZAMOS MÉTODO GUARDAR TANTO PARA ACTUALIZAR O CREAR
        Session miSesion = sessionFactory.getCurrentSession();
        miSesion.saveOrUpdate(habitacion);
    }

    @Override
    public void eliminar(int id) {
        Session miSesion = sessionFactory.getCurrentSession();
        Habitacion hab = miSesion.get(Habitacion.class, id);
        if (hab != null) {
            miSesion.delete(hab);
        }
    }
}
