package com.ducklibras.api.models.entitys;

import jakarta.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "dicionario")
public class DicionarioLibrasEntity implements Serializable {

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

    @Column(name = "ultima_atualizacao", nullable = false)
    private String ultimaAtualizacao;

   

    @ManyToOne
    @JoinColumn(name = "anotacoesId", nullable = false)
    private AnotacaoEntity anotacoes;


    @ManyToOne
    @JoinColumn(name = "traducoesId", nullable = false)
    private TraducaoEntity traducoes;
}