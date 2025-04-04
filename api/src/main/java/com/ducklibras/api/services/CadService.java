package com.ducklibras.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducklibras.api.models.dtos.AlunoDto;
import com.ducklibras.api.models.dtos.AlunoInDto;
import com.ducklibras.api.models.entitys.AlunoEntitys;
import com.ducklibras.api.models.repo.AlunoRepo;

@Service
public class CadService {

        @Autowired
        private AlunoRepo alunoRepo;

    /*
     * Name: [NF011] Create User
     * Description: Method to create a new user
     * Author: Dhemerson 
    */
    public String createAluno(AlunoInDto aluno) {
        String response;
        if(ValidateUsers(aluno.getUsername(), user.getEmail())) {
            response = "ERROR: usuario ja cadastrado";
        }else{
            alunoRepo.save(new AlunoEntitys(aluno));
            response = "Usuario Cadastrado com Sucesso";
        }

        return response;

    }

    /*
     * Name: [NF012] Validate User
     * Description: Method to validate if the user already exists
     * Author: Dhemerson
    */
    public boolean ValidateUsers(String username, String email){
        return alunoRepo.findByUsernameAndEmail(username, email).isEmpty();
    }

}