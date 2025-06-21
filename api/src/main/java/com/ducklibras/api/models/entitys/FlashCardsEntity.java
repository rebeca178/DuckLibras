package com.ducklibras.api.models.entitys;

import lombok.Getter;
import lombok.Setter;

import com.ducklibras.api.models.dtos.FlashCardDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Getter @Setter
@Entity
@Table(name = "FlashCard")
public class FlashCardsEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;


    @Column(name = "quest", nullable = false, columnDefinition = "TEXT")
    private String quest;
    
     @Column(name = "resposta", nullable = false, columnDefinition = "TEXT")
    private String resposta;

   public FlashCardsEntity() {}
   
   public FlashCardsEntity(FlashCardDto user){
   this.quest = user.getQuest();
 
    }
    @ManyToOne
    @JoinColumn(name = "dicionario_id")
    @JsonBackReference
    private DicionarioLibrasEntity dicionario;

}