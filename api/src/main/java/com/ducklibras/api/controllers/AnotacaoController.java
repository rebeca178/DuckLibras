package com.ducklibras.api.controllers;

import com.ducklibras.api.models.entitys.AnotacaoEntity;
import com.ducklibras.api.models.repo.AnotacaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/anotacoes")
public class AnotacaoController {

    private final AnotacaoRepository anotacaoRepository;

    public AnotacaoController(AnotacaoRepository anotacaoRepository) {
        this.anotacaoRepository = anotacaoRepository;
    }

    @GetMapping
    public ResponseEntity<List<AnotacaoEntity>> listarAnotacoes() {
        List<AnotacaoEntity> anotacoes = anotacaoRepository.findAll();
        return ResponseEntity.ok(anotacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnotacaoEntity> buscarPorId(@PathVariable Long id) {
        Optional<AnotacaoEntity> anotacao = anotacaoRepository.findById(id);
        return anotacao.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AnotacaoEntity> criarAnotacao(@RequestBody AnotacaoEntity anotacao) {
        AnotacaoEntity novaAnotacao = anotacaoRepository.save(anotacao);
        return ResponseEntity.ok(novaAnotacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnotacaoEntity> atualizarAnotacao(@PathVariable Long id, @RequestBody AnotacaoEntity anotacaoAtualizada) {
        return anotacaoRepository.findById(id)
                .map(anotacao -> {
                    anotacao.setTitulo(anotacaoAtualizada.getTitulo());
                    anotacao.setConteudo(anotacaoAtualizada.getConteudo());
                    anotacaoRepository.save(anotacao);
                    return ResponseEntity.ok(anotacao);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAnotacao(@PathVariable Long id) {
        return anotacaoRepository.findById(id)
                .map(anotacao -> {
                    anotacaoRepository.delete(anotacao);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
