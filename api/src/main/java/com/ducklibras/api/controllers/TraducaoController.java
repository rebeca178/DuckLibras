package com.ducklibras.api.controllers;

import com.ducklibras.api.models.dtos.TraducaoDTO;
import com.ducklibras.api.models.entitys.Traducao;
import com.ducklibras.api.models.repo.TraducaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/traducao")
public class TraducaoController {

    @Autowired
    private TraducaoRepository traducaoRepository;

    @GetMapping
    public List<TraducaoDTO> listar() {
        return traducaoRepository.findAll().stream()
                .map(traducao -> new TraducaoDTO(traducao.getId(), traducao.getTextoOriginal(), traducao.getTextoTraduzido()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<TraducaoDTO> adicionar(@RequestBody TraducaoDTO dto) {
        Traducao traducao = new Traducao(null, dto.getTextoOriginal(), dto.getTextoTraduzido());
        traducao = traducaoRepository.save(traducao);
        return ResponseEntity.ok(new TraducaoDTO(traducao.getId(), traducao.getTextoOriginal(), traducao.getTextoTraduzido()));
    }
}
