package com.ducklibras.api.models.entitys;

import javax.persistence.*;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int pontos;

    // Getters e Setters
}

