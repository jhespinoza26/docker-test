package com.bloomtech.bloomtech.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name="Ganancia")
@Entity
public class Ganancia implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id_ganancia")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Basic(optional=false)
    private long id_ganancia;

    @Column(name="fecha_ganancia")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fecha_ganancia;

    @Column(name="g_bono", length = 50)
    private Double g_bono;

    @Column(name="g_rango", length = 50)
    private Double g_rango;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @NotNull
    private Usuario usuario;

    @JsonIgnore
    @OneToMany(mappedBy="id_premio", fetch=FetchType.LAZY)
    private List<Premio> id_premio;

    public Ganancia(){super();}

    public Ganancia(long id_ganancia){this.id_ganancia = id_ganancia;}

    public Ganancia(long id_ganancia, Date fecha_ganancia, Double g_bono, Double g_rango, Usuario usuario, List<Premio> id_premio) {
        this.id_ganancia = id_ganancia;
        this.fecha_ganancia = fecha_ganancia;
        this.g_bono = g_bono;
        this.g_rango = g_rango;
        this.usuario = usuario;
        this.id_premio = id_premio;
    }

    public long getId_ganancia() {
        return id_ganancia;
    }

    public void setId_ganancia(long id_ganancia) {
        this.id_ganancia = id_ganancia;
    }

    public Date getFecha_ganancia() {
        return fecha_ganancia;
    }

    public void setFecha_ganancia(Date fecha_ganancia) {
        this.fecha_ganancia = fecha_ganancia;
    }

    public Double getG_bono() {
        return g_bono;
    }

    public void setG_bono(Double g_bono) {
        this.g_bono = g_bono;
    }

    public Double getG_rango() {
        return g_rango;
    }

    public void setG_rango(Double g_rango) {
        this.g_rango = g_rango;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Premio> getId_premio() {
        return id_premio;
    }

    public void setId_premio(List<Premio> id_premio) {
        this.id_premio = id_premio;
    }
}
