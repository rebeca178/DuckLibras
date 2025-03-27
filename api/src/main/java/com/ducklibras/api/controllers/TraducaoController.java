package com.ducklibras.api.controllers;

import com.ducklibras.api.models.entitys.Traducao;
import com.ducklibras.api.models.repo.TraducaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/traducoes")
public class TraducaoController {

    @Autowired
    private TraducaoRepository traducaoRepository;

    @GetMapping
    public List<Traducao> getAllTraducoes() {
        return traducaoRepository.findAll();
    }

    @PostMapping
    public Traducao createTraducao(@RequestBody Traducao traducao) {
        return traducaoRepository.save(traducao);
    }
}
