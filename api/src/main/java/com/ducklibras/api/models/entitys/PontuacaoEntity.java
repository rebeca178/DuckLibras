package com.ducklibras.api.models.entitys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "Pontuacao")
public class PontuacaoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pontos", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int pontos;

    @Column(name = "nivel", nullable = false, columnDefinition = "INT DEFAULT 1")
    private int nivel;

    @Column(name = "ultima_atualizacao", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String ultimaAtualizacao;
}