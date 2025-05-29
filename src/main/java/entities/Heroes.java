/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
/**
 *
 * @author alumno
 */

@Entity
@Table(name = "heroes")
public class Heroes implements Serializable {
    
    // Atributos de Usuario
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_heroe")
    private Long id;
    
    @Column(name = "nombre_usuario", unique = true, nullable = false, length = 50)
    private String nombreUsuario;
    
    @Column(name = "contrasena", nullable = false, length = 100)
    private String contrasena;

    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;
    
    // Atributos que podrían venir de Heroe (ajusta según los atributos reales de Heroe)
    @Column(name = "nombre_heroe", length = 100)
    private String nombreHeroe;
    

    //cosntructor vacio
    public Heroes() {
    }
    
    //constructor con campos

    public Heroes(Long id, String nombreUsuario, String contrasena, String email, String nombreHeroe) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.email = email;
        this.nombreHeroe = nombreHeroe;
    }

    //geters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreHeroe() {
        return nombreHeroe;
    }

    public void setNombreHeroe(String nombreHeroe) {
        this.nombreHeroe = nombreHeroe;
    }

    
}
