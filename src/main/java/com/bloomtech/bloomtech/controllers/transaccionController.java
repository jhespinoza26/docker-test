package com.bloomtech.bloomtech.controllers;

import com.bloomtech.bloomtech.models.entities.Bono;
import com.bloomtech.bloomtech.models.entities.Red;
import com.bloomtech.bloomtech.models.entities.Transaccion;
import com.bloomtech.bloomtech.models.entities.Usuario;
import com.bloomtech.bloomtech.services.interfaces.IBonoService;
import com.bloomtech.bloomtech.services.interfaces.IRedService;
import com.bloomtech.bloomtech.services.interfaces.ITransaccionService;
import com.bloomtech.bloomtech.services.interfaces.IUsuarioService;
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
import java.util.*;

@RestController
@RequestMapping(value= "transaction")
public class transaccionController {
    @Autowired
    private ITransaccionService sertransaccion;

    @Autowired
    private IUsuarioService serusuario;

    @Autowired
    private IRedService servicered;

    @GetMapping("/find")
    private ResponseEntity<List<Transaccion>> findAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size){

        //ordeno hijo por nombres existentes
        Sort sortByName = Sort.by("id_transaccion");
        ResponseEntity<List<Transaccion>> responseEntity = null;
        List<Transaccion> transaccions = null;

        if(page !=null && size != null){
            Pageable pageable = PageRequest.of(page, size, sortByName);
            transaccions = sertransaccion.findAll(pageable).getContent();
        }else{
            transaccions = sertransaccion.findAll(sortByName);
        }
        if(transaccions.size()>0){
            responseEntity = new ResponseEntity<List<Transaccion>>(transaccions, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<List<Transaccion>>(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Transaccion> findById(@PathVariable int id){
        Transaccion transaccion = sertransaccion.findById(id);
        ResponseEntity<Transaccion> responseEntity = null;
        if(transaccion != null){
            responseEntity = new ResponseEntity<Transaccion>(transaccion, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<Transaccion>(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

    @GetMapping(value = "/search_trans/{id_usuario}")
    public List<Transaccion> findBypadre_id(@PathVariable long id_usuario){
        return sertransaccion.findByUsuario(id_usuario);
    }

    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> insert(@Valid @RequestBody Transaccion transaccion, BindingResult result){
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

            transaccion.setFecha_transaccion(Calendar.getInstance(Locale.getDefault()));

            Transaccion transaccionFromDB = sertransaccion.save(transaccion);
            if(transaccionFromDB != null){
                responseAsMap.put("Usuario", transaccion);
                responseAsMap.put("Mensaje", "La transacción con id "+ transaccion.getId_transaccion() +" se ha creado exitosamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.OK);
            }else{
                responseAsMap.put("Mensaje", "La transacción no se ha creado exitosamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (DataAccessException e){
            responseAsMap.put("Mensaje", "La transacción no se ha creado exitosamente: " + e.getLocalizedMessage().toString());
            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PutMapping(value = "/save_trans/{id_usuario}")
    public ResponseEntity<Map<String, Object>> insertar(@PathVariable long id_usuario, @Valid @RequestBody Transaccion transaccion, BindingResult result){
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
            Usuario user = new Usuario();
            user = serusuario.findById(id_usuario);
            transaccion.setUsuario(serusuario.findById(id_usuario));
            Transaccion trFromDB = sertransaccion.save(transaccion);
            user.setRango(rango(id_usuario));
            serusuario.save(user);
            if(trFromDB != null){
                responseAsMap.put("Transaccion", transaccion);
                responseAsMap.put("mensaje", "La transacción con id "+ transaccion.getId_transaccion() +" se ha creado exitosamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.OK);
            }else{
                responseAsMap.put("mensaje", "La transacción no se ha creado exitosamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (DataAccessException e){
            responseAsMap.put("mensaje", "La transacción no se ha creado exitosamente: " + e.getLocalizedMessage().toString());
            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    public String rango(long id){
        Usuario usuario = serusuario.findById(id);
        usuario.setId_usuario(id);
        int contar_transaccion= sertransaccion.findByUsuario(id).size();
        List<Transaccion> trans = sertransaccion.findByUsuario(id);
        int aux=0;
        double numero = 0;
        for(int a=0; a<contar_transaccion; a++){
            if(trans.get(a).getTipo_transaccion().equals("Deposito")){
                numero += trans.get(a).getValor();
            }
        }
        int contarRed = servicered.findBynivel(1,id).size();

        if(asingarRangos(numero,contarRed)=="consultor" || asingarRangos(numero,contarRed)=="gerente"){
            List<Red> red = servicered.findBynivel(1,id);
            int count = red.size();

            for(int c=0;c<count;c++){
                int contarSub = sertransaccion.findByUsuario(red.get(c).getHijo_id().getId_usuario()).size();
                List<Transaccion> transSub = sertransaccion.findByUsuario(red.get(c).getHijo_id().getId_usuario());
                int num2=0;
                for(int d=0; d<contarSub; d++){
                    if(trans.get(d).getTipo_transaccion().equals("Deposito")){
                        num2 += transSub.get(d).getValor();
                    }
                }
                if(num2>=100) {
                    aux += 1;
                }
            }
        }else{
            return asingarRangos(numero,contarRed);
        }
        if(asingarRangos(numero,contarRed)=="consultor" && aux>=3){
            return asingarRangos(numero, contarRed);
        }else{
            if(asingarRangos(numero,contarRed)=="gerente" && aux>=4){
                return asingarRangos(numero, contarRed);
            }else {
                return "socio";
            }
        }

    }
    public String asingarRangos(double monto, int totalRed){
        String rango ="";
        if( (monto >=50 && monto<60) && (totalRed >=3)){
            return rango = "usuario";
        }
        if( (monto >=60 && monto<80) && (totalRed >=3)){
            return rango = "cliente";
        }
        if( (monto >=80 && monto<100) && (totalRed >=3)){
            return rango = "socio";
        }
        if( (monto >=100 && monto<200) && (totalRed >=3)){
            return rango = "consultor";
        }
        if( (monto >=200) && (totalRed >=4)){
            return rango = "gerente";
        }
        return rango;
    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable long id, @Valid @RequestBody Transaccion transaccion, BindingResult result){
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
            transaccion.setId_transaccion(id);
            Transaccion trFromDB = sertransaccion.save(transaccion);
            if(trFromDB != null){
                responseAsMap.put("transaccion", transaccion);
                responseAsMap.put("mensaje", "La transacción con id "+ transaccion.getId_transaccion() +" se ha actualizado exitosamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.OK);
            }else{
                responseAsMap.put("mensaje", "La transacción no se ha actualizado exitosamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (DataAccessException e){
            responseAsMap.put("mensaje", "La transacción no se ha actualizado exitosamente: " + e.getLocalizedMessage().toString());
            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        sertransaccion.delete(id);
    }
}
