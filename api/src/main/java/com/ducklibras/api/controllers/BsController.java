package com.ducklibras.api.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ducklibras.api.services.BsService;

@RestController
@RequestMapping("/api/board-squares")
public class BsController {

    private BsService boardSquareService;
    
    @GetMapping("/{boardSquareId}/access")
    public ResponseEntity<Map<String, Object>> checkAccess(
            @PathVariable Long boardSquareId,
            @RequestParam Long alunoId,
            @RequestParam int nivelRequerido) {
        
        boolean acesso = boardSquareService.acessoBoardSquare(alunoId, boardSquareId, nivelRequerido);
        
        if (acesso) {
            return ResponseEntity.ok().body(Map.of(
                "acesso", true,
                "a", "Aluno pode ter acesso ao BS"
            ));
        } else {
            return ResponseEntity.badRequest().body(Map.of(
                "acesso", false,
                "message", "Aluno nao pode ter acesso ao BS"
            ));
        }
    }
    
    @PostMapping("/{boardSquareId}/complete")
    public ResponseEntity<Map<String, Object>> completeBoardSquare(
            @PathVariable Long boardSquareId,
            @RequestParam Long alunoId) {
        
        boardSquareService.completeBoardSquare(alunoId, boardSquareId);
        return ResponseEntity.ok().body(Map.of(
            "sucesso", true,
            "message", "Board Square completo"
        ));
    }
    
    @GetMapping("/{boardSquareId}/lessons")
    public ResponseEntity<Map<String, Object>> getLessonsForBoardSquare(@PathVariable Long boardSquareId) {
        return ResponseEntity.ok().body(Map.of(
            "lessons", new String[]{
            }
        ));
    }
    
    @GetMapping("/{boardSquareId}/flashcards")
    public ResponseEntity<Map<String, Object>> getFlashcardsForBoardSquare(@PathVariable Long boardSquareId) {
        return ResponseEntity.ok().body(Map.of(
            "flashcards", new String[]{
            }
        ));
    }
}
