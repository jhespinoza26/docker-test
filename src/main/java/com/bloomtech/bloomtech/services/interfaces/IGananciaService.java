package com.bloomtech.bloomtech.services.interfaces;

import com.bloomtech.bloomtech.models.entities.Ganancia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IGananciaService {
    public Ganancia save(Ganancia ganancia);
    public Ganancia findById(long id);
    public Page<Ganancia> findAll(Pageable pageable);
    public void delete(long id);
    public List<Ganancia> findAll(Sort sort);
}
