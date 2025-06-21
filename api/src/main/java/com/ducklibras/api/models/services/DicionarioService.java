package com.ducklibras.api.models.services;

import com.ducklibras.api.models.entitys.DicionarioLibrasEntity;
import com.ducklibras.api.models.repo.DicionarioLibrasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DicionarioService {

    @Autowired
    private DicionarioLibrasRepo dicionarioLibrasRepo;

    /**
     * Busca sinais no dicionário com base em uma palavra-chave.
     *
     * @param palavraChave A palavra-chave para buscar sinais.
     * @return Lista de sinais que correspondem à palavra-chave.
     */
    public Optional<List<DicionarioLibrasEntity>> buscarPorPalavra(String palavraChave) {
        return Optional.of(dicionarioLibrasRepo.findByPalavraContainingIgnoreCase(palavraChave));
    }
}