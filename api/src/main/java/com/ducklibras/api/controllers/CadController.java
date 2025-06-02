package com.ducklibras.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducklibras.api.models.dtos.AlunoInDto;
import com.ducklibras.api.models.dtos.LoginDto;
import com.ducklibras.api.models.dtos.ResponseModel;
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

    public ResponseEntity<ResponseModel> teste(@RequestBody AlunoInDto aluno) 
    {

        ResponseModel responseDto = new ResponseModel();
        
        String response = cadService.createAluno(aluno);
        
        responseDto.setResponse(response);

        if(response == null) {
            return(response.equals("Usuario Cadastrado"))
                ? ResponseEntity.status(201).body(responseDto)
                : ResponseEntity.status(400).body(responseDto);
        }
        else{
            return ResponseEntity.status(500).body(responseDto);
        }
            
        
    }

    @PostMapping("/loginaluno")
    public ResponseEntity<ResponseModel> postMethodName(@RequestBody LoginDto log) 
    {
          ResponseModel responseDto = new ResponseModel();

        Optional<String> response = cadService.loginAluno(log);

        responseDto.setResponse(response.orElse("Erro ao logar usuario"));

        if(response.isPresent()){
            return(response.get().equals("Login Realizado com Sucesso"))
                ? ResponseEntity.status(201).body(responseDto)
                : ResponseEntity.status(400).body(responseDto);
        }
        else{
            return ResponseEntity.status(500).body(responseDto);
        }
            
    }
}
