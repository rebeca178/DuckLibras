package com.ducklibras.api.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TraducaoDTO {

    private Long id;
    private String idiomaOrigem;
    private String idiomaDestino;
    private String textoOriginal;
    private String textoTraduzido;

}
