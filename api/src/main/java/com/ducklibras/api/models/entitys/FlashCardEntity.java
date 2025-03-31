package com.ducklibras.api.models.entitys;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import jacarta.persistence.Entity;
import jacarta.persistence.Table;


@Gettter
@Setter

@Entity
@Table(name = "flashCard")
public class FlashCardEntity implements Serializable{

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
   
    public FlashCardEntity(flashCardDto user){
        this.quest = user.getquest();
 
    }


}

