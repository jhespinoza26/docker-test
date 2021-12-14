package com.bloomtech.bloomtech.models.entities;

import javax.persistence.*;

@Entity
public class UsuarioLogin {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Basic(optional=false)
    private Long id_usuario;

    private String user;

    private String password;

    public UsuarioLogin() {
    }

    public UsuarioLogin(Long id_usuario, String user, String password) {
        this.id_usuario = id_usuario;
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }
}
