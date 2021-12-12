package com.bloomtech.bloomtech.models.dao;

import com.bloomtech.bloomtech.models.entities.Rango;
import com.bloomtech.bloomtech.models.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUsuario extends JpaRepository<Usuario, Long> {
    @Query(value = "SELECT u FROM Usuario u")
    public List<Usuario> findAll(Sort sort);

    @Query(value = "SELECT * FROM Usuario ORDER BY id",
            countQuery = "SELECT count(*) FROM Usuario",
            nativeQuery = true)
    public Page<Usuario> findAll(Pageable pegeable);

    //@Query(value = "select h from Usuario h left join fetch h.padre where h.id_hijo = :id")

    @Query(value = "select u from Usuario u where u.id_usuario= :id")
    public Usuario findByid(long id);


    @Query(value = "select u from Usuario u where u.clave_invitacion= :clave_invitacion")
    public Usuario findByclave_invitacion(String clave_invitacion);

    @Query(value = "select u from Usuario u where u.usuario= :usuario")
    public Usuario findByusername(String usuario);

    @Query(value = "select u from Usuario u where u.email= :email")
    public Usuario findByemail(String email);

    @Query(value = "select u from Usuario u where u.estado= :estado")
    public Usuario findByestado(String estado);

    @Query(value = "select * from Usuario", nativeQuery = true)
    public List<Usuario> findAllUser();

}
