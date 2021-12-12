package com.bloomtech.bloomtech.models.dao;

import com.bloomtech.bloomtech.models.entities.Ganancia;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IGanancia extends JpaRepository<Ganancia,Long> {
    @Query(value = "SELECT p FROM Ganancia p")
    public List<Ganancia> findAll(Sort sort);

}
