package com.ducklibras.api.models.entitys;

import lombok.Getter;
import lombok.Setter;

import com.ducklibras.api.models.dtos.FlashCardDto;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Getter
@Setter

@Entity
@Table(name = "flashCard")
public class FlashcardsEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;


    @Column(name = "quest", nullable = false, columnDefinition = "TEXT")
    private String quest;

    @OneToOne
    @JoinColumn(name = "pontuacaoId", nullable = false)
    private PontuacaoEntity pontuacaoId;

    @OneToOne
    @JoinColumn(name = "DicioId", nullable = false)
    private DicionarioLibrasEntity DicioIdId;
   
    public FlashcardsEntity(FlashCardDto user){
        this.quest = user.getQuest();
 
    }

    public Long getId() {
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    public String getQuest() {
        throw new UnsupportedOperationException("Unimplemented method 'getQuest'");
    }

}

