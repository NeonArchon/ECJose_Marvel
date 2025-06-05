package com.mycompany.marvel_jsp;

import DAO.HeroeDAO;
import entities.Heroes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
@WebServlet(name = "InicializarHeroes", urlPatterns = {"/InicializarHeroes"})
public class InicializarHeroes extends HttpServlet {

      @Override
    public void init() throws ServletException {
        // Este método se ejecuta al iniciar la aplicación
        InicializarHeroes();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirigir al JSP principal
        response.sendRedirect("index.jsp");
    }

    public void InicializarHeroes(){
  HeroeDAO heroeDao = new HeroeDAO(); // Cambiado el nombre de la variable para evitar conflicto
    

            List<Heroes> heroesIniciales = new ArrayList<>();
            
            //Spiderman
            heroesIniciales.add(new Heroes(
                    null, 
                    "vecino_amigable", 
                    "PBP12345", 
                    "spidey@gmail.com", 
                    "Spiderman" 
            ));
            System.out.println(heroesIniciales.get(0).toString());
            //Hulk
            heroesIniciales.add(new Heroes(
                    null, 
                    "hombre_verde", 
                    "vengadormasfuerte", 
                    "BruceGamma@gmail.com", 
                    "Hulk"
            ));
            System.out.println(heroesIniciales.get(1).toString());
                     
            // Guardar todos los héroes
            for (Heroes heroe : heroesIniciales) {
                heroeDao.crearHeroe(heroe); // Usando heroeDao en lugar de heroeDAO
               
            }
            
            
        }
    


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String usuario = request.getParameter("nombreUsuario");
        String email = request.getParameter("email");
        String contrasena = request.getParameter("contrasena");
        
System.out.println("***********************************************");
        // Aquí haces la validación (esto es solo un ejemplo)
        if ("vecino_amigable".equals(usuario) && "spidey@gmail.com".equals(email) && "PBP12345".equals(contrasena)) {
            // Login exitoso, redirige a spiderman.jsp
            
            response.sendRedirect("paginaSpiderman.jsp");
        } else {
            // Login fallido, vuelve a index.jsp con mensaje de error
            request.setAttribute("error", "Usuario o contraseña incorrectos");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Ingresar los datos de los heroes en la base de datos";
    }// </editor-fold>
}
