package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Perfil;
import com.example.demo.domain.Usuario;
import com.example.demo.repository.PerfilRepository;
import com.example.demo.repository.UsuarioRepository;




@RestController
public class UsuarioController {
    
    @Autowired
    private PerfilRepository perfilRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping
    public List<Usuario> findall() {
        return usuarioRepository.findAll();
    }
    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        if(usuario.getPerfil() != null  && usuario.getPerfil().getId() == null){
            Perfil perfilSalvo =perfilRepository.save(usuario.getPerfil());
            usuario.setPerfil(perfilSalvo); 
        }
        return usuarioRepository.save(usuario);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> putMethodName(@PathVariable String id, @RequestBody Usuario usuario) {
        Optional<Usuario> idUser  = usuarioRepository.findById(usuario.getId());
        if(idUser.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.OK);
        
        
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable String id) {
        Optional<Usuario> idUser  = usuarioRepository.findById(id);
        
        if(idUser.isPresent()){
            usuarioRepository.delete(usuarioRepository.findById(i));
            return ResponseEntity.ok().build();
        }
    }


    
}
