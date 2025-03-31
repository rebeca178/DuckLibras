package com.ducklibras.api.models.dtos;

import com.ducklibras.api.models.entitys.DicaEntity;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DicasDto {

    private Long id;
    private String ajuda;


    public DicasDto(DicaEntity user) {
        if(user!= null){
            this.id = user.getId();
            this.ajuda = user.getAjuda();
        }
      

    }

}