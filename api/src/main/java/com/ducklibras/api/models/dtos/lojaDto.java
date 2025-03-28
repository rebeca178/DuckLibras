package com.ducklibras.api.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class lojaDto {
    private Long id;
    private String produto;
    private int preco;
    
}
