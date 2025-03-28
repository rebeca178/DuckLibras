package com.ducklibras.api.controllers;

import com.ducklibras.api.models.dtos.AnotacaoDTO;
import com.ducklibras.api.models.entitys.Anotacao;
import com.ducklibras.api.models.repo.AnotacaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/anotacoes")
public class AnotacaoController {

    @Autowired
    private AnotacaoRepository anotacaoRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Método para listar todas as anotações
    @GetMapping
    public List<AnotacaoDTO> getAllAnotacoes() {
        List<Anotacao> anotacoes = anotacaoRepository.findAll();
        return anotacoes.stream()
                .map(anotacao -> modelMapper.map(anotacao, AnotacaoDTO.class))
                .collect(Collectors.toList());
    }

    // Método para criar uma anotação
    @PostMapping
    public ResponseEntity<AnotacaoDTO> createAnotacao(@RequestBody AnotacaoDTO anotacaoDTO) {
        Anotacao anotacao = modelMapper.map(anotacaoDTO, Anotacao.class);
        Anotacao savedAnotacao = anotacaoRepository.save(anotacao);
        AnotacaoDTO savedAnotacaoDTO = modelMapper.map(savedAnotacao, AnotacaoDTO.class);
        return ResponseEntity.ok(savedAnotacaoDTO);
    }

    // Método para atualizar uma anotação
    @PutMapping("/{id}")
    public ResponseEntity<AnotacaoDTO> updateAnotacao(@PathVariable Long id, @RequestBody AnotacaoDTO anotacaoDTO) {
        if (!anotacaoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Anotacao anotacao = modelMapper.map(anotacaoDTO, Anotacao.class);
        anotacao.setId(id);
        Anotacao updatedAnotacao = anotacaoRepository.save(anotacao);
        AnotacaoDTO updatedAnotacaoDTO = modelMapper.map(updatedAnotacao, AnotacaoDTO.class);

        return ResponseEntity.ok(updatedAnotacaoDTO);
    }

    // Método para buscar uma anotação por ID
    @GetMapping("/{id}")
    public ResponseEntity<AnotacaoDTO> getAnotacaoById(@PathVariable Long id) {
        return anotacaoRepository.findById(id)
                .map(anotacao -> modelMapper.map(anotacao, AnotacaoDTO.class))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Método para deletar uma anotação
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnotacao(@PathVariable Long id) {
        if (!anotacaoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        anotacaoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
