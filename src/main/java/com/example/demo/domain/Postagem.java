package com.example.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="postagens")
public class Postagem {

    @Id
    private String id;
    private String titulo;
    private String conteudo;
}
