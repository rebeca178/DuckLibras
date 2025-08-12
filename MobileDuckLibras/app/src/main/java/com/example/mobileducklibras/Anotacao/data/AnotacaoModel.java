package com.example.mobileducklibras.Anotacao.data;

public class AnotacaoModel {
    private String titulo;
    private String conteudo;

    public AnotacaoModel(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public String getTitulo() { return titulo; }
    public String getConteudo() { return conteudo; }
}