package com.bloomtech.bloomtech.services.interfaces;

import com.bloomtech.bloomtech.models.entities.Hijo;
import com.bloomtech.bloomtech.models.entities.Rango;
import com.bloomtech.bloomtech.models.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    public List<Usuario> findAll(Sort sort);
    public Page<Usuario> findAll(Pageable pageable);
    public Usuario findById(long id);
    public void delete(long id);
    public Usuario save(Usuario usuario);
    public Usuario findByclave_invitacion(String clave_invitacion);
    public Usuario findByUsername(String username);
    public Usuario findByEmail(String email);
    public Usuario findByStatus(String status);

    public List<Usuario> findAllUser();

}
