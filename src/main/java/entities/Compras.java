/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
//import javax.persistence.*;
import java.util.Date;
import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 *
 * @author alumno
 */
@Entity
@Table(name = "compras")
public class Compras implements Serializable{
    
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "heroe_id", nullable = false)
    private Heroes heroe;

    @Column(name = "nombre_producto", nullable = false, length = 100)
    private String nombreProducto;

    @Column(name = "precio_unitario", nullable = false)
    private Double precioUnitario;

    @Column(nullable = false)
    private Integer cantidad;

   
    @Column(name = "fecha_compra", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaCompra;



    @Column(name = "precio_total", nullable = false)
    private Double precioTotal;
    
    
    // Constructor vacío
    public Compras() {

    }
    
    // Constructor con campos básicos
        /*
    public Compras(Heroes heroe, String nombreProducto, Double precioUnitario, int par) {
        this.id = id;
        this.heroe = heroe;
        this.nombreProducto = nombreProducto;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.fechaCompra = fechaCompra;
        this.precioTotal = precioTotal;
        actualizarPrecioTotal();
    }
       */
    
    public Compras(Heroes heroe, String nombreProducto, Double precioUnitario, Integer cantidad, LocalDateTime fechaCompra) {
        this.heroe = heroe;
        this.nombreProducto = nombreProducto;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.fechaCompra = fechaCompra;
        actualizarPrecioTotal();
    }


    
    //getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Heroes getHeroe() {
        return heroe;
    }

    public void setHeroe(Heroes heroe) {
        this.heroe = heroe;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
            this.precioUnitario = precioUnitario;
    actualizarPrecioTotal();
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    actualizarPrecioTotal();
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }


    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }
    
    private void actualizarPrecioTotal() {
    if (this.precioUnitario != null && this.cantidad != null) {
        this.precioTotal = this.precioUnitario * this.cantidad;
    }
    
    }
}
