package com.ducklibras.api.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AlunoInDto {

    private String username;
    private String pass;
    private String email;
    private String photo;

    public AlunoInDto(){
        
    }

    public AlunoInDto(String username, String pass, String email, String photo) {
        this.username = username;
        this.pass = pass;
        this.email = email;
        this.photo = photo;
    }
    
    public AlunoInDto(String username, String pass, String email) {
        this.email = email;
        this.pass = pass;
        this.username = username;
    }

    public AlunoInDto(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }
    
}