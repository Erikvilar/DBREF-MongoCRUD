package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.domain.Perfil;

public interface PerfilRepository extends  MongoRepository<Perfil, String>{
    
}
