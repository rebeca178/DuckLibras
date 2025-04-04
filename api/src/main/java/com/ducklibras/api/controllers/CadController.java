package com.ducklibras.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducklibras.api.models.dtos.AlunoInDto;
import com.ducklibras.api.services.CadService;

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
    public ResponseEntity<String> teste(@RequestBody AlunoInDto aluno) {
        String response = cadService.createAluno(aluno);
        return (response.equals("Usuario Cadastrado com Sucesso"))
        ?ResponseEntity.status(202).body(response)
        :ResponseEntity.status(400).body(response);
    }
}
