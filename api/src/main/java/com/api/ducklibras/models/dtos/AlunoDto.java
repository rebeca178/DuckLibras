package com.api.ducklibras.models.dtos;

import com.api.ducklibras.models.Entity.AlunoEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AlunoDto{

    private Long id;
    private String username;
    private String pass;
    private String email;
    private String photo;

    public AlunoDto(AlunoDto user) {
        if(user!= null){
            this.id = user.getId();
            this.username = user.getUsername();
            this.pass = user.getPass();
            this.email = user.getEmail();
            this.photo = user.getPhoto();
        }
        

    }

}
