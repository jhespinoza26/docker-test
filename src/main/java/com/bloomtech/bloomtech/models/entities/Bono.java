package com.bloomtech.bloomtech.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Table(name="Bono")
@Entity
public class Bono implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id_bono")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Basic(optional=false)
    private long id_bono;

    @Column(name="nivel_bono", length = 50)
    private Double nivel_bono;

    @Column(name="nombre_bono", length = 50)
    private String nombre_bono;

    @Column(name="porcentaje_bono", length = 50)
    private Double porcentaje_bono;

    @JsonIgnore
    @OneToMany(mappedBy="id_premio", fetch=FetchType.LAZY)
    private List<Premio> id_premio;

    public Bono(){super();}

    public Bono(long id_bono){this.id_bono = id_bono;}

    public Bono(long id_bono, Double nivel_bono, String nombre_bono, Double porcentaje_bono, List<Premio> id_premio) {
        this.id_bono = id_bono;
        this.nivel_bono = nivel_bono;
        this.nombre_bono = nombre_bono;
        this.porcentaje_bono = porcentaje_bono;
        this.id_premio = id_premio;
    }

    public long getId_bono() {
        return id_bono;
    }

    public void setId_bono(long id_bono) {
        this.id_bono = id_bono;
    }

    public Double getNivel_bono() {
        return nivel_bono;
    }

    public void setNivel_bono(Double nivel_bono) {
        this.nivel_bono = nivel_bono;
    }

    public String getNombre_bono() {
        return nombre_bono;
    }

    public void setNombre_bono(String nombre_bono) {
        this.nombre_bono = nombre_bono;
    }

    public Double getPorcentaje_bono() {
        return porcentaje_bono;
    }

    public void setPorcentaje_bono(Double porcentaje_bono) {
        this.porcentaje_bono = porcentaje_bono;
    }

    public List<Premio> getId_premio() {
        return id_premio;
    }

    public void setId_premio(List<Premio> id_premio) {
        this.id_premio = id_premio;
    }
}
