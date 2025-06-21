package com.ducklibras.api.models.dtos;

import lombok.Data;


@Data
public class ResponseModel {

    private int status;
    
    public String response;
    private String message;    

    public ResponseModel() {
        
    }

    
}
