package com.ducklibras.api.models.services;

import com.ducklibras.api.models.dtos.PontuacaoDto;
import com.ducklibras.api.models.entitys.PontuacaoEntity;
import com.ducklibras.api.models.repo.PontuacaoRepo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PontuacaoService {


    @Autowired

    private PontuacaoRepo pontuacaoRepo;

    /**
     * Adiciona pontos ao usuário e atualiza o nível, se necessário.
     *
     * @param userId ID do usuário.
     * @param pontos Pontos a serem adicionados.
     * @return A entidade de pontuação atualizada.
     */
    public Optional<PontuacaoDto> adicionarPontos(Long userId, int pontos) {

        PontuacaoEntity pontuacao = pontuacaoRepo.findById(userId).get();
        if(pontuacao == null) return Optional.empty();

        Optional<PontuacaoEntity> optionalPontuacao = pontuacaoRepo.findById(userId);
        if (!optionalPontuacao.isPresent()) return Optional.empty();
        pontuacao = optionalPontuacao.get();


        // Adiciona os pontos
        pontuacao.setPontos(pontuacao.getPontos() + pontos);

        // Atualiza o nível com base na pontuação
        atualizarNivel(pontuacao);

        return Optional.of(new PontuacaoDto(pontuacaoRepo.save(pontuacao)));
    }

    /**
     * Atualiza o nível do usuário com base na pontuação acumulada.
     *
     * @param pontuacao A entidade de pontuação do usuário.
     */
    private void atualizarNivel(PontuacaoEntity pontuacao) {
        int pontos = pontuacao.getPontos();
        int novoNivel = calcularNivel(pontos);

        if (novoNivel > pontuacao.getNivel()) {
            pontuacao.setNivel(novoNivel);
        }
    }

    /**
     * Calcula o nível com base na pontuação.
     *
     * @param pontos Pontuação acumulada.
     * @return O nível correspondente.
     */
    private int calcularNivel(int pontos) {
        // Exemplo de lógica de cálculo de nível
        if (pontos < 100) {
            return 1;
        } else if (pontos < 500) {
            return 2;
        } else if (pontos < 1000) {
            return 3;
        } else {
            return 4 + (pontos / 1000); // Níveis adicionais a cada 1000 pontos
        }
    }

}


