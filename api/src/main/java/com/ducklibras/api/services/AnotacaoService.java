package com.ducklibras.api.services;

import com.ducklibras.api.models.entitys.AnotacaoEntity;
import com.ducklibras.api.models.repo.AnotacaoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AnotacaoService {

    private AnotacaoRepository anotacaoRepository;

    public AnotacaoEntity criarAnotacao(AnotacaoEntity anotacao) {
        return anotacaoRepository.save(anotacao);
    }

    public Optional<AnotacaoEntity> buscarPorId(Long id) {
        return anotacaoRepository.findById(id);
    }

    public void deletarAnotacao(Long id) {
        anotacaoRepository.deleteById(id);
    }

    public List<AnotacaoEntity> listarTodas() {
        return anotacaoRepository.findAll();
    }
}
