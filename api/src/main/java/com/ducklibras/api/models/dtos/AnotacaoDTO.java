package com.seuprojeto.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnotacaoDTO {
    private Long id;
    private String titulo;
    private String conteudo;
}
