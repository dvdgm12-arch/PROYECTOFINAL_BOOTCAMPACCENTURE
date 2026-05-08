package com.hotel.repositorios.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    
}

