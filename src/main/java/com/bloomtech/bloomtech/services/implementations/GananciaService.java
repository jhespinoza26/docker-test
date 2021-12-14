package com.bloomtech.bloomtech.services.implementations;

import com.bloomtech.bloomtech.models.dao.IGanancia;
import com.bloomtech.bloomtech.models.dao.IUsuario;
import com.bloomtech.bloomtech.models.entities.Ganancia;
import com.bloomtech.bloomtech.services.interfaces.IGananciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GananciaService implements IGananciaService {
    @Autowired
    private IGanancia gananciadao;

    @Override
    @Transactional
    public Ganancia save(Ganancia ganancia) {
        return gananciadao.save(ganancia);
    }

    @Override
    @Transactional(readOnly = true)
    public Ganancia findById(long id) {
        return gananciadao.findById(id).get();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Ganancia> findAll(Pageable pageable) {
        return gananciadao.findAll(pageable);
    }

    @Override
    @Transactional
    public void delete(long id) {
        gananciadao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ganancia> findAll(Sort sort) {
        return gananciadao.findAll(sort);
    }

}
