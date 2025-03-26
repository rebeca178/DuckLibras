package com.ducklibras.api.models.dtos;

public class AnotacaoDTO {
    private Long id;
    private String descricao;
    private Long traducaoId;

    public AnotacaoDTO() {}

    public AnotacaoDTO(Long id, String descricao, Long traducaoId) {
        this.id = id;
        this.descricao = descricao;
        this.traducaoId = traducaoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getTraducaoId() {
        return traducaoId;
    }

    public void setTraducaoId(Long traducaoId) {
        this.traducaoId = traducaoId;
    }
}
