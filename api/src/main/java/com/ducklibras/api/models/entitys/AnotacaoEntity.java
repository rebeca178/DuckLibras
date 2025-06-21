package com.ducklibras.api.models.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import com.ducklibras.api.models.dtos.AnotacaoinDto;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Getter
@Setter
@Entity
@Table(name = "anotacao")
public class AnotacaoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 255)
    private String titulo;

    @Column(name = "conteudo", nullable = false, length = 255)
    private String conteudo;


    public AnotacaoEntity() {
    }

    public AnotacaoEntity(AnotacaoinDto dto) {
        this.titulo = dto.getTitulo();
        this.conteudo = dto.getConteudo();
    }

}
