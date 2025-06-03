/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entities.Heroes;
import entities.Imagenes;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.*;
import org.hibernate.query.Query;

/**
 *
 * @author alumno
 */
public class ImagenDAO implements IntImagenDAO{
    
     private final SessionFactory sessionFactory;
    
    public ImagenDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void crearImagen(Imagenes imagen) {
      
         try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(imagen);
            tx.commit();
        }
        
    }

    @Override
    public Imagenes obtenerImagenPorId(Long id) {

         try (Session session = sessionFactory.openSession()) {
            return session.get(Imagenes.class, id);
        }
        
    }

    @Override
    public List<Imagenes> obtenerImagenesPorHeroe(Long heroeId) {
   
        try (Session session = sessionFactory.openSession()) {
            Query<Imagenes> query = session.createQuery(
                "FROM Imagenes WHERE heroe.id = :heroeId", Imagenes.class);
            query.setParameter("heroeId", heroeId);
            return query.getResultList();
        }
        
    }

    @Override
    public List<Imagenes> obtenerImagenesPorProducto(Long productoId) {
 
        try (Session session = sessionFactory.openSession()) {
            Query<Imagenes> query = session.createQuery(
                "FROM Imagenes WHERE producto.id = :productoId", Imagenes.class);
            query.setParameter("productoId", productoId);
            return query.getResultList();
        }
        
    }

    @Override
    public List<Imagenes> obtenerImagenesPorHeroe(Heroes heroe) {
        Session session = sessionFactory.openSession();
    try {
        Query<Imagenes> query = session.createQuery(
            "FROM Imagenes WHERE heroe = :heroe", Imagenes.class);
        query.setParameter("heroe", heroe);
        return query.list();
    } catch (Exception e) {
        System.err.println("Error al obtener imágenes por héroe: " + e.getMessage());
        return new ArrayList<>();
    } finally {
        session.close();
    }
    }
     
}
