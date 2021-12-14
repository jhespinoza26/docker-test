package com.bloomtech.bloomtech.controllers;

import com.bloomtech.bloomtech.models.entities.Ganancia;
import com.bloomtech.bloomtech.services.interfaces.IGananciaService;
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
@RequestMapping(value= "ganancia")
public class gananciaController {
    @Autowired
    private IGananciaService gananciaService;

    @GetMapping
    public ResponseEntity<List<Ganancia>> findAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size){

        //ordeno Hijo por nombres existentes
        Sort sortByName = Sort.by("id_ganancia");
        ResponseEntity<List<Ganancia>> responseEntity = null;
        List<Ganancia> ganancias = null;

        if(page !=null && size != null){
            Pageable pageable = PageRequest.of(page, size, sortByName);
            ganancias = gananciaService.findAll(pageable).getContent();
        }else{
            ganancias = gananciaService.findAll(sortByName);
        }
        if(ganancias.size()>0){
            responseEntity = new ResponseEntity<List<Ganancia>>(ganancias, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<List<Ganancia>>(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Ganancia> findById(@PathVariable int id){
        Ganancia ganancia = gananciaService.findById(id);
        ResponseEntity<Ganancia> responseEntity = null;
        if(ganancia != null){
            responseEntity = new ResponseEntity<Ganancia>(ganancia, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<Ganancia>(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> insert(@Valid @RequestBody Ganancia ganancia, BindingResult result){
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
            Ganancia gananciaFromDB = gananciaService.save(ganancia);
            if(gananciaFromDB != null){
                responseAsMap.put("ganancia", ganancia);
                responseAsMap.put("mensaje", "el producto con id "+ ganancia.getId_ganancia() +"se ha creado exitosamente");
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
    public ResponseEntity<Map<String, Object>> update(@PathVariable long id, @Valid @RequestBody Ganancia ganancia, BindingResult result){
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
            ganancia.setId_ganancia(id);
            Ganancia gananciaFromDB = gananciaService.save(ganancia);
            if(gananciaFromDB != null){
                responseAsMap.put("ganancia", ganancia);
                responseAsMap.put("mensaje", "el producto con id "+ ganancia.getId_ganancia() +" se ha actualizado exitosamente");
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
