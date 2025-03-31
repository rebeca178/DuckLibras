package com.api.ducklibras.models.dtos;

import com.api.ducklibras.models.entitys.UsersEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class flashCardDto {

    private Long id;
    private String quest;


    public flashCardDto(FlashCardEntity user) {
        if(user!= null){
            this.id = user.getId();
            this.quest = user.getQuest();
        }
        

    }

}