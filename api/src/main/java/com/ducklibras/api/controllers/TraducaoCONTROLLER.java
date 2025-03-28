package com.seuprojeto.controllers;

import com.seuprojeto.models.dtos.TraducaoDTO;
import com.seuprojeto.models.entitys.TraducaoENTITYS;
import com.seuprojeto.models.repositorios.TraducaoREPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/traducao")
public class TraducaoCONTROLLER {

    @Autowired
    private TraducaoREPO traducaoRepo;

    @GetMapping
    public ResponseEntity<List<TraducaoENTITYS>> listarTodas() {
        List<TraducaoENTITYS> traducoes = traducaoRepo.findAll();
        return ResponseEntity.ok(traducoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TraducaoENTITYS> buscarPorId(@PathVariable Long id) {
        Optional<TraducaoENTITYS> traducao = traducaoRepo.findById(id);
        return traducao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TraducaoENTITYS> criarTraducao(@RequestBody TraducaoDTO traducaoDTO) {
        TraducaoENTITYS traducao = new TraducaoENTITYS(traducaoDTO);
        TraducaoENTITYS novaTraducao = traducaoRepo.save(traducao);
        return ResponseEntity.ok(novaTraducao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TraducaoENTITYS> atualizarTraducao(@PathVariable Long id, @RequestBody TraducaoDTO traducaoDTO) {
        if (!traducaoRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        TraducaoENTITYS traducaoAtualizada = new TraducaoENTITYS(traducaoDTO);
        traducaoAtualizada.setId(id);
        traducaoRepo.save(traducaoAtualizada);
        return ResponseEntity.ok(traducaoAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTraducao(@PathVariable Long id) {
        if (!traducaoRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        traducaoRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
