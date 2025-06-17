package com.example.mobileducklibras.Dicionario.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class DicionarioLibrasEntity implements Serializable {

    private Long id;
    private String palavra;
    private String traducao;
    private String sinal; // URL para um vídeo ou imagem do sinal
    private String imagem; // URL da imagem
    private String videoUrl; // URL do vídeo
    private String descricao;
    private String categoria;
    private String ultimaAtualizacao;

    // Construtor vazio
    public DicionarioLibrasEntity() {
    }

    // Construtor com todos os campos (opcional, mas útil)
    public DicionarioLibrasEntity(Long id, String palavra, String traducao, String sinal, String imagem, String videoUrl, String descricao, String categoria, String ultimaAtualizacao) {
        this.id = id;
        this.palavra = palavra;
        this.traducao = traducao;
        this.sinal = sinal;
        this.imagem = imagem;
        this.videoUrl = videoUrl;
        this.descricao = descricao;
        this.categoria = categoria;
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public String getTraducao() {
        return traducao;
    }

    public void setTraducao(String traducao) {
        this.traducao = traducao;
    }

    public String getSinal() {
        return sinal;
    }

    public void setSinal(String sinal) {
        this.sinal = sinal;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(String ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }
}