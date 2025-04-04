package com.ducklibras.api.services;

import com.ducklibras.api.models.entitys.AnotacaoEntity;
import com.ducklibras.api.repositories.AnotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnotacaoService {

    @Autowired
    private AnotacaoRepository anotacaoRepository;

    public AnotacaoEntity criarAnotacao(AnotacaoEntity anotacao) {
        return anotacaoRepository.save(anotacao);
    }

    public Optional<AnotacaoEntity> buscarPorId(Long id) {
        return anotacaoRepository.findById(id);
    }

    public AnotacaoEntity atualizarAnotacao(Long id, AnotacaoEntity novaAnotacao) {
        return anotacaoRepository.findById(id).map(anotacao -> {
            anotacao.setTitulo(novaAnotacao.getTitulo());
            anotacao.setDescricao(novaAnotacao.getDescricao());
            anotacao.setDataCriacao(novaAnotacao.getDataCriacao());
            return anotacaoRepository.save(anotacao);
        }).orElseThrow(() -> new RuntimeException("Anotação não encontrada"));
    }

    public void deletarAnotacao(Long id) {
        anotacaoRepository.deleteById(id);
    }

    public List<AnotacaoEntity> listarTodas() {
        return anotacaoRepository.findAll();
    }

    public List<AnotacaoEntity> buscarPorTitulo(String titulo) {
        return anotacaoRepository.findByTituloContainingIgnoreCase(titulo);
    }

    public List<AnotacaoEntity> buscarPorPeriodo(String dataInicio, String dataFim) {
        return anotacaoRepository.findByDataCriacaoBetween(dataInicio, dataFim);
    }
}
