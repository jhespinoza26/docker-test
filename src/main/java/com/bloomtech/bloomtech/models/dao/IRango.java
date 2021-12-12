package com.bloomtech.bloomtech.models.dao;

import com.bloomtech.bloomtech.models.entities.Rango;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRango extends JpaRepository<Rango,Long> {
    @Query(value = "SELECT p FROM Rango p")
    public List<Rango> findAll(Sort sort);

    @Query(value = "SELECT MAX( ra.id_rango) FROM rango ra WHERE (SELECT t.deposito FROM transaccion t WHERE t.usuario_id_usuario = :id_usuario AND t.first_transaccion = 1) >= ra.minimo_red AND (SELECT t.deposito FROM transaccion t WHERE t.usuario_id_usuario = :id_usuario AND t.first_transaccion = 1) < ra.maximo_red AND (SELECT COUNT(*) FROM red r WHERE r.padre_id= :id_usuario) >= ra.numero_red",nativeQuery = true)
    public Rango findByRango(long id_usuario);
}
