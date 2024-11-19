package com.example.demo.domain;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "cursos")
public class Curso {
    private String id;
    private String name;

    @DBRef
    private List<Estudante> estudantes;
    
}
