package com.ducklibras.api.controllers;

import com.ducklibras.api.models.dtos.PontuacaoDto;
import com.ducklibras.api.services.PontuacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/pontuacao")
public class PontuacaoController {

    @Autowired
    private PontuacaoService pontuacaoService;

    // Adicionar pontos
    @PostMapping("/{id}/adicionar")
    public ResponseEntity<PontuacaoDto> adicionarPontos(@PathVariable Long id, @RequestParam int pontos) {
        Optional<PontuacaoDto> pontuacaoAtualizada = pontuacaoService.adicionarPontos(id, pontos);
        return pontuacaoAtualizada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Remover pontos
    @PostMapping("/{id}/remover")
    public ResponseEntity<PontuacaoDto> removerPontos(@PathVariable Long id, @RequestParam int pontos) {
        Optional<PontuacaoDto> pontuacaoAtualizada = pontuacaoService.adicionarPontos(id, -pontos);
        return pontuacaoAtualizada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
