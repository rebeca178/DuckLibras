package com.ducklibras.api.models.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Setter;
import jakarta.persistence.Column;



@Entity
@Table(name = "aulas")
@getter
@Setter

public class aulas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String explicacao;

    @Column(name="explicação", nullable=false, length=512)
    public String getDescription() { return explicacao; }

    
    @ManyToOne
    @JoinColumn(name = "Pid")
    private Pontuacao pontuacao;


    @ManyToOne
    @JoinColumn(name = "DICIOid")
    private Dicionario_Libras dicionarioLibras;

    public void Aula(String explicacao, Pontuacao pontuacao, Dicionario_Libras dicionarioLibras) {
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
