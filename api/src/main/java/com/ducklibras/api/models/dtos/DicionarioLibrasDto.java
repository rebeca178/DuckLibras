package com.ducklibras.api.models.dtos;

import com.ducklibras.api.models.entitys.DicionarioLibrasEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DicionarioLibrasDto {

    private Long id;
    private String palavra;
    private String videoUrl;
    private String imagemUrl;
    private String descricao;
    private String categoria;
    private String dataCriacao;
    private String dataAtualizacao;

    public DicionarioLibrasDto(DicionarioLibrasEntity user) {
        if(user!= null){
            this.id = getId();
            this.palavra = getPalavra();
            this.videoUrl = getVideoUrl();
            this.imagemUrl = getImagemUrl();
            this.descricao = getDescricao();
            this.categoria = getCategoria();
            this.dataCriacao = getDataAtualizacao();
            this.dataAtualizacao = getDataAtualizacao();
    }
        }
    }
    