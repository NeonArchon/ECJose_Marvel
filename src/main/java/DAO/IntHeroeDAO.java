/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import entities.Heroes;
import java.util.List;

/**
 *
 * @author alumno
 */
public interface IntHeroeDAO {
    
     void crearHeroe (Heroes Heroe);
     
     public List<Heroes> obtenerTodosLosHeroes();
    
     Heroes obtenerHeroePorNombre(String nombre);
}
