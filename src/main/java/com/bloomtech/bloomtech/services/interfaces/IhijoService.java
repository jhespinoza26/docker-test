package com.bloomtech.bloomtech.services.interfaces;

import com.bloomtech.bloomtech.models.entities.Hijo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IhijoService {
    public List<Hijo> findAll(Sort sort);
    public Page<Hijo> findAll(Pageable pageable);
    public Hijo findById(long id);
    public void delete(long id);
    public Hijo save(Hijo hijo);

    public List<Hijo> findBypadre_id(long id);

}
