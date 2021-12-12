package com.bloomtech.bloomtech.models.dao;

import com.bloomtech.bloomtech.models.entities.Transaccion;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITransaccion extends JpaRepository<Transaccion,Long> {
    @Query(value = "SELECT p FROM Transaccion p")
    public List<Transaccion> findAll(Sort sort);

    @Query(value = "SELECT * FROM transaccion t WHERE t.usuario = :id_usuario", nativeQuery = true)
    public List<Transaccion> findByUsuario(long id_usuario);
}
