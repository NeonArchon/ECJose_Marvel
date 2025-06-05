/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.ArrayList;
import javax.persistence.*;
import java.util.List;
/**
 *
 * @author alumno
 */
@Entity
@Table(name = "productos")
public class Productos {
    
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id;
    
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    
    @Column(name = "precio", nullable = false)
    private Double precio;
    
    
    @OneToMany(mappedBy = "producto")
    private List<Compras> compras; 
    
    //constructor vacio
    public Productos() {
    }
    
    //constructor con campos
    public Productos(Long id, String nombre, Double precio, List<Compras> compras) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.compras = compras;
    }

    
    //constructor adicional
    public Productos(String nombre, Double precio) {
    this.nombre = nombre;
    this.precio = precio;
    this.compras = new ArrayList<>();
}

    //getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public List<Compras> getCompras() {
        return compras;
    }

    public void setCompras(List<Compras> compras) {
        this.compras = compras;
    }
       
}
