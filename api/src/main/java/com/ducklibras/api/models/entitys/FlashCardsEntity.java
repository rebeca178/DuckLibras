package com.ducklibras.api.models.entitys;

import lombok.Setter;

import com.ducklibras.api.models.dtos.FlashCardDto;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Setter

@Entity
@Table(name = "FlashCard")
public class FlashCardsEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;


    @Column(name = "quest", nullable = false, columnDefinition = "TEXT")
    private String quest;

    
    
    @ManyToOne
    @JoinColumn(name = "pontuacaoId", nullable = false)
    private PontuacaoEntity pontuacaoId;

    @ManyToOne
    @JoinColumn(name = "dicionarioId", nullable = false)
    private DicionarioLibrasEntity dicionarioId;

   
    public FlashCardsEntity(FlashCardDto user){
        this.quest = user.getQuest();
 
    }

    public Long getId() {
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    public String getQuest() {
        throw new UnsupportedOperationException("Unimplemented method 'getQuest'");
    }

    public Object getResposta() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getResposta'");
    }

    public void setResposta(Object resposta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setResposta'");
    }

    
}