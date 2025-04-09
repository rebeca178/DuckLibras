package com.ducklibras.api.controllers;

import com.ducklibras.api.models.repo.AnotacaoRepository;
import org.springframework.web.bind.annotation.*;


@RestController
public class AnotacaoController {

    private AnotacaoRepository anotacaoRepository;

    public AnotacaoRepository getAnotacaoRepository() {
        return anotacaoRepository;
    }
}
