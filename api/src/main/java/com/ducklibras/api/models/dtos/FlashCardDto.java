package com.ducklibras.api.models.dtos;

import com.ducklibras.api.models.entitys.FlashCardEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FlashCardDto {

    private Long id;
    private String quest;


    public FlashCardDto(FlashCardEntity user) {
        if(user!= null){
            this.id = user.getId();
            this.quest = user.getQuest();
        }
        

    }

}