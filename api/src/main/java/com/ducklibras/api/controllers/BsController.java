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
            @RequestParam Long studentId,
            @RequestParam int requiredLevel) {
        
        boolean canAccess = boardSquareService.canAccessBoardSquare(studentId, boardSquareId, requiredLevel);
        
        if (canAccess) {
            return ResponseEntity.ok().body(Map.of(
                "canAccess", true,
                "message", "Student can access this Board Square"
            ));
        } else {
            return ResponseEntity.badRequest().body(Map.of(
                "canAccess", false,
                "message", "Student cannot access this Board Square"
            ));
        }
    }
    
    @PostMapping("/{boardSquareId}/complete")
    public ResponseEntity<?> completeBoardSquare(
            @PathVariable Long boardSquareId,
            @RequestParam Long studentId) {
        
        boardSquareService.completeBoardSquare(studentId, boardSquareId);
        return ResponseEntity.ok().body(Map.of(
            "success", true,
            "message", "Board Square marked as completed"
        ));
    }
    
    @GetMapping("/{boardSquareId}/lessons")
    public ResponseEntity<?> getLessonsForBoardSquare(@PathVariable Long boardSquareId) {
        // Simulação - na prática, isso viria de um repositório de aulas
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
        // Simulação - na prática, isso viria de um repositório de flashcards
        return ResponseEntity.ok().body(Map.of(
            "flashcards", new String[]{
                "Flashcard 1: Definition",
                "Flashcard 2: Question",
                "Flashcard 3: Challenge"
            }
        ));
    }
}
