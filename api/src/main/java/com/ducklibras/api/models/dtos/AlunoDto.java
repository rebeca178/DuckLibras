package com.ducklibras.api.models.dtos;


import com.ducklibras.api.models.entitys.AlunoEntitys;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AlunoDto {

    private Long id;
    private String username;
    private String pass;
    private String email;
    private String photo;

    public AlunoDto() {

    }

    public AlunoDto(Long id, String username, String pass, String email, String photo) {
        if (id != null) this.id = id;
        if (username != null) this.username = username;
        if (pass != null) this.pass = pass;
        if (email != null) this.email = email;
        if (photo != null) this.photo = photo;
    }

    public AlunoDto(String username, String pass, String email, String photo) {
        if (username != null) this.username = username;
        if (pass != null) this.pass = pass;
        if (email != null) this.email = email;
        if (photo != null) this.photo = photo;
    }

    public AlunoDto(String username, String pass, String email) {
        if (username != null) this.username = username;
        if (pass != null) this.pass = pass;
        if (email != null) this.email = email;
    }

}