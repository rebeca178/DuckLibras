package com.ducklibras.api.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class comprasDto {
    private Long id;
    private String produto;
    private String loja;
    private String preco;
    private Long usuarioId; // ID do usuário associado à compra
    
}
