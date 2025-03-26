package com.ducklibras.api.controllers;

import com.ducklibras.api.models.dtos.AnotacaoDTO;
import com.ducklibras.api.models.entitys.Anotacao;
import com.ducklibras.api.models.entitys.Traducao;
import com.ducklibras.api.models.repo.AnotacaoRepository;
import com.ducklibras.api.models.repo.TraducaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/anotacao")
public class AnotacaoController {

    @Autowired
    private AnotacaoRepository anotacaoRepository;

    @Autowired
    private TraducaoRepository traducaoRepository;

    @GetMapping
    public List<AnotacaoDTO> listar() {
        return anotacaoRepository.findAll().stream()
                .map(anotacao -> new AnotacaoDTO(anotacao.getId(), anotacao.getDescricao(), anotacao.getTraducao().getId()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<AnotacaoDTO> adicionar(@RequestBody AnotacaoDTO dto) {
        Traducao traducao = traducaoRepository.findById(dto.getTraducaoId()).orElse(null);
        if (traducao == null) {
            return ResponseEntity.badRequest().build();
        }

        Anotacao anotacao = new Anotacao(null, dto.getDescricao(), traducao);
        anotacao = anotacaoRepository.save(anotacao);
        return ResponseEntity.ok(new AnotacaoDTO(anotacao.getId(), anotacao.getDescricao(), anotacao.getTraducao().getId()));
    }
}
