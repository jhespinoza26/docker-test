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
    @Query(value = "SELECT * FROM usuario",nativeQuery = true)
    public List<Usuario> findAll();

    @Query(value = "SELECT * FROM usuario ORDER BY id",
            countQuery = "SELECT count(*) FROM usuario",
            nativeQuery = true)
    public Page<Usuario> findAll(Pageable pegeable);

    //@Query(value = "select h from Usuario h left join fetch h.padre where h.id_hijo = :id")

    @Query(value = "select * from usuario u where u.id_usuario= :id", nativeQuery = true)
    public Usuario findByid(long id);


    @Query(value = "select * from usuario u where u.clave_invitacion= :clave_invitacion", nativeQuery = true)
    public Usuario findByclave_invitacion(String clave_invitacion);

    @Query(value = "select * from usuario u where u.usuario= :usuario", nativeQuery = true)
    public Usuario findByusername(String usuario);

    @Query(value = "select * from usuario u where u.email= :email", nativeQuery = true)
    public Usuario findByemail(String email);

    @Query(value = "select * from usuario u where u.estado= :estado", nativeQuery = true)
    public Usuario findByestado(String estado);

    @Query(value = "select * from usuario", nativeQuery = true)
    public List<Usuario> findAllUser();

}
