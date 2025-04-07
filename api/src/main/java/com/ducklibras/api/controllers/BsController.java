package com.ducklibras.api.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ducklibras.api.services.BsService;

@RestController
@RequestMapping("/api/board-squares")
public class BsController {
    
    @Autowired
    private BsService boardSquareService;
    
    @GetMapping("/{boardSquareId}/access")
    public ResponseEntity<?> checkAccess(
            @PathVariable Long boardSquareId,
            @RequestParam Long alunoId,
            @RequestParam int nivelRequerido) {
        
        boolean acesso = boardSquareService.acessoBoardSquare(alunoId, boardSquareId, nivelRequerido);
        
        if (acesso) {
            return ResponseEntity.ok().body(Map.of(
                "acesso", true,
                "message", "Aluno pode ter acesso ao BS"
            ));
        } else {
            return ResponseEntity.badRequest().body(Map.of(
                "acesso", false,
                "message", "Aluno nao pode ter acesso ao BS"
            ));
        }
    }
    
    @PostMapping("/{boardSquareId}/complete")
    public ResponseEntity<?> completeBoardSquare(
            @PathVariable Long boardSquareId,
            @RequestParam Long alunoId) {
        
        boardSquareService.completeBoardSquare(alunoId, boardSquareId);
        return ResponseEntity.ok().body(Map.of(
            "sucesso", true,
            "message", "Board Square completo"
        ));
    }
    
    @GetMapping("/{boardSquareId}/lessons")
    public ResponseEntity<?> getLessonsForBoardSquare(@PathVariable Long boardSquareId) {
        return ResponseEntity.ok().body(Map.of(
            "lessons", new String[]{
                "Lesson 1: Introduction",
                "Lesson 2: Basic Concepts",
                "Lesson 3: Advanced Topics"
            }
        ));
    }
    
    @GetMapping("/{boardSquareId}/flashcards")
    public ResponseEntity<?> getFlashcardsForBoardSquare(@PathVariable Long boardSquareId) {
        return ResponseEntity.ok().body(Map.of(
            "flashcards", new String[]{
                "Flashcard 1: Definition",
                "Flashcard 2: Question",
                "Flashcard 3: Challenge"
            }
        ));
    }
}
