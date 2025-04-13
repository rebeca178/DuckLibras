package com.ducklibras.api.controllers;

import com.ducklibras.api.models.entitys.AnotacaoEntity;
import com.ducklibras.api.models.repo.AnotacaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/anotacoes")
public class AnotacaoController {

    private final AnotacaoRepository anotacaoRepository;

    public AnotacaoController(AnotacaoRepository anotacaoRepository) {
        this.anotacaoRepository = anotacaoRepository;
    }

    @GetMapping
    public List<AnotacaoEntity> listarAnotacoes() {
        return anotacaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnotacaoEntity> buscarPorId(@PathVariable Long id) {
        Optional<AnotacaoEntity> anotacao = anotacaoRepository.findById(id);
        return anotacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public AnotacaoEntity criarAnotacao(@RequestBody AnotacaoEntity anotacao) {
        return anotacaoRepository.save(anotacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnotacaoEntity> atualizarAnotacao(@PathVariable Long id, @RequestBody AnotacaoEntity anotacaoAtualizada) {
        if (!anotacaoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        anotacaoAtualizada.setId(id);
        return ResponseEntity.ok(anotacaoRepository.save(anotacaoAtualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAnotacao(@PathVariable Long id) {
        if (anotacaoRepository.existsById(id)) {
            anotacaoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
