package com.bloomtech.bloomtech.controllers;

import com.bloomtech.bloomtech.models.entities.Hijo;
import com.bloomtech.bloomtech.models.entities.Red;
import com.bloomtech.bloomtech.services.interfaces.IhijoService;
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
@RequestMapping(value= "child")
@CrossOrigin(origins = "*")
public class hijoController {

    @Autowired
    private IhijoService servicehijo;

    @GetMapping("/find")
    public ResponseEntity< List<Hijo> > findAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size){
        //ordeno Hijo por nombres existentes
        Sort sortByName = Sort.by("id_hijo");
        ResponseEntity<List<Hijo>> responseEntity = null;
        List<Hijo> hijos = null;
        if(page !=null && size != null){
            Pageable pageable = PageRequest.of(page, size, sortByName);
            hijos = servicehijo.findAll(pageable).getContent();
        }else{
            hijos = servicehijo.findAll(sortByName);
        }
        if(hijos.size()>0){
            responseEntity = new ResponseEntity<List<Hijo>>(hijos, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<List<Hijo>>(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Hijo> findById(@PathVariable int id){
        Hijo hijo = servicehijo.findById(id);//.get();
        ResponseEntity<Hijo> responseEntity = null;
        if(hijo != null){
            responseEntity = new ResponseEntity<Hijo>(hijo, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<Hijo>(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

    @GetMapping(value = "/father/{padre_id}")
    public List<Hijo> findBypadre_id(@PathVariable int padre_id){
        return servicehijo.findBypadre_id(padre_id);
    }

    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> insert(@Valid @RequestBody Hijo hijo, BindingResult result){
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
            Hijo hijoFromDB = servicehijo.save(hijo);
            if(hijoFromDB != null){
                responseAsMap.put("Hijo", hijo);
                responseAsMap.put("Mensaje", "El hjo con id "+ hijo.getId_hijo() +" se ha creado exitosamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.OK);
            }else{
                responseAsMap.put("Mensaje", "El hijo no se ha creado exitosamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (DataAccessException e){
            responseAsMap.put("Mensaje", "El hijo no se ha creado exitosamente: " + e.getLocalizedMessage().toString());
            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable long id, @Valid @RequestBody Hijo hijo, BindingResult result){
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
            hijo.setId_hijo(id);
            Hijo hijoFromDB = servicehijo.save(hijo);
            if(hijoFromDB != null){
                responseAsMap.put("Hijo", hijo);
                responseAsMap.put("Mensaje", "El hijo con id "+ hijo.getId_hijo() +" se ha actualizado exitosamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.OK);
            }else{
                responseAsMap.put("mensaje", "El hijo no se ha actualizado exitosamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (DataAccessException e){
            responseAsMap.put("mensaje", "El hijo no se ha actualizado exitosamente: " + e.getLocalizedMessage().toString());
            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}
