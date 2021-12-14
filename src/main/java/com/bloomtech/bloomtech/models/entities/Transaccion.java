package com.bloomtech.bloomtech.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Calendar;

@Table(name="Transaccion")
@Entity
public class Transaccion implements Serializable {
    @Id
    @Column(name="id_transaccion")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Basic(optional=false)
    private long id_transaccion;

    @Column(name="fecha_transaccion")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Calendar fecha_transaccion;

    @NotNull
    @Column(name="tipo_transaccion", length = 50)
    private String tipo_transaccion;

    @NotNull
    @Column(name="valor")
    private Double valor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario")
    private Usuario usuario;

//    @JoinColumn(name="usuario", referencedColumnName="id_usuario")
//    @ManyToOne
//    private Usuario usuario;

    public Transaccion(){super();}

    public Transaccion(long id_transaccion){this.id_transaccion = id_transaccion;}

    public Transaccion(long id_transaccion, Calendar fecha_transaccion, String tipo_transaccion, Double valor, Usuario usuario) {
        this.id_transaccion = id_transaccion;
        this.fecha_transaccion = fecha_transaccion;
        this.tipo_transaccion = tipo_transaccion;
        this.valor = valor;
        this.usuario = usuario;
    }

    public long getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(long id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public Calendar getFecha_transaccion() {
        return fecha_transaccion;
    }

    public void setFecha_transaccion(Calendar fecha_transaccion) {
        this.fecha_transaccion = fecha_transaccion;
    }

    public String getTipo_transaccion() {
        return tipo_transaccion;
    }

    public void setTipo_transaccion(String tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
