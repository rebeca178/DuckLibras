package com.example.demo.controllers;

import com.example.demo.models.dtos.AnotacaoDTO;
import com.example.demo.models.entitys.AnotacaoENTITYS;
import com.example.demo.models.repositorios.AnotacaoREPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/anotacoes")
public class AnotacaoCONTROLLER {

    @Autowired
    private AnotacaoREPO anotacaoREPO;

    @GetMapping
    public List<AnotacaoENTITYS> listarTodas() {
        return anotacaoREPO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnotacaoENTITYS> buscarPorId(@PathVariable Long id) {
        Optional<AnotacaoENTITYS> anotacao = anotacaoREPO.findById(id);
        return anotacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public AnotacaoENTITYS criar(@RequestBody AnotacaoDTO anotacaoDTO) {
        AnotacaoENTITYS novaAnotacao = new AnotacaoENTITYS(anotacaoDTO);
        return anotacaoREPO.save(novaAnotacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnotacaoENTITYS> atualizar(@PathVariable Long id, @RequestBody AnotacaoDTO anotacaoDTO) {
        if (!anotacaoREPO.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        AnotacaoENTITYS anotacaoAtualizada = new AnotacaoENTITYS(anotacaoDTO);
        anotacaoAtualizada.setId(id);
        return ResponseEntity.ok(anotacaoREPO.save(anotacaoAtualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!anotacaoREPO.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        anotacaoREPO.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
