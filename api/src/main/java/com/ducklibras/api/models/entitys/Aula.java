package com.ducklibras.api.models.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Column;

@Getter
@Setter

@Entity
@Table(name = "aulas")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "explicacao", nullable = false, length = 255)
    private String explicacao;

    @ManyToOne
    @JoinColumn(name = "Pid")
    private PontuacaoEntity pontuacao;

    @ManyToOne
    @JoinColumn(name = "DICIOid")
    private DicionarioLibrasEntity dicionarioLibras;

    public Aula() {
    }

    public Aula(String explicacao, PontuacaoEntity pontuacao, DicionarioLibrasEntity dicionarioLibras) {
        this.explicacao = explicacao;
        this.pontuacao = pontuacao;
        this.dicionarioLibras = dicionarioLibras;
    }
}
