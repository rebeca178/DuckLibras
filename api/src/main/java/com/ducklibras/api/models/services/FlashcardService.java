package com.ducklibras.api.models.services;

import com.ducklibras.api.models.entitys.FlashCardsEntity;
import com.ducklibras.api.models.repo.FlashCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FlashcardService {

    @Autowired
    private FlashCardRepo flashCardRepo;

    public FlashCardsEntity createFlashcard(FlashCardsEntity flashcard) {
        return flashCardRepo.save(flashcard);
    }

    public FlashCardsEntity getFlashcardById(Long id) {
        return flashCardRepo.findById(id).orElse(null);
    }

    public void deleteFlashcard(Long id) {
        flashCardRepo.deleteById(id);
    }
    public FlashCardsEntity atualizarFlashCard(Long id, FlashCardsEntity novoFlashcard) {
        return flashCardRepo.findById(id).map(flashcard -> {
            flashcard.setQuest(novoFlashcard.getQuest());
            flashcard.setResposta(novoFlashcard.getResposta());
            return flashCardRepo.save(flashcard);
        }).orElseThrow(() -> new RuntimeException("Flashcard não encontrado"));
    }
}