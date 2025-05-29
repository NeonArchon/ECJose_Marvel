/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entities.Compras;
import entities.Heroes;
import entities.Productos;
import org.hibernate.query.Query;
import java.util.List;
import java.util.Date;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author alumno
 */
public class ComprasDAO implements IntComprasDAO{
    
    private SessionFactory sessionFactory;
    
    public ComprasDAO() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Compras.class);
            configuration.addAnnotatedClass(Heroes.class);
            configuration.addAnnotatedClass(Productos.class);
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Error al crear SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    @Override
    public void insertarCompra(Compras Compra) {
      
       Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(Compra);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        } 
        
    }
    
}
