package com.hotel.repositorios.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.entidades.Incidencia;
import com.hotel.repositorios.IncidenciaRepositorio;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 

@Repository
public class IncidenciaRepositorioImpl implements IncidenciaRepositorio {

    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Obtener todas.
     *
     * @return the list
     */
    @Override
    public List<Incidencia> obtenerTodas() {
        Session miSesion = sessionFactory.getCurrentSession();
        return miSesion.createQuery("select i from Incidencia i join fetch i.habitacion", Incidencia.class).getResultList();
    }

    /**
     * Obtener por id.
     *
     * @param id the id
     * @return the incidencia
     */
    @Override
    public Incidencia obtenerPorId(int id) {
        Session miSesion = sessionFactory.getCurrentSession();
        return miSesion.get(Incidencia.class, id);
    }

    /**
     * Guardar.
     *
     * @param incidencia the incidencia
     */
    @Override
    public void guardar(Incidencia incidencia) {
        Session miSesion = sessionFactory.getCurrentSession();
        miSesion.saveOrUpdate(incidencia);
    }

    /**
     * Eliminar.
     *
     * @param id the id
     */
    @Override
    public void eliminar(int id) {
        Session miSesion = sessionFactory.getCurrentSession();
        Incidencia inc = miSesion.get(Incidencia.class, id);
        if (inc != null) {
            miSesion.delete(inc);
        }
    }
    
    /**
     * Buscar.
     *
     * @param numeroHabitacion the numero habitacion
     * @param estado the estado
     * @return the list
     */
    @Override
    public List<Incidencia> buscar(Integer numeroHabitacion, String estado) {
        Session miSesion = sessionFactory.getCurrentSession();
        
        StringBuilder hql = new StringBuilder("FROM Incidencia i WHERE 1=1");
        
        if (numeroHabitacion != null) {
            hql.append(" AND i.habitacion.numero = :numero");
        }
        if (estado != null && !estado.trim().isEmpty()) {
            hql.append(" AND i.estado = :estado");
        }

        Query<Incidencia> laQuery = miSesion.createQuery(hql.toString(), Incidencia.class);

        if (numeroHabitacion != null) {
            laQuery.setParameter("numero", numeroHabitacion);
        }
        if (estado != null && !estado.trim().isEmpty()) {
            laQuery.setParameter("estado", estado);
        }

        return laQuery.getResultList();
    }
}
