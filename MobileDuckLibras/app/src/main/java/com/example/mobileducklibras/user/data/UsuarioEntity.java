package com.example.mobileducklibras.user.data;

public class UsuarioEntity {
    private String id;
    private String nome;
    private int pontuacao;

    public UsuarioEntity(String id, String nome, int pontuacao) {
        this.id = id;
        this.nome = nome;
        this.pontuacao = pontuacao;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public int getPontuacao() { return pontuacao; }
    public void setPontuacao(int pontuacao) { this.pontuacao = pontuacao; }
}