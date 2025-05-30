/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.marvel_jsp;

import DAO.HeroeDAO;
import DAO.ImagenDAO;
import entities.Heroes;
import entities.Imagenes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Util.hibernateutil;
import org.hibernate.*;

/**
 *
 * @author alumno
 */
@WebServlet(name = "InicializarImagenes", urlPatterns = {"/InicializarImagenes"})
public class InicializarImagenesHulk extends HttpServlet {

    private ImagenDAO imagenDao;
    private HeroeDAO heroeDao;
    
    
        @Override
    public void init() throws ServletException {
        SessionFactory sessionFactory = hibernateutil.getSessionFactory();
        imagenDao = new ImagenDAO(sessionFactory);
        heroeDao = new HeroeDAO(sessionFactory);
        inicializarImagenes();
    }

   private void inicializarImagenes() {
        try {
            // Obtener héroes existentes
            List<Heroes> heroes = heroeDao.obtenerTodosLosHeroes();
            
            if (!heroes.isEmpty()) {
                // URLs de imágenes de ejemplo (deberías usar tus propias URLs)
                //MODIFICAR PARA INCLUIR LOS LINKS DEL PROYECTO
                Map<String, String> imagenesHeroes = Map.of(
                    "Hulk", "https://ejemplo.com/hulk1.jpg",
                    "Hulk", "https://ejemplo.com/hulk2.jpg",
                    "Hulk", "https://ejemplo.com/hulk3.jpg",
                    "Hulk", "https://ejemplo.com/hulk4.jpg",
                    "Hulk", "https://ejemplo.com/hulk5.jpg",
                    "Hulk", "https://ejemplo.com/hulk6.jpg",
                    "Hulk", "https://ejemplo.com/hulk7.jpg"
                );

                // Asignar imágenes a cada héroe
                for (Heroes heroe : heroes) {
                    String urlImagen = imagenesHeroes.get(heroe.getNombreHeroe());
                    if (urlImagen != null) {
                        Imagenes imagen = new Imagenes(
                            null, 
                            urlImagen, 
                            heroe, 
                            null
                        );
                        imagenDao.crearImagen(imagen);
                    }
                }
                System.out.println("🔥 Imágenes inicializadas correctamente");
            }
        } catch (Exception e) {
            System.err.println("Error al inicializar imágenes:");
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

}

