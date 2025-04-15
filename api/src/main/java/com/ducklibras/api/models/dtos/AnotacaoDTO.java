package com.ducklibras.api.models.dtos;

import com.ducklibras.api.models.entitys.AnotacaoEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AnotacaoDTO {

    private Long id;
    private String titulo;
    private String conteudo;


    public AnotacaoDTO(Long id, String titulo, String conteudo) {
        if (id != null) this.id = id;
        if (titulo != null) this.titulo = titulo;
        if (conteudo != null) this.conteudo = conteudo;
    
    }
    public AnotacaoDTO(AnotacaoEntity user){
        if(user!= null){
            this.id = user.getId();
            this.titulo = user.getTitulo();
            this.conteudo = user.getConteudo();
        }
    }

}



