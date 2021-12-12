



package com.bloomtech.bloomtech.controllers;

import com.bloomtech.bloomtech.models.entities.Bono;
import com.bloomtech.bloomtech.services.interfaces.IBonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value= "bono")
public class bonoController {
    @Autowired
    private IBonoService servicebono;

    @GetMapping
    private ResponseEntity<List<Bono>> findAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size){

        //ordeno hijo por nombres existentes
        Sort sortByName = Sort.by("id_bono");
        ResponseEntity<List<Bono>> responseEntity = null;
        List<Bono> bonos = null;

        if(page !=null && size != null){
            Pageable pageable = PageRequest.of(page, size, sortByName);
            bonos = servicebono.findAll(pageable).getContent();
        }else{
            bonos = servicebono.findAll(sortByName);
        }
        if(bonos.size()>0){
            responseEntity = new ResponseEntity<List<Bono>>(bonos, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<List<Bono>>(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Bono> findById(@PathVariable int id){
        Bono bono = servicebono.findById(id);
        ResponseEntity<Bono> responseEntity = null;
        if(bono != null){
            responseEntity = new ResponseEntity<Bono>(bono, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<Bono>(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> insert(@Valid @RequestBody Bono bono, BindingResult result){
        Map<String, Object> responseAsMap = new HashMap<String, Object>();
        ResponseEntity<Map<String, Object>> responseEntity = null;
        List<String> errores = null;
        if(result.hasErrors()){
            errores = new ArrayList<String>();
            for(ObjectError error: result.getAllErrors()){
                errores.add(error.getDefaultMessage());
            }
            responseAsMap.put("errors", errores);
            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
        //Revisar codigo al momento de ingresar exception de usuario
        try {
            Bono bonoFromDB = servicebono.save(bono);
            if(bonoFromDB != null){
                responseAsMap.put("bono", bono);
                responseAsMap.put("mensaje", "el producto con id "+ bono.getId_bono() +"se ha creado exitosamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.OK);
            }else{
                responseAsMap.put("mensaje", "el producto no se ha creado exitosamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (DataAccessException e){
            responseAsMap.put("mensaje", "el producto no se ha creado exitosamente: " + e.getLocalizedMessage().toString());
            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable long id, @Valid @RequestBody Bono bono, BindingResult result){
        Map<String, Object> responseAsMap = new HashMap<String, Object>();
        ResponseEntity<Map<String, Object>> responseEntity = null;
        List<String> errores = null;
        if(result.hasErrors()){
            errores = new ArrayList<String>();
            for(ObjectError error: result.getAllErrors()){
                errores.add(error.getDefaultMessage());
            }
            responseAsMap.put("errors", errores);
            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.BAD_REQUEST);
            return responseEntity;
        }

        //Revisar codigo al momento de ingresar exception de usuario
        try {
            bono.setId_bono(id);
            Bono bonoFromDB = servicebono.save(bono);
            if(bonoFromDB != null){
                responseAsMap.put("bono", bono);
                responseAsMap.put("mensaje", "el producto con id "+ bono.getId_bono() +" se ha actualizado exitosamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.OK);
            }else{
                responseAsMap.put("mensaje", "el producto no se ha actualizado exitosamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (DataAccessException e){
            responseAsMap.put("mensaje", "el producto no se ha actualizado exitosamente: " + e.getLocalizedMessage().toString());
            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
