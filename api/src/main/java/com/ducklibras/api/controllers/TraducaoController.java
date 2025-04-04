package com.ducklibras.api.controllers;

import com.ducklibras.api.models.entitys.TraducaoEntity;
import com.ducklibras.api.services.TraducaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/traducoes")
public class TraducaoController {

    @Autowired
    private TraducaoService traducaoService;

    @PostMapping
    public ResponseEntity<TraducaoEntity> criarTraducao(@RequestBody TraducaoEntity traducao) {
        TraducaoEntity novaTraducao = traducaoService.criarTraducao(traducao);
        return ResponseEntity.ok(novaTraducao);
    }

    @GetMapping
    public ResponseEntity<List<TraducaoEntity>> listarTraducoes() {
        List<TraducaoEntity> traducoes = traducaoService.listarTraducoes();
        return ResponseEntity.ok(traducoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TraducaoEntity> buscarTraducaoPorId(@PathVariable Long id) {
        Optional<TraducaoEntity> traducao = traducaoService.buscarTraducaoPorId(id);
        return traducao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TraducaoEntity> atualizarTraducao(@PathVariable Long id, @RequestBody TraducaoEntity traducaoAtualizada) {
        TraducaoEntity traducao = traducaoService.atualizarTraducao(id, traducaoAtualizada);
        return ResponseEntity.ok(traducao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTraducao(@PathVariable Long id) {
        traducaoService.deletarTraducao(id);
        return ResponseEntity.noContent().build();
    }
}
