package com.ducklibras.api.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor

public class chatDto {
    private Long id;
    private String mensagem;
    private Long remetenteId;
    private Long destinatarioId;
    
    
}
