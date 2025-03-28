package com.ducklibras.api.models.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;

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
    private Pontuacao pontuacao;

    @ManyToOne
    @JoinColumn(name = "DICIOid")
    private Dicionario_Libras dicionarioLibras;

    public Aula() {
    }

    public Aula(String explicacao, Pontuacao pontuacao, Dicionario_Libras dicionarioLibras) {
        this.explicacao = explicacao;
        this.pontuacao = pontuacao;
        this.dicionarioLibras = dicionarioLibras;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExplicacao() {
        return explicacao;
    }

    public void setExplicacao(String explicacao) {
        this.explicacao = explicacao;
    }

    public Pontuacao getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Pontuacao pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Dicionario_Libras getDicionarioLibras() {
        return dicionarioLibras;
    }

    public void setDicionarioLibras(Dicionario_Libras dicionarioLibras) {
        this.dicionarioLibras = dicionarioLibras;
    }
}


    public void setDicionarioLibrasName(String dicionarioLibrasName) {
        this.dicionarioLibrasName = dicionarioLibrasName;
    }
}
