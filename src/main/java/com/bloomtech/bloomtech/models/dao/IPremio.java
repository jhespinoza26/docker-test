package com.bloomtech.bloomtech.models.dao;

import com.bloomtech.bloomtech.models.entities.Bono;
import com.bloomtech.bloomtech.models.entities.Premio;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPremio extends JpaRepository<Premio,Long> {
//    @Query(value = "SELECT p FROM Premio p")
//    public List<Premio> findAll(Sort sort);
}