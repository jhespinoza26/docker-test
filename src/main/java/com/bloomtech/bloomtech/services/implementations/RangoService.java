package com.bloomtech.bloomtech.services.implementations;

import com.bloomtech.bloomtech.models.dao.IGanancia;
import com.bloomtech.bloomtech.models.dao.IRango;
import com.bloomtech.bloomtech.models.dao.IUsuario;
import com.bloomtech.bloomtech.models.entities.Ganancia;
import com.bloomtech.bloomtech.models.entities.Rango;
import com.bloomtech.bloomtech.models.entities.Usuario;
import com.bloomtech.bloomtech.services.interfaces.IRangoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RangoService implements IRangoService {
    @Autowired
    private IRango rangodao;

    @Autowired
    private IUsuario usuariodao;

    @Override
    @Transactional(readOnly = true)
    public List<Rango> findAll(Sort sort) {
        return rangodao.findAll(sort);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Rango> findAll(Pageable pageable) {
        return rangodao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Rango findById(long id) {
        return rangodao.findById(id).get();
    }

    @Override
    public void delete(long id) {
        rangodao.deleteById(id);
    }

    @Override
    public Rango save(Rango rangos) {
        return rangodao.save(rangos);
    }

    @Override
    public Rango findByRango(long id_usuario) {
        //sera?
        return rangodao.findByRango(id_usuario);
    }
}
