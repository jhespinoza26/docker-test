package com.bloomtech.bloomtech.services.interfaces;

import com.bloomtech.bloomtech.models.entities.Bono;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IBonoService {
    public List<Bono> findAll(Sort sort);
    public Page<Bono> findAll(Pageable pageable);
    public Bono findById(long id);
    public void delete(long id);
    public Bono save(Bono bono);
}
