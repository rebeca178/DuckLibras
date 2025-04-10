package com.ducklibras.api.models.repo;

import com.ducklibras.api.models.entitys.DicionarioLibrasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DicionarioLibrasRepo extends JpaRepository<DicionarioLibrasEntity, Long> {

    /**
     * Busca sinais que contenham a palavra-chave, ignorando maiúsculas e minúsculas.
     *
     * @param palavra A palavra-chave para buscar.
     * @return Lista de sinais que correspondem à palavra-chave.
     */
    List<DicionarioLibrasEntity> findByPalavraContainingIgnoreCase(String palavra);

