package com.bloomtech.bloomtech.services.interfaces;

import com.bloomtech.bloomtech.models.entities.Rango;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IRangoService {
    public List<Rango> findAll(Sort sort);
    public Page<Rango> findAll(Pageable pageable);
    public Rango findById(long id);
    public void delete(long id);
    public Rango save(Rango rango);

    public Rango findByRango(long id_usuario);
}
