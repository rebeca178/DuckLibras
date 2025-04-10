package com.ducklibras.api.services;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BsService {
    private final Map<Long, Map<Long, Boolean>> alunoBoardStatus = new ConcurrentHashMap<>();
    private final Map<Long, Integer> alunoNivel = new ConcurrentHashMap<>();

    public boolean acessoBoardSquare(Long alunoId, Long boardSquareId, int nivelRequerido) {
        Integer nivelDoAluno = alunoNivel.getOrDefault(alunoId, 1);
        if (nivelDoAluno < nivelRequerido) {
            return false;
        }
        return !alunoBoardStatus
                .getOrDefault(alunoId, new ConcurrentHashMap<>())
                .getOrDefault(boardSquareId, false);
    }

    public void completeBoardSquare(Long alunoId, Long boardSquareId) {
        alunoBoardStatus
                .computeIfAbsent(alunoId, _ -> new ConcurrentHashMap<>())
                .put(boardSquareId, true);
    }

    public void updateStudentLevel(Long studentId, int newLevel) {
        alunoNivel.put(studentId, newLevel);
    }
}