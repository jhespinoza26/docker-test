package com.bloomtech.bloomtech.controllers;

import com.bloomtech.bloomtech.models.entities.Hijo;
import com.bloomtech.bloomtech.models.entities.Red;
import com.bloomtech.bloomtech.services.interfaces.IRedService;
import com.bloomtech.bloomtech.services.interfaces.IUsuarioService;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value= "red")
public class RedController {
    @Autowired
    private IRedService servicered;

    @Autowired
    private IUsuarioService serviceusuario;

    @Autowired
    private IhijoService servicehijo;

    @GetMapping("/find")
    public ResponseEntity<List<Red>> findAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size){
        //ordeno Hijo por nombres existentes
        Sort sortByName = Sort.by("id_red");
        ResponseEntity<List<Red>> responseEntity = null;
        List<Red> redes = null;
        if(page !=null && size != null){
            Pageable pageable = PageRequest.of(page, size, sortByName);
            redes = servicered.findAll(pageable).getContent();
        }else{
            redes = servicered.findAll(sortByName);
        }
        if(redes.size()>0){
            responseEntity = new ResponseEntity<List<Red>>(redes, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<List<Red>>(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Red> findById(@PathVariable int id){
        Red red = servicered.findById(id);//.get();
        ResponseEntity<Red> responseEntity = null;
        if(red != null){
            responseEntity = new ResponseEntity<Red>(red, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<Red>(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

    //buscar por nivel y padre
    @GetMapping(value = "/level/{nivel}/father/{padre_id}")
    public List<Red> findBypadre_id(@PathVariable long nivel,@PathVariable long padre_id){
        findBypadre_idRed((int) padre_id);
        return servicered.findBynivel(nivel,padre_id);
    }

    public void findBypadre_idRed(int padre_id){
        int t1=0,t2=0,t3=0,t4=0,t5=0,t6=0,t7=0,t8=0;
        List<Hijo> hijo, h1 = null, h2=null ,h3 = null, h4 = null, h5 = null, h6 = null, h7 = null;

        hijo = servicehijo.findBypadre_id(padre_id);
        t1 = hijo.size();
        String valor ="";
        for(int a=0;a<t1;a++){
            h1 = servicehijo.findBypadre_id(hijo.get(a).getHijo_id().getId_usuario());
            t2 = h1.size();
            guardarRed(hijo.get(a).getHijo_id().getUsuario()+"_"+hijo.get(a).getPadre_id().getUsuario(),1,hijo.get(a).getHijo_id().getId_usuario(),padre_id);

            for (int b=0;b<t2;b++){
                h2 = servicehijo.findBypadre_id(h1.get(b).getHijo_id().getId_usuario());
                t3 = h2.size();
                guardarRed(h1.get(b).getHijo_id().getUsuario()+"_"+hijo.get(a).getPadre_id().getUsuario(),2,h1.get(b).getHijo_id().getId_usuario(),padre_id);

                for (int c=0;c<t3;c++){
                    h3 = servicehijo.findBypadre_id(h2.get(c).getHijo_id().getId_usuario());
                    t4 = h3.size();
                    guardarRed(h2.get(c).getHijo_id().getUsuario()+"_"+hijo.get(a).getPadre_id().getUsuario(),3,h2.get(c).getHijo_id().getId_usuario(),padre_id);

                    for (int d=0;d<t4;d++){
                        h4 = servicehijo.findBypadre_id(h3.get(d).getHijo_id().getId_usuario());
                        t5 = h4.size();
                        guardarRed(h3.get(d).getHijo_id().getUsuario()+"_"+hijo.get(a).getPadre_id().getUsuario(),4,h3.get(d).getHijo_id().getId_usuario(),padre_id);

                        for (int e=0;e<t5;e++){
                            h5 = servicehijo.findBypadre_id(h4.get(e).getHijo_id().getId_usuario());
                            t6 = h5.size();
                            guardarRed(h4.get(e).getHijo_id().getUsuario()+"_"+hijo.get(a).getPadre_id().getUsuario(),5,h4.get(e).getHijo_id().getId_usuario(),padre_id);

                            for (int f=0;f<t6;f++){
                                h6 = servicehijo.findBypadre_id(h5.get(f).getHijo_id().getId_usuario());
                                t7 = h6.size();
                                guardarRed(h5.get(f).getHijo_id().getUsuario()+"_"+hijo.get(a).getPadre_id().getUsuario(),6,h5.get(f).getHijo_id().getId_usuario(),padre_id);

                                for (int g=0;g<t7;g++){
                                    h7 = servicehijo.findBypadre_id(h6.get(g).getHijo_id().getId_usuario());
                                    t8=h7.size();
                                    guardarRed(h6.get(g).getHijo_id().getUsuario()+"_"+hijo.get(a).getPadre_id().getUsuario(),7,h6.get(g).getHijo_id().getId_usuario(),padre_id);

                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void guardarRed(String nombre, int nivel, long hijo_id, long padre_id){
        Red red = new Red();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        red.setNombre(nombre);
        red.setFecha_creacion(dtf.format(LocalDateTime.now()));
        red.setNivel(nivel);

        red.setHijo_id(serviceusuario.findById(hijo_id));
        red.setPadre_id(serviceusuario.findById(padre_id));
        Sort sortByName = Sort.by("id_red");
        List<Red> redes = servicered.findAll(sortByName);
        String red2="";

        int valor = 0,countred;
        countred=0;
        valor=redes.size();
        for(int count = 0;count <valor;count ++){
            if(nombre.equals(redes.get(count).getNombre())){
                countred=1;
            }
        }
        if(countred==0){
            servicered.save(red);
            //return "    GUARDAR RED ";
        }else{
            //return "    RED DUPLICADA   ";
        }
    }



    //Buscar Red por padre ID
    @GetMapping(value = "/father/{padre_id}")
    public int findBypadre(@PathVariable long padre_id){
        findBypadre_idRed((int) padre_id);
        return servicered.findBypadre(padre_id).size();
    }

    //actualizar red
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Map<String, Object>> updater(@PathVariable long id, @Valid @RequestBody Red red, BindingResult result){
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
        try {
            red.setId_red(id);
            Red redFromDB = servicered.save(red);
            if(redFromDB != null){
                responseAsMap.put("Red", red);
                responseAsMap.put("Mensaje", "La red con id "+ red.getId_red() +" se ha actualizado exitosamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.OK);
            }else{
                responseAsMap.put("mensaje", "La red no se ha actualizado exitosamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (DataAccessException e){
            responseAsMap.put("mensaje", "La red no se ha actualizado exitosamente: " + e.getLocalizedMessage().toString());
            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        servicered.delete(id);
    }
}
