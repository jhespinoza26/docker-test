package com.bloomtech.bloomtech.services.interfaces;

import com.bloomtech.bloomtech.models.entities.Premio;
import com.bloomtech.bloomtech.models.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IPremioService {
    public List<Premio> findAll(Sort sort);
    public Page<Premio> findAll(Pageable pageable);
    public Premio findById(long id);
    public void delete(long id);
    public Premio save(Premio premio);
}
