package com.bloomtech.bloomtech.services.implementations;

import com.bloomtech.bloomtech.models.dao.ITransaccion;
import com.bloomtech.bloomtech.models.dao.IUsuario;
import com.bloomtech.bloomtech.models.entities.Rango;
import com.bloomtech.bloomtech.models.entities.Transaccion;
import com.bloomtech.bloomtech.models.entities.Usuario;
import com.bloomtech.bloomtech.services.interfaces.ITransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaccionService implements ITransaccionService {
    @Autowired
    private ITransaccion transacciondao;

    @Autowired
    private IUsuario usuariodao;

    @Override
    public List<Transaccion> findAll(Sort sort) {
        return transacciondao.findAll(sort);
    }

    @Override
    public Page<Transaccion> findAll(Pageable pageable) {
        return transacciondao.findAll(pageable);
    }

    @Override
    public Transaccion findById(long id) {
        return transacciondao.findById(id).get();
    }

    @Override
    public void delete(long id) {
        transacciondao.deleteById(id);
    }

    @Override
    public Transaccion save(Transaccion transaccion) {
        Usuario usuario = usuariodao.findById(transaccion.getUsuario().getId_usuario()).orElse(null);
        transaccion.setUsuario(usuario);
        return transacciondao.save(transaccion);
    }

    @Override
    public List<Transaccion> findByUsuario(long id_usuario) {
        return transacciondao.findByUsuario(id_usuario);
    }


}
