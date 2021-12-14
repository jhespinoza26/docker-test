package com.bloomtech.bloomtech.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;


import javax.persistence.Id;

@Table(name="red")
@Entity(name="red")
public class Red implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id_red")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional=false)
    private Long id_red;

    @Column(name="nombre", length = 50)
    private String nombre;

    @Column(name="nivel", length = 50)
    private long nivel;

    @Column(name="fecha_creacion", length = 50)
    private String fecha_creacion;

    @JoinColumn(name = "hijo_id")
    @OneToOne(fetch = FetchType.EAGER)
    private Usuario hijo_id;

    @JoinColumn(name = "padre_id")
    @OneToOne(fetch = FetchType.EAGER)
    private Usuario padre_id;

    public Red() {
        super();
    }

    public Red(Long id_red) {
        this.id_red = id_red;
    }

    public Red(Long id_red, String nombre, long nivel, String fecha_creacion, Usuario hijo_id, Usuario padre_id) {
        this.id_red = id_red;
        this.nombre = nombre;
        this.nivel = nivel;
        this.fecha_creacion = fecha_creacion;
        this.hijo_id = hijo_id;
        this.padre_id = padre_id;
    }

    public Long getId_red() {
        return id_red;
    }

    public void setId_red(Long id_red) {
        this.id_red = id_red;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getNivel() {
        return nivel;
    }

    public void setNivel(long nivel) {
        this.nivel = nivel;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Usuario getHijo_id() {
        return hijo_id;
    }

    public void setHijo_id(Usuario hijo_id) {
        this.hijo_id = hijo_id;
    }

    public Usuario getPadre_id() {
        return padre_id;
    }

    public void setPadre_id(Usuario padre_id) {
        this.padre_id = padre_id;
    }
}
