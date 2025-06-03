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
public class InicializarImagenesSpiderman extends HttpServlet {

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

            // Obtener héroes existentes
            List<Heroes> heroes = heroeDao.obtenerTodosLosHeroes();
            
            if (!heroes.isEmpty()) {
                // URLs de imágenes de ejemplo (deberías usar tus propias URLs)
                //MODIFICAR PARA INCLUIR LOS LINKS DEL PROYECTO
                    Map<String, List<String>> imagenesHeroes = Map.of(
                        "Spiderman", List.of(
                            "src/resources/Imagenes/amazing_fantasy_15.jpg",
                            "src/resources/Imagenes/spiderman.png",
                            "src/resources/Imagenes/spiderman_camisa.jpg",
                            "src/resources/Imagenes/spiderman_juguete_articulado.png",
                            "src/resources/Imagenes/spiderman_marvel_rivals.png",
                            "src/resources/Imagenes/spiderman_mcu.png",
                            "src/resources/Imagenes/spiderman_ps4.jpg",
                            "src/resources/Imagenes/spiderman_sony.png"
                        )
                    );

                // Asignar imágenes a cada héroe
               for (Heroes heroe : heroes) {
    List<String> urlsImagenes = imagenesHeroes.get(heroe.getNombreHeroe());
    if (urlsImagenes != null) {
        for (String urlImagen : urlsImagenes) {
            Imagenes imagen = new Imagenes(
                null,
                urlImagen,
                heroe,
                null
            );
            imagenDao.crearImagen(imagen);
        }
    }
}
            }
        }
   }



