package com.bloomtech.bloomtech.controllers;

import com.bloomtech.bloomtech.models.entities.Rango;
import com.bloomtech.bloomtech.services.interfaces.IRangoService;
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
@RequestMapping(value= "rank")
public class rangoController {
    @Autowired
    private IRangoService servicerango;

    @GetMapping("/find")
    private ResponseEntity<List<Rango>> findAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size){

        //ordeno hijo por nombres existentes
        Sort sortByName = Sort.by("id_rango");
        ResponseEntity<List<Rango>> responseEntity = null;
        List<Rango> rangos = null;

        if(page !=null && size != null){
            Pageable pageable = PageRequest.of(page, size, sortByName);
            rangos = servicerango.findAll(pageable).getContent();
        }else{
            rangos = servicerango.findAll(sortByName);
        }
        if(rangos.size()>0){
            responseEntity = new ResponseEntity<List<Rango>>(rangos, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<List<Rango>>(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Rango> findById(@PathVariable int id){
        Rango rango = servicerango.findById(id);
        ResponseEntity<Rango> responseEntity = null;
        if(rango != null){
            responseEntity = new ResponseEntity<Rango>(rango, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<Rango>(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

    @GetMapping(value = "/search_rank/{id_usuario}")
    public ResponseEntity<Rango> selecRango(@PathVariable long id_usuario){
        Rango rango = servicerango.findByRango(3);
        ResponseEntity<Rango> responseEntity = null;
        if(rango != null){
            responseEntity = new ResponseEntity<Rango>(rango, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<Rango>(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> insert(@Valid @RequestBody Rango rangos, BindingResult result){
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
            Rango rangoFromDB = servicerango.save(rangos);
            if(rangoFromDB != null){
                responseAsMap.put("rango", rangos);
                responseAsMap.put("mensaje", "El rango con id "+ rangos.getId_rango() +" se ha creado exitosamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.OK);
            }else{
                responseAsMap.put("mensaje", "El rango no se ha creado exitosamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (DataAccessException e){
            responseAsMap.put("mensaje", "El rango no se ha creado exitosamente: " + e.getLocalizedMessage().toString());
            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable long id, @Valid @RequestBody Rango rango, BindingResult result){
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
            rango.setId_rango(id);
            Rango rangoFromDB = servicerango.save(rango);
            if(rangoFromDB != null){
                responseAsMap.put("rango", rango);
                responseAsMap.put("mensaje", "El rango con id "+ rango.getId_rango() +" se ha actualizado exitosamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.OK);
            }else{
                responseAsMap.put("mensaje", "El rango no se ha actualizado exitosamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (DataAccessException e){
            responseAsMap.put("mensaje", "El rango no se ha actualizado exitosamente: " + e.getLocalizedMessage().toString());
            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
