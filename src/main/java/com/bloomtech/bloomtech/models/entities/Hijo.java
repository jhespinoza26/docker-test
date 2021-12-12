package com.bloomtech.bloomtech.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Table(name="hijo")
@Entity
public class Hijo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id_hijo")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional=false)
    private long id_hijo;

    @Column(name="nombre", length = 50)
    private String nombre;

    @Column(name="fecha_creacion", length = 50)
    private String fecha_creacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hijo_id")
    private Usuario hijo_id;

    @JoinColumn(name="padre_id", referencedColumnName="id_usuario")
    @ManyToOne
    private Usuario padre_id;

    public Hijo() {
        super();
    }

    public Hijo(long id_hijo) {
        this.id_hijo = id_hijo;
    }

    public Hijo(long id_hijo, String nombre, String fecha_creacion, Usuario hijo_id, Usuario padre_id) {
        this.id_hijo = id_hijo;
        this.nombre = nombre;
        this.fecha_creacion = fecha_creacion;
        this.hijo_id = hijo_id;
        this.padre_id = padre_id;
    }

    public long getId_hijo() {
        return id_hijo;
    }

    public void setId_hijo(long id_hijo) {
        this.id_hijo = id_hijo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "Hijo{" +
                "id_hijo=" + id_hijo +
                ", nombre='" + nombre + '\'' +
                ", fecha_creacion='" + fecha_creacion + '\'' +
                ", hijo_id=" + hijo_id +
                ", padre_id=" + padre_id +
                '}';
    }
}
