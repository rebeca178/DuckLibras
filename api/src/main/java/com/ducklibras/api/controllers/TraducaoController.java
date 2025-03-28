package com.ducklibras.api.controllers;

import com.ducklibras.api.models.dtos.TraducaoDTO;
import com.ducklibras.api.models.entitys.Traducao;
import com.ducklibras.api.models.repo.TraducaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/traducoes")
public class TraducaoController {

    @Autowired
    private TraducaoRepository traducaoRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Método para listar todas as traduções
    @GetMapping
    public List<TraducaoDTO> getAllTraducoes() {
        List<Traducao> traducoes = traducaoRepository.findAll();
        return traducoes.stream()
                .map(traducao -> modelMapper.map(traducao, TraducaoDTO.class))
                .collect(Collectors.toList());
    }

    // Método para criar uma tradução
    @PostMapping
    public ResponseEntity<TraducaoDTO> createTraducao(@RequestBody TraducaoDTO traducaoDTO) {
        Traducao traducao = modelMapper.map(traducaoDTO, Traducao.class);
        Traducao savedTraducao = traducaoRepository.save(traducao);
        TraducaoDTO savedTraducaoDTO = modelMapper.map(savedTraducao, TraducaoDTO.class);
        return ResponseEntity.ok(savedTraducaoDTO);
    }

    // Método para atualizar uma tradução
    @PutMapping("/{id}")
    public ResponseEntity<TraducaoDTO> updateTraducao(@PathVariable Long id, @RequestBody TraducaoDTO traducaoDTO) {
        if (!traducaoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Traducao traducao = modelMapper.map(traducaoDTO, Traducao.class);
        traducao.setId(id);
        Traducao updatedTraducao = traducaoRepository.save(traducao);
        TraducaoDTO updatedTraducaoDTO = modelMapper.map(updatedTraducao, TraducaoDTO.class);

        return ResponseEntity.ok(updatedTraducaoDTO);
    }

    // Método para buscar uma tradução por ID
    @GetMapping("/{id}")
    public ResponseEntity<TraducaoDTO> getTraducaoById(@PathVariable Long id) {
        return traducaoRepository.findById(id)
                .map(traducao -> modelMapper.map(traducao, TraducaoDTO.class))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Método para deletar uma tradução
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTraducao(@PathVariable Long id) {
        if (!traducaoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        traducaoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
