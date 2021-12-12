package com.bloomtech.bloomtech.services.implementations;

import com.bloomtech.bloomtech.models.dao.IBono;
import com.bloomtech.bloomtech.models.dao.IUsuario;
import com.bloomtech.bloomtech.models.entities.Bono;
import com.bloomtech.bloomtech.models.entities.Usuario;
import com.bloomtech.bloomtech.services.interfaces.IBonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BonoService implements IBonoService {
    @Autowired
    private IBono bonodao;

    @Override
    @Transactional(readOnly = true)
    public List<Bono> findAll(Sort sort) {
        return bonodao.findAll(sort);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Bono> findAll(Pageable pageable) {
        return bonodao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Bono findById(long id) {
        return bonodao.findById(id).get();
    }

    @Override
    public void delete(long id) {
        bonodao.deleteById(id);
    }

    @Override
    public Bono save(Bono bonos) {
        return bonodao.save(bonos);
    }
}
