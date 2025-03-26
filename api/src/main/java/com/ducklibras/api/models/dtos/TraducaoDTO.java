package com.ducklibras.api.models.dtos;

public class TraducaoDTO {
    private Long id;
    private String textoOriginal;
    private String textoTraduzido;

    public TraducaoDTO() {}

    public TraducaoDTO(Long id, String textoOriginal, String textoTraduzido) {
        this.id = id;
        this.textoOriginal = textoOriginal;
        this.textoTraduzido = textoTraduzido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextoOriginal() {
        return textoOriginal;
    }

    public void setTextoOriginal(String textoOriginal) {
        this.textoOriginal = textoOriginal;
    }

    public String getTextoTraduzido() {
        return textoTraduzido;
    }

    public void setTextoTraduzido(String textoTraduzido) {
        this.textoTraduzido = textoTraduzido;
    }
}
