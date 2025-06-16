package com.example.mobileducklibras.Dicionario.data; // Novo pacote para os modelos de dados do dicionário

import com.google.gson.annotations.SerializedName; // Para mapeamento JSON, se os nomes forem diferentes na API

import java.io.Serializable;
public class DicionarioLibrasEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Use @SerializedName se o nome do campo no JSON for diferente do nome da variável Java
    @SerializedName("id")
    private Long id;

    @SerializedName("palavra")
    private String palavra;

    @SerializedName("traducao")
    private String traducao;

    @SerializedName("sinal")
    private String sinal; // Geralmente seria uma URL para um vídeo ou imagem do sinal

    @SerializedName("imagem")
    private String imagem; // URL da imagem

    @SerializedName("videoUrl")
    private String videoUrl; // URL do vídeo

    @SerializedName("descricao")
    private String descricao;

    @SerializedName("categoria")
    private String categoria;

    @SerializedName("ultimaAtualizacao")
    private String ultimaAtualizacao;

    public DicionarioLibrasEntity() {
    }
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

    // Getters e Setters para todos os campos (essenciais para GSON/Retrofit)

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

    // Anotações @ManyToOne como anotacoesId e traducoesId não são necessárias aqui,
    // pois o cliente Android geralmente não precisa entender as relações de banco de dados do backend.
    // Ele apenas consome os dados serializados.
}