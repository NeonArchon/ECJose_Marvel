/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import javax.persistence.*;
import java.util.Date;
/**
 *
 * @author alumno
 */
@Entity
@Table(name = "compras")
public class Compras {
    
    //atributos
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "heroe_id", nullable = false)
    private Heroes heroe;
    
    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Productos producto;
    
    @Column(nullable = false)
    private Integer cantidad;
    
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCompra;
    
    @Column(nullable = false)
    private Double precioTotal;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoCompra estado; // "PENDIENTE", "COMPLETADA", "CANCELADA"
    
    // Constructor vacío
    public Compras() {
        this.fechaCompra = new Date();
        this.estado = EstadoCompra.PENDIENTE;
    }
    
    // Constructor con campos básicos
    public Compras(Heroes heroe, Productos producto, Integer cantidad, Double precioTotal) {
        this();
        this.heroe = heroe;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
    }
    
    // Enum para estado de compra
    public enum EstadoCompra {
        PENDIENTE, COMPLETADA, CANCELADA
    }

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

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public EstadoCompra getEstado() {
        return estado;
    }

    public void setEstado(EstadoCompra estado) {
        this.estado = estado;
    }
   
    
    
    
}
