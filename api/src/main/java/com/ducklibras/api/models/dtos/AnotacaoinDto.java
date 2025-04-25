package com.ducklibras.api.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AnotacaoinDto {

    private String titulo;
    private String conteudo;

    public AnotacaoinDto(){
        
    }

    public AnotacaoinDto(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;

    }
}
