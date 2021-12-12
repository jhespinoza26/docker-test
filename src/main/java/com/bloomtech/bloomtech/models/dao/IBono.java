package com.bloomtech.bloomtech.models.dao;

import com.bloomtech.bloomtech.models.entities.Bono;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBono extends JpaRepository<Bono,Long> {
    @Query(value = "SELECT p FROM Bono p")
    public List<Bono> findAll(Sort sort);
}
