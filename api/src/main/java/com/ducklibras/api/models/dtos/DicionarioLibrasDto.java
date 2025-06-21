package com.ducklibras.api.models.dtos;

import com.ducklibras.api.models.entitys.DicionarioLibrasEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DicionarioLibrasDto {
    private Long id;
    private String palavra;
    private String traducao;
    private String sinal;
    private String imagem;
    private String videoUrl;
    private String descricao;
    private String categoria;
    private String ultimaAtualizacao;

    public DicionarioLibrasDto(DicionarioLibrasEntity entity) {
        this.id = entity.getId();
        this.palavra = entity.getPalavra();
        this.traducao = entity.getTraducao();
        this.sinal = entity.getSinal();
        this.imagem = entity.getImagem();
        this.videoUrl = entity.getVideoUrl();
        this.descricao = entity.getDescricao();
        this.categoria = entity.getCategoria();
        this.ultimaAtualizacao = entity.getUltimaAtualizacao();
    }
}