package com.ducklibras.api.services;

import java.util.Optional;

import javax.print.DocFlavor.STRING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducklibras.api.models.dtos.AlunoInDto;
import com.ducklibras.api.models.dtos.LoginDto;
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
        if(ValidateAluno(aluno.getEmail())){
            alunoRepo.save(new AlunoEntitys(aluno));
            response = "Usuario Cadastrado com Sucesso";
        }else{
            response = "ERROR: usuario ja cadastrado";
        }

        return response;

    }

     public boolean ValidateAluno(String email){
        return alunoRepo.findByEmail(email).isEmpty();
    }





    /*
     * Name: [NF012] login
     * Description: Method to validate if the user already exists
     * Author: Dhemerson
    */
    public Optional<String> loginAluno(LoginDto log){
        System.out.println(log.getEmail());
        if(alunoRepo.existsByEmail(log.getEmail())){
            Optional<AlunoEntitys> aluno = alunoRepo.findByEmailAndPass(
                log.getEmail(), 
                log.getPass()
                );
            if(aluno.isPresent()){
                return Optional.of("Login Realizado com Sucesso");
            }else{
                return Optional.of("Senha incorreta");
            }
        }else{
            return Optional.of("Usuario / Email não encontrado");
        }
    }

 
}