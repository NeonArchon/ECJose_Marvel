/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import entities.Productos;
import java.util.List;

/**
 *
 * @author alumno
 */
public interface IntProductosDAO {
    
    void insertarProducto(Productos producto);
    
    void eliminarProducto(Long id);
    
    Productos buscarProducto(Long id);
    
    List<Productos> buscarProductosPorUsuarioHeroe(Long usuarioHeroeId);
    
}
