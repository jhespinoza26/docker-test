package com.bloomtech.bloomtech.services.interfaces;

import com.bloomtech.bloomtech.models.entities.Red;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IRedService {
    public List<Red> findAll(Sort sort);
    public Page<Red> findAll(Pageable pageable);
    public Red findById(long id);
    public void delete(long id);
    public Red save(Red red);

    public List<Red> findBynivel(long id, long padre_id);

    public List<Red> findAll();
    public List<Red> findBypadre(long padre_id);
}
