package com.ducklibras.api.models.dtos;

import com.ducklibras.api.models.entitys.FlashCardsEntitys;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FlashCardDto {

    private Long id;
    private String quest;


    public FlashCardDto(FlashCardsEntitys user) {
        if(user!= null){
            this.id = user.getId();
            this.quest = user.getQuest();
        }
        

    }

}