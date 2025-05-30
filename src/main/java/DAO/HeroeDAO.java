/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Util.hibernateutil;
import entities.Heroes;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


/**
 *
 * @author alumno
 */
public class HeroeDAO implements IntHeroeDAO{
    
    private SessionFactory sessionFactory;
    
    public HeroeDAO() {
        try {
            // Configuración de Hibernate
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(entities.Heroes.class);
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Error al Conectar: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public HeroeDAO(SessionFactory sessionFactory) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void crearHeroe(Heroes Heroe) {
        Session session = hibernateutil.getSessionFactory().openSession();
        //Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(Heroe);
            //session.save(Heroe);
            tx.commit();
            System.out.println("Héroe creado exitosamente con ID: " + Heroe.getId());
        } catch (Exception e) {
            System.err.println("Error al crear héroe: " + e.getMessage());
        } finally {
            session.close();
        }
        
        
    }  

    @Override
    public List<Heroes> obtenerTodosLosHeroes() {

         Session session = sessionFactory.openSession();
    try {
        Query<Heroes> query = session.createQuery("FROM Heroes", Heroes.class);
        return query.list();
    } finally {
        session.close();
    }
        
    }
        
  }