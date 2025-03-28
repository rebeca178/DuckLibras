package com.ducklibras.api.models.dtos;

import com.ducklibras.api.models.entitys.AulasEntity;
import com.ducklibras.api.models.entitys.FlashcardEntity;
import com.ducklibras.api.models.entitys.PontuacaoEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BsDto{

    private long id;
    private boolean status;
    private AulasEntity aulasId;
    private FlashcardEntity flashId;
    private PontuacaoEntity ponID;
}