package com.hotel.repositorios.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.entidades.Habitacion;
import com.hotel.repositorios.HabitacionRepositorio;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 

@Repository
public class HabitacionRepositorioImpl implements HabitacionRepositorio {

    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Obtener todas.
     *
     * @return the list
     */
    @Override
    public List<Habitacion> obtenerTodas() {
        Session miSesion = sessionFactory.getCurrentSession();
        return miSesion.createQuery("from Habitacion", Habitacion.class).getResultList();
    }

    /**
     * Obtener por id.
     *
     * @param id the id
     * @return the habitacion
     */
    @Override
    public Habitacion obtenerPorId(int id) {
        Session miSesion = sessionFactory.getCurrentSession();
        return miSesion.get(Habitacion.class, id);
    }

    /**
     * Guardar.
     *
     * @param habitacion the habitacion
     */
    @Override
    public void guardar(Habitacion habitacion) {
    	// UTILIZAMOS MÉTODO GUARDAR TANTO PARA ACTUALIZAR O CREAR
        Session miSesion = sessionFactory.getCurrentSession();
        miSesion.saveOrUpdate(habitacion);
    }

    /**
     * Eliminar.
     *
     * @param id the id
     */
    @Override
    public void eliminar(int id) {
        Session miSesion = sessionFactory.getCurrentSession();
        Habitacion hab = miSesion.get(Habitacion.class, id);
        if (hab != null) {
            miSesion.delete(hab);
        }
    }
    
    /**
     * Buscar.
     *
     * @param numero the numero
     * @param tipo the tipo
     * @return the list
     */
    @Override
    public List<Habitacion> buscar(Integer numero, String tipo) {
        Session miSesion = sessionFactory.getCurrentSession();
        StringBuilder hql = new StringBuilder("FROM Habitacion h WHERE 1=1");
        
        if (numero != null) {
            hql.append(" AND h.numero = :numero");
        }
        if (tipo != null && !tipo.trim().isEmpty()) {
            hql.append(" AND lower(h.tipo) LIKE :tipo");
        }

        Query<Habitacion> laQuery = miSesion.createQuery(hql.toString(), Habitacion.class);

        if (numero != null) {
            laQuery.setParameter("numero", numero);
        }
        if (tipo != null && !tipo.trim().isEmpty()) {
            laQuery.setParameter("tipo", "%" + tipo.trim().toLowerCase() + "%");
        }

        return laQuery.getResultList();
    }
}
