/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entities.Compras;
import entities.Heroes;
import entities.Productos;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.*;
import org.hibernate.query.Query;

/**
 *
 * @author alumno
 */
public class ProductosDAO implements IntProductosDAO{
    
        private SessionFactory sessionFactory;
    
    public ProductosDAO() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Productos.class);
            configuration.addAnnotatedClass(Heroes.class);
            configuration.addAnnotatedClass(Compras.class);
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Error al crear SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    @Override
    public void insertarProducto(Productos producto) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(producto);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void eliminarProducto(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Productos producto = session.get(Productos.class, id);
            if (producto != null) {
                session.delete(producto);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Productos buscarProducto(Long id) {
               Session session = sessionFactory.openSession();
        try {
            return session.get(Productos.class, id);
        } finally {
            session.close();
        }
    }

    @Override
    public List<Productos> buscarProductosPorUsuarioHeroe(Long usuarioHeroeId) {
         Session session = sessionFactory.openSession();
        try {
            Query<Productos> query = session.createQuery(
                "FROM Productos p WHERE p.HeroeRelacionado.id = :usuarioHeroeId", Productos.class);
            query.setParameter("usuarioHeroeId", usuarioHeroeId);
            return query.list();
        } finally {
            session.close();
        }
    }
    
}
