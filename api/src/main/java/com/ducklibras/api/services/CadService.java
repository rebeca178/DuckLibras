package com.ducklibras.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public AlunoEntitys createUsers(AlunoInDto user) {

        return (ValidateUsers(user.getUsername(), user.getEmail())) 
        ? alunoRepo.save(new AlunoEntitys(user)) 
        : alunoRepo.findByUsernameAndEmail(user.getUsername(), user.getEmail()).get();

    }

    /*
     * Name: [NF012] Validate User
     * Description: Method to validate if the user already exists
     * Author: Kevin da Costa Vinagre
    */
    public boolean ValidateUsers(String username, String email){
        return alunoRepo.findByUsernameAndEmail(username, email).isEmpty();
    }

}