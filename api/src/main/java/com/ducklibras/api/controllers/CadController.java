package com.ducklibras.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducklibras.api.models.dtos.AlunoDto;
import com.ducklibras.api.models.dtos.AlunoInDto;
import com.ducklibras.api.models.dtos.ResponseModel;
import com.ducklibras.api.models.services.CadService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/cad")
public class CadController{

    @Autowired 
    private CadService cadService;

    /*
     * Name: [RF000] Test
     * Description: Test method to check if the API is working
     * Author:Dhemerson
    */
    @PostMapping("/signup")

    public ResponseEntity<ResponseModel> createAluno(@RequestBody AlunoDto aluno) 
    {
        ResponseModel responseDto = cadService.createAluno(aluno);
        return ResponseEntity.status(responseDto.getStatus()).body(responseDto);
    }

    @PostMapping("/signin")
    public ResponseEntity<ResponseModel> signInUser(@RequestBody AlunoInDto signin)
    {
        ResponseModel responseDto = cadService.loginAluno(signin);
        return ResponseEntity.status(responseDto.getStatus()).body(responseDto);
    }
}   
