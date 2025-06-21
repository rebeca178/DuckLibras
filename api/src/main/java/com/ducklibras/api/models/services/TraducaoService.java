package com.ducklibras.api.models.services;

import com.ducklibras.api.models.entitys.TraducaoEntity;
import com.ducklibras.api.models.repo.TraducaoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TraducaoService {
    
    private TraducaoRepository traducaoRepository;

    public TraducaoEntity salvarTraducao(TraducaoEntity traducao) {
        return traducaoRepository.save(traducao);
    }

    public List<TraducaoEntity> listarTodas() {
        return traducaoRepository.findAll();
    }

    public Optional<TraducaoEntity> buscarPorId(Long id) {
        return traducaoRepository.findById(id);
    }

    public TraducaoEntity atualizarTraducao(Long id, TraducaoEntity traducaoAtualizada) {
        return traducaoRepository.findById(id).map(traducao -> {
            traducao.setTextoOriginal(traducaoAtualizada.getTextoOriginal());
            traducao.setTextoTraduzido(traducaoAtualizada.getTextoTraduzido());
            traducao.setIdiomaOrigem(traducaoAtualizada.getIdiomaOrigem());
            traducao.setIdiomaDestino(traducaoAtualizada.getIdiomaDestino());
            return traducaoRepository.save(traducao);
        }).orElseThrow(() -> new RuntimeException("Tradução não encontrada."));
    }

    public void deletarTraducao(Long id) {
        traducaoRepository.deleteById(id);
    }
}
