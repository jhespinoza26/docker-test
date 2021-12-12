package com.bloomtech.bloomtech.services.implementations;

import com.bloomtech.bloomtech.models.dao.Ihijodao;
import com.bloomtech.bloomtech.models.entities.Hijo;
import com.bloomtech.bloomtech.services.interfaces.IhijoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class hijoService implements IhijoService {
    @Autowired
    private Ihijodao hijodao;

    @Override
    @Transactional(readOnly = true)
    public List<Hijo> findAll(Sort sort) {
        return hijodao.findAll(sort);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Hijo> findAll(Pageable pageable) {
        return hijodao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Hijo findById(long id) {
        return hijodao.findByid(id);//.get();
    }

    @Override
    @Transactional
    public void delete(long id) {
        hijodao.deleteById(id);
    }

    @Override
    @Transactional
    public Hijo save(Hijo hijo) {
        return hijodao.save(hijo);
    }


    @Override
    public List<Hijo> findBypadre_id(long id) {
        return hijodao.findBypadre_id(id);
    }

}
