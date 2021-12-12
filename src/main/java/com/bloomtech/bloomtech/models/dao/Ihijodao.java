package com.bloomtech.bloomtech.models.dao;

import com.bloomtech.bloomtech.models.entities.Hijo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Ihijodao extends JpaRepository<Hijo, Long> {
    @Query(value = "SELECT u FROM Hijo u")
    public List<Hijo> findAll(Sort sort);

    @Query(value = "SELECT * FROM Hijo ORDER BY id",
            countQuery = "SELECT count(*) FROM Hijo",
            nativeQuery = true)
    public Page<Hijo> findAll(Pageable pegeable);

    @Query(value = "select h from Hijo h where h.id_hijo= :id")
    public Hijo findByid(long id);

    @Query(value = "SELECT * FROM hijo WHERE padre_id= :id", nativeQuery = true)
    public List<Hijo> findBypadre_id(long id);

}
