package com.ducklibras.api.controllers;

import com.ducklibras.api.models.entitys.DicionarioLibrasEntity;
import com.ducklibras.api.models.repo.DicionarioLibrasRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dicionario")
public class DicionarioController {

    @Autowired
    private DicionarioLibrasRepo dicionarioLibrasRepo;

    // Listar todas as palavras
    @GetMapping
    public List<DicionarioLibrasEntity> listarPalavras() {
        return dicionarioLibrasRepo.findAll();
    }

    // Adicionar uma nova palavra
    @PostMapping
    public DicionarioLibrasEntity adicionarPalavra(@RequestBody DicionarioLibrasEntity novaPalavra) {
        return dicionarioLibrasRepo.save(novaPalavra);
    }
}
