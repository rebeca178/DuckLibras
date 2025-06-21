package com.ducklibras.api.controllers;

import com.ducklibras.api.models.dtos.AnotacaoDTO;
import com.ducklibras.api.models.dtos.AnotacaoinDto;
import com.ducklibras.api.models.entitys.AnotacaoEntity;
import com.ducklibras.api.models.repo.AnotacaoRepository;
import com.ducklibras.api.models.services.AnotacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/anotacoes")
public class AnotacaoController {

    @Autowired 
    private AnotacaoService anotacaoservice;

    private final AnotacaoRepository anotacaoRepository;

    public AnotacaoController(AnotacaoRepository anotacaoRepository) {
        this.anotacaoRepository = anotacaoRepository;
    }

    @GetMapping
    public List<AnotacaoDTO> listarAnotacoes() {
    return anotacaoRepository.findAll()
        .stream()
        .map(AnotacaoDTO::new)
        .toList();
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

    @PostMapping("/cadA")
    public ResponseEntity<String> teste(@RequestBody AnotacaoinDto aula) {
        String response = anotacaoservice.createAula(aula);
        return (response.equals("Aula Cadastrada com Sucesso"))
        ?ResponseEntity.status(404).body(response)
        :ResponseEntity.status(202).body(response);
    }
    
}
