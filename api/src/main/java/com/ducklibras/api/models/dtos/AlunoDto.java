package com.ducklibras.api.models.dtos;

import lombok.Data;


@Data
public class AlunoDto {
    private Long id;
    private String username;
    private String pass;
    private String email;
    private String photo;

}