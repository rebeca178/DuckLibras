package com.ducklibras.api.services;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BsService {
    private final Map<Long, Map<Long, Boolean>> studentBoardStatus = new ConcurrentHashMap<>();
    private final Map<Long, Integer> studentLevels = new ConcurrentHashMap<>();
    

    public boolean canAccessBoardSquare(Long studentId, Long boardSquareId, int requiredLevel) {

        Integer studentLevel = studentLevels.getOrDefault(studentId, 0);
        if (studentLevel < requiredLevel) {
            return false;
        }
        

        return !studentBoardStatus.getOrDefault(studentId, new ConcurrentHashMap<>())
                                 .getOrDefault(boardSquareId, false);
    }
    
 
    public void completeBoardSquare(Long studentId, Long boardSquareId) {
        studentBoardStatus.computeIfAbsent(studentId, _ -> new ConcurrentHashMap<>())
                         .put(boardSquareId, true);
    }
    

    public void updateStudentLevel(Long studentId, int newLevel) {
        studentLevels.put(studentId, newLevel);
    }
}
