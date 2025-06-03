/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.marvel_jsp;

import DAO.HeroeDAO;
import DAO.ImagenDAO;
import Util.hibernateutil;
import entities.Heroes;
import entities.Imagenes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;

/**
 *
 * @author Alumno
 */
@WebServlet(name = "MostrarImagenesSpiderman", urlPatterns = {"/MostrarImagenesSpiderman"})
public class MostrarImagenesSpiderman extends HttpServlet {
    
        private ImagenDAO imagenDao;
    private HeroeDAO heroeDao;

   @Override
    public void init() throws ServletException {
        SessionFactory sessionFactory = hibernateutil.getSessionFactory();
        imagenDao = new ImagenDAO(sessionFactory);
        heroeDao = new HeroeDAO(sessionFactory);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Heroes spiderman = heroeDao.obtenerHeroePorNombre("Spiderman");
            List<Imagenes> imagenes = imagenDao.obtenerImagenesPorHeroe(spiderman);

            request.setAttribute("imagenesSpiderman", imagenes);
            request.getRequestDispatcher("spiderman.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al cargar imágenes de Spiderman");
        }
    }
}
