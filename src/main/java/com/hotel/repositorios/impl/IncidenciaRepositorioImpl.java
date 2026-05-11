package com.hotel.repositorios.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.entidades.Incidencia;
import com.hotel.repositorios.IncidenciaRepositorio;

@Repository
public class IncidenciaRepositorioImpl implements IncidenciaRepositorio {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Incidencia> obtenerTodas() {
        Session miSesion = sessionFactory.getCurrentSession();
        // Usamos JOIN FETCH para cargar la habitación asociada de golpe y evitar errores en la vista
        return miSesion.createQuery("select i from Incidencia i join fetch i.habitacion", Incidencia.class).getResultList();
    }

    @Override
    public Incidencia obtenerPorId(int id) {
        Session miSesion = sessionFactory.getCurrentSession();
        return miSesion.get(Incidencia.class, id);
    }

    @Override
    public void guardar(Incidencia incidencia) {
        Session miSesion = sessionFactory.getCurrentSession();
        miSesion.saveOrUpdate(incidencia);
    }

    @Override
    public void eliminar(int id) {
        Session miSesion = sessionFactory.getCurrentSession();
        Incidencia inc = miSesion.get(Incidencia.class, id);
        if (inc != null) {
            miSesion.delete(inc);
        }
    }
}
