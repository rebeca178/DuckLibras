package com.ducklibras.api.models.dtos;

public class AulaDto {
    private Long id;
    private String explicacao;
    private Long pontuacaoId;  // Just the ID, not the whole object
    private String dicionarioLibrasName; //example

    public AulaDto() {
    }

    public AulaDto(Long id, String explicacao, Long pontuacaoId, String dicionarioLibrasName) {
        this.id = id;
        this.explicacao = explicacao;
        this.pontuacaoId = pontuacaoId;
        this.dicionarioLibrasName = dicionarioLibrasName;
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

    public Long getPontuacaoId() {
        return pontuacaoId;
    }

    public void setPontuacaoId(Long pontuacaoId) {
        this.pontuacaoId = pontuacaoId;
    }

    public String getDicionarioLibrasName() {
        return dicionarioLibrasName;
    }

    public void setDicionarioLibrasName(String dicionarioLibrasName) {
        this.dicionarioLibrasName = dicionarioLibrasName;
    }
}
