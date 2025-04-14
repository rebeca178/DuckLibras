package com.ducklibras.api.controllers;

import com.ducklibras.api.models.entitys.FlashCardsEntity;
import com.ducklibras.api.services.FlashcardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/flashcards")
public class FlashCardsController {

    @Autowired
    private FlashcardService flashCardsService;

    @PutMapping("/{id}")
    public ResponseEntity<FlashCardsEntity> atualizarFlashCard(
            @PathVariable Long id,
            @RequestBody FlashCardsEntity novoFlashcard) {
                FlashCardsEntity atualizado = flashCardsService.atualizarFlashCard(id, novoFlashcard);
        return ResponseEntity.ok(atualizado);
    }
}