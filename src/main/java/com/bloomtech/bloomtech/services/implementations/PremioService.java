package com.bloomtech.bloomtech.services.implementations;

import com.bloomtech.bloomtech.models.dao.IBono;
import com.bloomtech.bloomtech.models.dao.IPremio;
import com.bloomtech.bloomtech.models.dao.IUsuario;
import com.bloomtech.bloomtech.models.entities.Premio;
import com.bloomtech.bloomtech.services.interfaces.IPremioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PremioService implements IPremioService {

    @Autowired
    private IPremio premiodao;

    @Override
    @Transactional(readOnly = true)
    public List<Premio> findAll(Sort sort) {
        return premiodao.findAll(sort);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Premio> findAll(Pageable pageable) {
        return premiodao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Premio findById(long id) {
        return premiodao.findById(id).get();
    }

    @Override
    @Transactional
    public void delete(long id) {
        premiodao.deleteById(id);
    }

    @Override
    @Transactional
    public Premio save(Premio premio) {
        return premiodao.save(premio);
    }
}
