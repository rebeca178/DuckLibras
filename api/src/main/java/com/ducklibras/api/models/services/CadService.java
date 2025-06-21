package com.ducklibras.api.models.services;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ducklibras.api.models.dtos.AlunoDto;
import com.ducklibras.api.models.dtos.AlunoInDto;
import com.ducklibras.api.models.dtos.ResponseModel;
import com.ducklibras.api.models.entitys.AlunoEntitys;
import com.ducklibras.api.models.repo.AlunoRepo;

@Service
public class CadService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AlunoRepo alunoRepo;    
        
    public ResponseModel loginAluno(AlunoInDto log) {
    ResponseModel response = new ResponseModel();
    try {
        // Buscar usuário por username ou email
        Optional<AlunoEntitys> alunoOpt = alunoRepo.findByUsername(log.getUsernameOrEmail());
        if (!alunoOpt.isPresent()) {
            alunoOpt = alunoRepo.findByEmail(log.getUsernameOrEmail());
        }

        if (!alunoOpt.isPresent()) {
            response.setMessage("Usuário ou Email não cadastrado");
            response.setStatus(404);
            return response;
        }

        AlunoEntitys aluno = alunoOpt.get();

        // Verificar senha
        if (!passwordEncoder.matches(log.getPass(), aluno.getPass())) {
            response.setMessage("Senha inválida");
            response.setStatus(401);
            return response;
        }

        response.setMessage("Login realizado com sucesso");
        response.setStatus(200);
        return response;
    } catch (Exception e) {
        response.setStatus(500);
        response.setMessage("Erro ao realizar login: " + e.getMessage());
        return response;
    }
}

    public ResponseModel createAluno(AlunoDto log){
        ResponseModel response = new ResponseModel();
        try{
            if(alunoRepo.existsByEmail(log.getEmail()) || alunoRepo.existsByUsername(log.getUsername()))
            {
                response.setMessage("Usuario ou Email já cadastrado");
                response.setStatus(409);
                return response;
            }
            AlunoEntitys newAluno = new AlunoEntitys();
            newAluno.setUsername(log.getUsername());
            newAluno.setEmail(log.getEmail());
            newAluno.setPass(passwordEncoder.encode(log.getPass()));
            alunoRepo.save(newAluno);
            response.setMessage("Cadastro realizado com sucesso");
            response.setStatus(200);
            return response;
        }
        catch(Exception e){
            response.setStatus(500);
            response.setMessage("Erro ao realizar cadastro: " + e.getMessage());        
            return response;
        }
    }

 
}
