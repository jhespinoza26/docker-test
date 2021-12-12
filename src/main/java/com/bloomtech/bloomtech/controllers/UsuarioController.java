package com.bloomtech.bloomtech.controllers;


import com.bloomtech.bloomtech.models.entities.*;
import com.bloomtech.bloomtech.services.implementations.EmailService;
import com.bloomtech.bloomtech.services.interfaces.*;

import io.jsonwebtoken.Claims;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;


import javax.management.relation.Role;

import javax.annotation.security.RolesAllowed;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value= "user")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private IUsuarioService serviceusuario;

    @Autowired
    private IRedService servicered;

    @Autowired
    private IhijoService servicehijo;

    @Autowired
    private ITransaccionService transaccionService;

    @Autowired
    private IRangoService rangoService;

    @Autowired
    private EmailService servicemail;

    @Autowired
    private PasswordEncoder passwordEncoder;


    //@RolesAllowed("administrador")
    @GetMapping("/find")
    public ResponseEntity< List<Usuario> > findAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size){
        //ordeno Hijo por nombres existentes
        Sort sortByName = Sort.by("id_usuario");
        ResponseEntity<List<Usuario>> responseEntity = null;
        List<Usuario> usuarios = null;
        if(page !=null && size != null){
            Pageable pageable = PageRequest.of(page, size, sortByName);
            usuarios = serviceusuario.findAll(pageable).getContent();
        }else{
            usuarios = serviceusuario.findAll(sortByName);
        }
        if(usuarios.size()>0){
            responseEntity = new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

    @GetMapping(value = "/findId/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable int id){
        Usuario usuario = serviceusuario.findById(id);
        ResponseEntity<Usuario> responseEntity = null;
        if(usuario != null){
            responseEntity = new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

    public void findBypadre_id(int padre_id){
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

    @GetMapping(value = "/clave/{clave_invitacion}")
    public ResponseEntity<Usuario> findByClave(@PathVariable String clave_invitacion){
        Usuario usuario = serviceusuario.findByclave_invitacion(clave_invitacion);
        ResponseEntity<Usuario> responseEntity = null;
        if(usuario != null){
            responseEntity = new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }


    @PostMapping("/save")
    //@PreAuthorize("hasRole('usuario')")
    public ResponseEntity<Map<String, Object>> insert(@Valid @RequestBody Usuario usuario, BindingResult result){
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
            //codificacion de la contraseña
            String pass = usuario.getContrasena();
            String passEncrip = passwordEncoder.encode(pass);
            String contra = usuario.getContrasena();
            usuario.setContrasena(passEncrip);
            //SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            if(usuario.getRol()=="" || usuario.getRol()==null){
                usuario.setRol("invitado");
            }else{
                usuario.setRol("administrador");
            }
            usuario.setEstado("activo");
            usuario.setFecha_creacion(Calendar.getInstance(Locale.getDefault()));

            try{
                List<Usuario> usuariolist =  serviceusuario.findAllUser();
                int cout = usuariolist.size();
                for (int i =0;i<cout;i++){
                    if (usuariolist.get(i).getUsuario().equals(usuario.getUsuario())){
                        responseAsMap.put("Mensaje", "El usuario ya existe");
                        responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
                        return responseEntity;
                    }
                    if (usuariolist.get(i).getEmail().equals(usuario.getEmail())){
                        responseAsMap.put("Mensaje", "El Email ya existe");
                        responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
                        return responseEntity;
                    }
                    if (usuariolist.get(i).getDNI()==usuario.getDNI()){
                        responseAsMap.put("Mensaje", "El DNI ya existe");
                        responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
                        return responseEntity;
                    }
                }
            }catch (DataAccessException e){
                responseAsMap.put("Mensaje", "Error al validar los datos: " + e.getLocalizedMessage().toString());
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
                return responseEntity;
            }
            Usuario usuarioFromDB = serviceusuario.save(usuario);
            if(usuarioFromDB != null){
                //correo de Bienvenida
                Email mail = new Email();
                mail.setSubject("Bienvenida");
                mail.setTo(usuarioFromDB.getEmail());
                mail.setText(" Bienvenido/a " +usuarioFromDB.getNombres()+" a nuestra página. Su regitro se ha realizado con éxito. Su usuario es: "+ usuarioFromDB.getUsuario()+ " y su contraseña es: "+contra);
                servicemail.enviarEmail(mail);
                responseAsMap.put("Usuario", usuario);
                responseAsMap.put("Mensaje", "El usuario con id "+ usuario.getId_usuario() +" se ha creado exitosamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.OK);
            }else{
                responseAsMap.put("Mensaje", "El usuario no se ha creado exitosamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (DataAccessException e){
            responseAsMap.put("Mensaje", "El usuario no se ha creado exitosamente: " + e.getLocalizedMessage().toString());
            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PutMapping(value = "/refer/{id_padre}")
    public ResponseEntity<Map<String, Object>> register(@PathVariable long id_padre, @Valid @RequestBody Usuario usuario, BindingResult result){
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
            usuario.setEstado("activo");
            usuario.setFecha_creacion(Calendar.getInstance(Locale.getDefault()));
            usuario.setRol("usuario");

            String pass = usuario.getContrasena();
            String passEncrip = passwordEncoder.encode(pass);
            usuario.setContrasena(passEncrip);


            Usuario usuarioPadre = serviceusuario.findById(id_padre);
            if(usuarioPadre!=null) {
                //Implementacion de la validación
                try {
                    List<Usuario> usuariolist = serviceusuario.findAllUser();
                    int cout = usuariolist.size();
                    for (int i = 0; i < cout; i++) {
                        if (usuariolist.get(i).getUsuario().equals(usuario.getUsuario())) {
                            responseAsMap.put("Mensaje", "El usuario ya existe");
                            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
                            return responseEntity;
                        }
                        if (usuariolist.get(i).getEmail().equals(usuario.getEmail())) {
                            responseAsMap.put("Mensaje", "El Email ya existe");
                            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
                            return responseEntity;
                        }
                        if (usuariolist.get(i).getDNI() == usuario.getDNI()) {
                            responseAsMap.put("Mensaje", "El DNI ya existe");
                            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
                            return responseEntity;
                        }
                    }
                } catch (DataAccessException e) {
                    responseAsMap.put("Mensaje", "Error al validar los datos: " + e.getLocalizedMessage().toString());
                    responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
                    return responseEntity;
                }

                Usuario usuarioFromDB = serviceusuario.save(usuario);

                if (usuarioFromDB != null) {
                    //correo de Bienvenida
                    Email mail = new Email();
                    mail.setSubject("Bienvenida");
                    mail.setTo(usuarioFromDB.getEmail());
                    mail.setText(" Bienvenido/a " + usuarioFromDB.getNombres() + " a nuestra página. Su regitro se ha realizado con éxito. Su usuario es: " + usuarioFromDB.getUsuario() + " y su contraseña es: " + usuarioFromDB.getContrasena());
                    servicemail.enviarEmail(mail);
                    responseAsMap.put("Usuario", usuario);
                    responseAsMap.put("Mensaje", "El usuario con id " + usuario.getId_usuario() + " se ha creado exitosamente");
                    responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.OK);

                    //Agregar registro de usuario a hijo ademas de registro de usuario por el que fue referido
                    Hijo hijo = new Hijo();
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    hijo.setFecha_creacion(dtf.format(LocalDateTime.now()));
                    hijo.setNombre(usuario.getNombres());
                    Usuario usuariopadre = serviceusuario.findById(id_padre);
                    hijo.setPadre_id(usuariopadre);
                    hijo.setHijo_id(usuario);
                    servicehijo.save(hijo);
                    findBypadre_id((int) id_padre);

                } else {
                    responseAsMap.put("Mensaje", "El usuario no se ha creado exitosamente");
                    responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        }catch (DataAccessException e){
            responseAsMap.put("Mensaje", "El usuario no se ha creado exitosamente: " + e.getLocalizedMessage().toString());
            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        //findBypadre_id((int) id_padre);

        return responseEntity;
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable long id, @Valid @RequestBody Usuario usuario, BindingResult result){
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
            usuario.setId_usuario(id);
            String pass = usuario.getContrasena();
            String passEncrip = passwordEncoder.encode(pass);
            usuario.setContrasena(passEncrip);
            Usuario usuarioFromDB = serviceusuario.save(usuario);
            if(usuarioFromDB != null){
                //correo de Bienvenida
                Email mail = new Email();
                mail.setSubject("Bienvenida");
                mail.setTo(usuarioFromDB.getEmail());
                mail.setText(" Bienvenido/a " +usuarioFromDB.getNombres()+" a nuestra página. Su regitro se ha realizado con éxito. Su usuario es: "+ usuarioFromDB.getUsuario()+ " y su contraseña es: "+usuarioFromDB.getContrasena());
                servicemail.enviarEmail(mail);
                responseAsMap.put("Usuario", usuario);
                responseAsMap.put("Mensaje", "El usuario con id "+ usuario.getId_usuario() +" se ha actualizado exitosamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.OK);
            }else{
                responseAsMap.put("mensaje", "El usuario no se ha actualizado exitosamente");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (DataAccessException e){
            responseAsMap.put("mensaje", "El usuario no se ha actualizado exitosamente: " + e.getLocalizedMessage().toString());
            responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
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


    @PostMapping("login")
    public Usuario login(@Valid @RequestBody UsuarioLogin usuarioingresado) {
        Map<String, Object> responseAsMap = new HashMap<String, Object>();
        ResponseEntity<Map<String, Object>> responseEntity = null;
        //Identificar si existe un usuario con el dato del username ingresado por el usuario
        Usuario usuario = serviceusuario.findByUsername(usuarioingresado.getUser());
        if (usuario != null) {
            //controlar la contraseña
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            boolean comparar = encoder.matches(usuarioingresado.getPassword(),usuario.getContrasena());
            if(comparar){
                String token = getJWTToken(usuarioingresado.getUser());
                Usuario usua = serviceusuario.findByUsername(usuarioingresado.getUser());
                usua.setToken(token);
                return usua;
            }else{
                responseAsMap.put("Mensaje", "Ingrese correctamente la contraseña");
                responseEntity = new ResponseEntity<Map<String, Object>>(responseAsMap, HttpStatus.INTERNAL_SERVER_ERROR);
                //imprimir el mensaje
                return null;
            }
        } else {
            //Identificar si existe un correo con el dato del username ingresado por el usuario
            Usuario usuario1 = serviceusuario.findByEmail(usuarioingresado.getUser());
            if (usuario1 != null) {
                //controlar la contraseña
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                boolean comparar = encoder.matches(usuarioingresado.getPassword(),usuario1.getContrasena());
                if(comparar){
                    String token = getJWTToken(usuario1.getUsuario());
                    Usuario usua = serviceusuario.findByEmail(usuarioingresado.getUser());
                    usua.setToken(token);
                    return usua;
                }else{
                    return null;
                }
            } else {
                responseAsMap.put("Mensaje", "Debe ingresar un usuario o un correo");
                return null;
            }
        }
    }

    private String getJWTToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        String secretKey = "mySecretKey";
        //implementacion de los roles
        Set<String> Userroles = new HashSet<>();
        Usuario user = serviceusuario.findByUsername(username);
        //se guarda el rol si hay otra tabla de roles se hace un for
       // Userroles.add(user.getRol());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+user.getRol()));
        /*List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("usuario");
        claims.put("authorities",
                grantedAuthorities.stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()));
        claims.put("Roles",Userroles.toArray());*/
        String token = Jwts
                .builder()
                .setId("softtekJWT")

                .setSubject(username)
                //.setClaims(claims)
                .claim("authorities",grantedAuthorities.stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))

                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*10))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return token;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        serviceusuario.delete(id);
    }

}
