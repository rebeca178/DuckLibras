package com.api.ducklibras.models.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "Dicionario_Libras")
public class DicionarioLibrasDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "palavra", nullable = false, length = 100)
    private String palavra;

    @Column(name = "traducao", nullable = false, length = 100)
    private String traducao;

    @Column(name = "sinal", nullable = false, length = 255)
    private String sinal;

    @Column(name = "imagem", nullable = false, length = 255)
    private String imagem;

    @Column(name = "video_url", nullable = false, length = 255)
    private String videoUrl;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "categoria", length = 50)
    private String categoria;

    @Enumerated(EnumType.STRING)
    @Column(name = "dificuldade", columnDefinition = "ENUM('Fácil', 'Médio', 'Difícil') DEFAULT 'Fácil'")
    private Dificuldade dificuldade;
}

@Getter
@Setter
@Entity
@Table(name = "Pontuacao")
public class PontuacaoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pontos", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int pontos;

    @Column(name = "nivel", nullable = false, columnDefinition = "INT DEFAULT 1")
    private int nivel;

    @Column(name = "ultima_atualizacao", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp ultimaAtualizacao;
}