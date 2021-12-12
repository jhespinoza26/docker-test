package com.bloomtech.bloomtech.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Email;


import javax.persistence.Id;
import javax.validation.constraints.*;

@Table(name="usuario")
@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id_usuario", length = 15)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional=false)
    private Long id_usuario;

    @NotEmpty(message="El nombre del usuario es obligatorio")
    @Column(name="nombres", length = 50)
    private String nombres;

    @NotEmpty(message="El teléfono del usuario es obligatorio")
    @Column(name="telefono", length = 15)
    private String telefono;

    @NotEmpty(message="El email del usuario es obligatorio")
    @Email
    @Column(name="email", length = 50, unique=true)
    private String email;

    @Min(value=10, message = "El DNI debe ser minimo 10")
    @Column(name="DNI", length = 15, unique=true)
    private long DNI;

    @Column(name="rol", length = 15)
    private String rol;

    @Column(name="estado", length = 15)
    private String estado;

    @NotEmpty(message="Ingrese un usuario")
    @Column(name="usuario", length = 20, unique=true)
    private String usuario;

    @Column(name="clave_invitacion", length = 20)
    private String clave_invitacion;

    @NotEmpty(message="Ingrese una  contraseña")
    @Size(min=8, message = "La contraseña mínima debe ser de 8 caracteres")
    @Column(name="contrasena")
    private String contrasena;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name=" foto", columnDefinition="longblob", nullable=true)
    private byte[] foto;

    @Column(name="fecha_creacion")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Calendar fecha_creacion;

    @Column(name="fecha_modificacion")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fecha_modificacion;

    private String token;

    @JsonIgnore
    @OneToMany(mappedBy="padre_id", fetch=FetchType.LAZY)
    private List<Hijo> hijos;

    @Column(name="rango", length = 50)
    private String rango;

    @JsonIgnore
    @OneToMany(mappedBy="usuario", fetch=FetchType.LAZY)
    private List<Transaccion> id_transaccion;


    @JsonIgnore
    @OneToMany(mappedBy="id_premio", fetch=FetchType.LAZY)
    private List<Premio> id_premio;

    @JsonIgnore
    @OneToMany(mappedBy="id_ganancia", fetch=FetchType.LAZY)
    private List<Ganancia> id_ganancia;

//    @Column(name="accountVerified", length = 50)
//    private Boolean accountVerified;

    public Usuario() {
        super();
    }

    public Usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Usuario(Long id_usuario, String nombres, String telefono, String email, long DNI, String rol, String estado, String usuario, String clave_invitacion, String contrasena, byte[] foto, Calendar fecha_creacion, Date fecha_modificacion, List<Hijo> hijos, String rango, List<Transaccion> id_transaccion, List<Premio> id_premio, List<Ganancia> id_ganancia) {
        this.id_usuario = id_usuario;
        this.nombres = nombres;
        this.telefono = telefono;
        this.email = email;
        this.DNI = DNI;
        this.rol = rol;
        this.estado = estado;
        this.usuario = usuario;
        this.clave_invitacion = clave_invitacion;
        this.contrasena = contrasena;
        this.foto = foto;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
        this.hijos = hijos;
        this.rango = rango;
        this.id_transaccion = id_transaccion;
        this.id_premio = id_premio;
        this.id_ganancia = id_ganancia;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getDNI() {
        return DNI;
    }

    public void setDNI(long DNI) {
        this.DNI = DNI;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave_invitacion() {
        return clave_invitacion;
    }

    public void setClave_invitacion(String clave_invitacion) {
        this.clave_invitacion = clave_invitacion;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Calendar getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Calendar fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public List<Hijo> getHijos() {
        return hijos;
    }

    public void setHijos(List<Hijo> hijos) {
        this.hijos = hijos;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public List<Transaccion> getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(List<Transaccion> id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public List<Premio> getId_premio() {
        return id_premio;
    }

    public void setId_premio(List<Premio> id_premio) {
        this.id_premio = id_premio;
    }

    public List<Ganancia> getId_ganancia() {
        return id_ganancia;
    }

    public void setId_ganancia(List<Ganancia> id_ganancia) {
        this.id_ganancia = id_ganancia;
    }


    /*public boolean isAccountVerified() {
        return accountVerified;
    }

    public void setAccountVerified(boolean accountVerified) {
        this.accountVerified = accountVerified;
    }*/

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + id_usuario +
                ", nombres='" + nombres + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", DNI=" + DNI +
                ", rol='" + rol + '\'' +
                ", estado='" + estado + '\'' +
                ", usuario='" + usuario + '\'' +
                ", clave_invitacion='" + clave_invitacion + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", foto=" + Arrays.toString(foto) +
                ", fecha_creacion=" + fecha_creacion +
                ", fecha_modificacion=" + fecha_modificacion +
                ", hijos=" + hijos +
                '}';
    }
}
