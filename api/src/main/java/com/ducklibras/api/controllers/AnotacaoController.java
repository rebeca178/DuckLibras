package com.ducklibras.api.controllers;

import com.ducklibras.api.models.entitys.Anotacao;
import com.ducklibras.api.models.repo.AnotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anotacoes")
public class AnotacaoController {

    @Autowired
    private AnotacaoRepository anotacaoRepository;

    @GetMapping
    public List<Anotacao> getAllAnotacoes() {
        return anotacaoRepository.findAll();
    }

    @PostMapping
    public Anotacao createAnotacao(@RequestBody Anotacao anotacao) {
        return anotacaoRepository.save(anotacao);
    }
}
