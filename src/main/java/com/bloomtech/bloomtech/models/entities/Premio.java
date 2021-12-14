package com.bloomtech.bloomtech.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name="Premio")
@Entity
public class Premio {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id_premio")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Basic(optional=false)
    private long id_premio;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @NotNull
    private Bono bono;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @NotNull
    private Usuario usuario;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @NotNull
    private Ganancia ganancia;

    public Premio(){super();}

    public Premio(long id_premio){this.id_premio = id_premio;}

    public Premio(long id_premio, Bono bono, Usuario usuario, Ganancia ganancia) {
        this.id_premio = id_premio;
        this.bono = bono;
        this.usuario = usuario;
        this.ganancia = ganancia;
    }

    public long getId_premio() {
        return id_premio;
    }

    public void setId_premio(long id_premio) {
        this.id_premio = id_premio;
    }

    public Bono getBono() {
        return bono;
    }

    public void setBono(Bono bono) {
        this.bono = bono;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Ganancia getGanancia() {
        return ganancia;
    }

    public void setGanancia(Ganancia ganancia) {
        this.ganancia = ganancia;
    }
}
