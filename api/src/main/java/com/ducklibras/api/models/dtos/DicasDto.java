package com.api.ducklibras.models.dtos;

import com.api.ducklibras.models.entitys.UsersEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DicasDto {

    private Long id;
    private String ajuda;


    public DicasDto(DicasEntity user) {
        if(user!= null){
            this.id = user.getId();
            this.ajuda = user.getAjuda();
        }
      

    }

}