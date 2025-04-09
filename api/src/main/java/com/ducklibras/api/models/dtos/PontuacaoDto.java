package com.ducklibras.api.models.dtos;

import com.ducklibras.api.models.entitys.PontuacaoEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PontuacaoDto {

    private Long id;
    private int pontos;
    private int nivel;
    private String ultimaAtualizacao;

    public PontuacaoDto(PontuacaoEntity user) {
        if(user!= null){
            this.id = user.getId();
            this.pontos = user.getPontos();
            this.nivel = user.getNivel();
            this.ultimaAtualizacao = user.getUltimaAtualizacao();

        }
        

    }

}