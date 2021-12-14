package com.bloomtech.bloomtech.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Table(name="Rango")
@Entity
public class Rango implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id_rango")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Basic(optional=false)
    private long id_rango;

    @Column(name="nivel_rango", length = 50)
    private Double nivel_rango;

    @Column(name="nombre_rango", length = 50)
    private String nombre_rango;

    @Column(name="porcentage_rango", length = 50)
    private Double porcentaje_rango;

    @Column(name="numero_red", length = 50)
    private Double numero_red;

    @Column(name="minimo_red", length = 50)
    private Double minimo_red;

    @Column(name="maximo_red", length = 50)
    private Double maximo_red;

    @JsonIgnore
    @OneToMany(mappedBy="usuario", fetch=FetchType.LAZY)
    private List<Usuario> id_usuario;

    public Rango() {super();}

    public Rango(long id_rango) {this.id_rango=id_rango;}

    public Rango(long id_rango, Double nivel_rango, String nombre_rango, Double porcentaje_rango, Double numero_red, Double minimo_red, Double maximo_red, List<Usuario> id_usuario) {
        this.id_rango = id_rango;
        this.nivel_rango = nivel_rango;
        this.nombre_rango = nombre_rango;
        this.porcentaje_rango = porcentaje_rango;
        this.numero_red = numero_red;
        this.minimo_red = minimo_red;
        this.maximo_red = maximo_red;
        this.id_usuario = id_usuario;
    }

    public long getId_rango() {
        return id_rango;
    }

    public void setId_rango(long id_rango) {
        this.id_rango = id_rango;
    }

    public Double getNivel_rango() {
        return nivel_rango;
    }

    public void setNivel_rango(Double nivel_rango) {
        this.nivel_rango = nivel_rango;
    }

    public String getNombre_rango() {
        return nombre_rango;
    }

    public void setNombre_rango(String nombre_rango) {
        this.nombre_rango = nombre_rango;
    }

    public Double getPorcentaje_rango() {
        return porcentaje_rango;
    }

    public void setPorcentaje_rango(Double porcentaje_rango) {
        this.porcentaje_rango = porcentaje_rango;
    }

    public Double getNumero_red() {
        return numero_red;
    }

    public void setNumero_red(Double numero_red) {
        this.numero_red = numero_red;
    }

    public Double getMinimo_red() {
        return minimo_red;
    }

    public void setMinimo_red(Double minimo_red) {
        this.minimo_red = minimo_red;
    }

    public Double getMaximo_red() {
        return maximo_red;
    }

    public void setMaximo_red(Double maximo_red) {
        this.maximo_red = maximo_red;
    }

    public List<Usuario> getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(List<Usuario> id_usuario) {
        this.id_usuario = id_usuario;
    }
}
