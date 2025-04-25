package com.ducklibras.api.models.repo;

import com.ducklibras.api.models.entitys.FlashCardsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FlashCardRepo extends JpaRepository<FlashCardsEntity, Long> {
    // Aqui você pode adicionar métodos personalizados, se necessário
    // Por exemplo, para buscar flashcards por algum critério específico
    // List<FlashCardsEntitys> findBySomeCriteria(String criteria);
}