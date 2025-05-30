/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "imagenes")
public class Imagenes {
    
    //atributoa
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String url;
    
    /*
    @Column(nullable = false)
    private String tipo; // "perfil", "galeria", "producto", etc.
    */
    
    @ManyToOne
    @JoinColumn(name = "heroe_id")
    private Heroes heroe;
    
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Productos producto;
    
    //construcotor vacio
    public Imagenes() {
    }
       
    //constrcutor con campos
    public Imagenes(Long id, String url,/* String tipo,*/ Heroes heroe, Productos producto) {
        this.id = id;
        this.url = url;
       // this.tipo = tipo;
        this.heroe = heroe;
        this.producto = producto;  
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /*
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    */

    public Heroes getHeroe() {
        return heroe;
    }

    public void setHeroe(Heroes heroe) {
        this.heroe = heroe;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }
    
    
    
}
