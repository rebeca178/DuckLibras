package com.example.mobileducklibras.user.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class AlunoEntity implements Serializable {

    private Long id;
    private String nome; // Corresponde ao campo 'nome' no seu backend
    private String email; // Corresponde ao campo 'email' no seu backend
    private Integer pontuacao; // Corresponde ao campo 'pontuacao' no seu backend

    // Pode adicionar outros campos relevantes do seu AlunoEntitys do backend aqui
    // Ex: private String dataNascimento;

    // Construtor vazio
    public AlunoEntity() {
    }

    // Construtor com campos
    public AlunoEntity(Long id, String nome, String email, Integer pontuacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.pontuacao = pontuacao;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }
}