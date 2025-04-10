package com.ducklibras.api.models.dtos;

import com.ducklibras.api.models.entitys.BsEntitys;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BsDto{

    public BsDto(BsEntitys save) {
    }
    private long id;
    private boolean status;
    private Long aulasId;
    private Long flashId;
    private Long ponId;
}