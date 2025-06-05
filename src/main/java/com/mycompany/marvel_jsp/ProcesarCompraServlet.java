/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.marvel_jsp;

import DAO.ComprasDAO;
import DAO.HeroeDAO;
import entities.Compras;
import entities.Heroes;
import entities.Productos;
import jakarta.persistence.EntityManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.time.LocalDateTime;

/**
 *
 * @author alumno
 */
@WebServlet(name = "ProcesarCompraServlet", urlPatterns = {"/ProcesarCompraServlet"})
public class ProcesarCompraServlet extends HttpServlet {

    private ComprasDAO comprasDao;
    private HeroeDAO heroeDao;

  @Override
    public void init() throws ServletException {
        System.out.println("1***********************************************1");
        comprasDao = new ComprasDAO();
        heroeDao = new HeroeDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String heroeIdStr = request.getParameter("heroeId");
        if (heroeIdStr == null) {

            request.setAttribute("error", "No se encontró el héroe.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        Long heroeId = Long.parseLong(heroeIdStr);
        Heroes heroe = heroeDao.obtenerHeroePorId(heroeId);

        String[] productosSeleccionados = request.getParameterValues("productos");

        System.out.println("2***********************************************2");
        
        if (productosSeleccionados == null || productosSeleccionados.length == 0) {
    request.setAttribute("error", "No se han enviado productos para comprar.");
    request.getRequestDispatcher("paginaSpiderman.jsp").forward(request, response);
    return;
        }

        List<Compras> comprasRealizadas = new ArrayList<>();

        for (String productoStr : productosSeleccionados) {
            String[] partes = productoStr.split("\\|"); // separa nombre y precio
            String nombre = partes[0];
            Double precio = Double.parseDouble(partes[1]);


            System.out.println(heroe +  nombre + precio);
            Compras compra = new Compras(heroe, nombre, precio, 1, LocalDateTime.now());
            comprasDao.insertarCompra(compra);
            comprasRealizadas.add(compra);
             request.getRequestDispatcher("paginaSpiderman.jsp").forward(request, response);
        }
   
    }
}
