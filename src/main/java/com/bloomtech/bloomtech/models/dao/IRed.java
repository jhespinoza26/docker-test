package com.bloomtech.bloomtech.models.dao;

import com.bloomtech.bloomtech.models.entities.Hijo;
import com.bloomtech.bloomtech.models.entities.Red;
import com.bloomtech.bloomtech.models.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRed extends JpaRepository<Red, Long> {
    @Query(value = "SELECT r FROM red r")
    public List<Red> findAll(Sort sort);

    @Query(value = "SELECT * FROM Red ORDER BY id",
            countQuery = "SELECT count(*) FROM Red",
            nativeQuery = true)
    public Page<Red> findAll(Pageable pegeable);

    @Query(value = "SELECT * FROM red WHERE id_red= :id", nativeQuery = true)
    public Red findByid(long id);

    @Query(value = "SELECT * FROM red r WHERE r.nivel=:nivel AND r.padre_id=:padre_id", nativeQuery = true)
    public List<Red> findBynivel(long nivel, long padre_id);

    @Query(value = "SELECT * FROM red r WHERE r.padre_id=:padre_id", nativeQuery = true)
    public List<Red> findBypadre(long padre_id);
}
