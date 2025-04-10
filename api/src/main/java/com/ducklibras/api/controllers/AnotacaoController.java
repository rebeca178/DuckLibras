package com.ducklibras.api.controllers;

import com.ducklibras.api.models.repo.AnotacaoRepository;
import org.springframework.web.bind.annotation.*;


@RestController
public class AnotacaoController {

    private AnotacaoRepository anotacaoRepository;


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarAnotacao(@PathVariable Long id) {
        return anotacaoRepository.findById(id)
                .map(anotacao -> {
                    anotacaoRepository.delete(anotacao);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());

    public AnotacaoRepository getAnotacaoRepository() {
        return anotacaoRepository;

    }
}
