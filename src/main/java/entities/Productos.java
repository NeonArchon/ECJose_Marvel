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
    
    @Column(name = "descripcion", length = 500)
    private String descripcion;
    
    @Column(name = "precio", nullable = false)
    private Double precio;
    
    @Column(name = "imagen_url", length = 255)
    private String imagenUrl;
    
    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo; // "camiseta", "taza", "poster", etc.
    
    @OneToMany(mappedBy = "producto")
    private List<Compras> compras; 
    
    //constructor vacio
    public Productos() {
    }
    
    //constructor con campos
    public Productos(Long id, String nombre, String descripcion, Double precio, String imagenUrl, String tipo, Heroes HeroeRelacionado, List<Compras> compras) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagenUrl = imagenUrl;
        this.tipo = tipo;
        this.compras = compras;
    }
    
    //constructor adicional
    public Productos(String nombre, String descripcion, Double precio, String tipo) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.precio = precio;
    this.tipo = tipo;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public List<Compras> getCompras() {
        return compras;
    }

    public void setCompras(List<Compras> compras) {
        this.compras = compras;
    }

    
}
