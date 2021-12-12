package com.bloomtech.bloomtech.controllers;

import com.bloomtech.bloomtech.models.entities.Bono;
import com.bloomtech.bloomtech.models.entities.Premio;
import com.bloomtech.bloomtech.services.interfaces.IBonoService;
import com.bloomtech.bloomtech.services.interfaces.IPremioService;
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
@RequestMapping(value= "premio")
public class premioController {
    @Autowired
    private IPremioService premioService;

    @GetMapping
    private ResponseEntity<List<Premio>> findAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size){

        //ordeno hijo por nombres existentes
        Sort sortByName = Sort.by("id_premio");
        ResponseEntity<List<Premio>> responseEntity = null;
        List<Premio> premios = null;

        if(page !=null && size != null){
            Pageable pageable = PageRequest.of(page, size, sortByName);
            premios = premioService.findAll(pageable).getContent();
        }else{
            premios = premioService.findAll(sortByName);
        }
        if(premios.size()>0){
            responseEntity = new ResponseEntity<List<Premio>>(premios, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<List<Premio>>(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Premio> findById(@PathVariable int id){
        Premio premio = premioService.findById(id);
        ResponseEntity<Premio> responseEntity = null;
        if(premio != null){
            responseEntity = new ResponseEntity<Premio>(premio, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<Premio>(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> insert(@Valid @RequestBody Premio premio, BindingResult result){
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
            Premio premioFromDB = premioService.save(premio);
            if(premioFromDB != null){
                responseAsMap.put("premio", premio);
                responseAsMap.put("mensaje", "el producto con id "+ premio.getId_premio() +"se ha creado exitosamente");
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
    public ResponseEntity<Map<String, Object>> update(@PathVariable long id, @Valid @RequestBody Premio premio, BindingResult result){
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
            premio.setId_premio(id);
            Premio  premioFromDB = premioService.save(premio);
            if(premioFromDB != null){
                responseAsMap.put("premio", premio);
                responseAsMap.put("mensaje", "el producto con id "+ premio.getId_premio() +" se ha actualizado exitosamente");
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
