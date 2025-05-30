/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import entities.Imagenes;
import java.util.List;

/**
 *
 * @author alumno
 */
public interface IntImagenDAO {
    
        void crearImagen(Imagenes imagen);
        
        Imagenes obtenerImagenPorId(Long id);
        
        List<Imagenes> obtenerImagenesPorHeroe(Long heroeId);
        
        List<Imagenes> obtenerImagenesPorProducto(Long productoId);
    
}
