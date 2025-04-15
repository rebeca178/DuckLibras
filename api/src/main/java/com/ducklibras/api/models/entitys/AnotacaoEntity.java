package com.ducklibras.api.models.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import com.ducklibras.api.models.dtos.AnotacaoinDto;

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

    public AnotacaoEntity(Long id, String titulo, String conteudo) {
        if (id != null) this.id = id;
        if (titulo != null) this.titulo = titulo;
        if (conteudo != null) this.conteudo = conteudo;
    }

    public AnotacaoEntity(String titulo, String conteudo) {
        if (titulo != null) this.titulo = titulo;
        if (conteudo != null) this.conteudo = conteudo;
    }

    public AnotacaoEntity(AnotacaoinDto aula){
        if(aula != null){
        this.titulo = aula.getTitulo();
        this.conteudo = aula.getConteudo();

        }
    }

}
