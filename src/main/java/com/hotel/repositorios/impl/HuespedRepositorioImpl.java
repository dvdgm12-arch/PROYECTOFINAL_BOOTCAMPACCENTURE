package com.hotel.repositorios.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.entidades.Huesped;
import com.hotel.repositorios.HuespedRepositorio;

@Repository
public class HuespedRepositorioImpl implements HuespedRepositorio {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Huesped> obtenerTodas() {
        Session miSesion = sessionFactory.getCurrentSession();
        return miSesion.createQuery("from Huesped", Huesped.class).getResultList();
    }

    @Override
    public Huesped obtenerPorId(Integer id) {
        Session miSesion = sessionFactory.getCurrentSession();
        return miSesion.get(Huesped.class, id);
    }

    @Override
    public void guardar(Huesped huesped) {
        // UTILIZAMOS MÉTODO GUARDAR TANTO PARA ACTUALIZAR O CREAR
        Session miSesion = sessionFactory.getCurrentSession();
        miSesion.saveOrUpdate(huesped);
    }

    @Override
    public void eliminar(Integer id) {
        Session miSesion = sessionFactory.getCurrentSession();
        Huesped hus = miSesion.get(Huesped.class, id);
        if (hus != null) {
            miSesion.delete(hus);
        }
    }

    @Override
    public List<Huesped> buscar(String nombre, String dni) {
        Session miSesion = sessionFactory.getCurrentSession();
        
        // CONSTRUCCIÓN DINÁMICA
        StringBuilder hql = new StringBuilder("FROM Huesped h WHERE 1=1");
        
        if (nombre != null && !nombre.trim().isEmpty()) {           
            hql.append(" AND (h.nombre LIKE :nombre OR h.apellidos LIKE :nombre)");
        }
        if (dni != null && !dni.trim().isEmpty()) {
            hql.append(" AND h.dniPasaporte LIKE :dni");
        }

        Query<Huesped> laQuery = miSesion.createQuery(hql.toString(), Huesped.class);

        // PARÁMETROS
        if (nombre != null && !nombre.trim().isEmpty()) {
            laQuery.setParameter("nombre", "%" + nombre.trim().toLowerCase() + "%");
        }
        if (dni != null && !dni.trim().isEmpty()) {
            laQuery.setParameter("dni", "%" + dni.trim().toLowerCase() + "%");
        }

        return laQuery.getResultList();
    }
}

