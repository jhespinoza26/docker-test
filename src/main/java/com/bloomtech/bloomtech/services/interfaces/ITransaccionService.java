package com.bloomtech.bloomtech.services.interfaces;

import com.bloomtech.bloomtech.models.entities.Rango;
import com.bloomtech.bloomtech.models.entities.Transaccion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ITransaccionService {
    public List<Transaccion> findAll(Sort sort);
    public Page<Transaccion> findAll(Pageable pageable);
    public Transaccion findById(long id);
    public void delete(long id);
    public Transaccion save(Transaccion transaccion);

    public List<Transaccion> findByUsuario(long id_usuario);
}
