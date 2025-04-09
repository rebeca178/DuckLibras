package com.ducklibras.api.models.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "aulas")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;
    private String descricao;
    private String urlVideo;
    private int pontos;

    @Column(name = "explicacao", nullable = false, length = 512)
    private String explicacao;

    @ManyToOne
    @JoinColumn(name = "Pid")
    private PontuacaoEntity pontuacao;

    @ManyToOne
    @JoinColumn(name = "DICIOid")
    private DicionarioLibrasEntity dicionarioLibras;

    // Construtor padrão (sem parâmetros)
    public Aula() {
    }

    // Construtor com todos os parâmetros
    public Aula(String titulo, String descricao, String urlVideo, int pontos, String explicacao, PontuacaoEntity pontuacao, DicionarioLibrasEntity dicionarioLibras) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.urlVideo = urlVideo;
        this.pontos = pontos;
        this.explicacao = explicacao;
        this.pontuacao = pontuacao;
        this.dicionarioLibras = dicionarioLibras;
    }

    // Métodos Getters e Setters são gerados automaticamente pelo Lombok
}
