package com.ducklibras.api.services;

import org.springframework.stereotype.Service;

import com.ducklibras.api.models.dtos.BsDto;
import com.ducklibras.api.models.dtos.PontuacaoDto;
import com.ducklibras.api.models.entitys.BsEntitys;
import com.ducklibras.api.models.entitys.PontuacaoEntity;
import com.ducklibras.api.models.repo.BsRepo;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class BsService {

    @Autowired
    private BsRepo bsRepo;

    // abri bs
    public Optional<BsDto> abrirBs (Long alunoId, int nivel,boolean status) {
        BsEntitys nivelBs = bsRepo.findById(alunoId).get();
        if(nivelBs == null) return Optional.empty();



    }

    
}
