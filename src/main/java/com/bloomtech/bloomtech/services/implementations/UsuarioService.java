package com.bloomtech.bloomtech.services.implementations;

import com.bloomtech.bloomtech.models.dao.IUsuario;
import com.bloomtech.bloomtech.models.entities.Rango;
import com.bloomtech.bloomtech.models.entities.Usuario;
import com.bloomtech.bloomtech.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    private IUsuario usuariodao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return usuariodao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Usuario> findAll(Pageable pageable) {
        return usuariodao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findById(long id) {
        return usuariodao.findByid(id);
    }

    @Override
    @Transactional
    public void delete(long id) {
        usuariodao.deleteById(id);
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return usuariodao.save(usuario);
    }



    @Override
    public Usuario findByclave_invitacion(String clave_invitacion) {
        return usuariodao.findByclave_invitacion(clave_invitacion);
    }

    @Override
    public Usuario findByUsername(String username) {
        return usuariodao.findByusername(username);
    }

    @Override
    public Usuario findByEmail(String email) {
        return usuariodao.findByemail(email);
    }

    @Override
    public Usuario findByStatus(String status) {
        return usuariodao.findByestado(status);
    }

    @Override
    public List<Usuario> findAllUser() {
        return usuariodao.findAllUser();

    }
}
