package com.bloomtech.bloomtech.services.implementations;

import com.bloomtech.bloomtech.models.dao.IRed;
import com.bloomtech.bloomtech.models.dao.Ihijodao;
import com.bloomtech.bloomtech.models.entities.Hijo;
import com.bloomtech.bloomtech.models.entities.Red;
import com.bloomtech.bloomtech.models.entities.Usuario;
import com.bloomtech.bloomtech.services.interfaces.IRedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RedService implements IRedService {
    @Autowired
    private IRed reddao;

    @Override
    @Transactional(readOnly = true)
    public List<Red> findAll(Sort sort) {
        return reddao.findAll(sort);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Red> findAll(Pageable pageable) {
        return reddao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Red findById(long id) {
        return reddao.findByid(id);//.get();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Red> findBynivel(long nivel, long padre_id) {
        return reddao.findBynivel(nivel,padre_id);//.get();
    }

    @Override
    public List<Red> findAll() {
        return reddao.findAll();
    }

    @Override
    public List<Red> findBypadre(long padre_id) {
        return reddao.findBypadre(padre_id);
    }


    @Override
    @Transactional
    public void delete(long id) {
        reddao.deleteById(id);
    }

    @Override
    @Transactional
    public Red save(Red red) {
        return reddao.save(red);
    }


}
