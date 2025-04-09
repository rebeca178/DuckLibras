package com.ducklibras.api.models.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ducklibras.api.models.entitys.aulas;

import java.util.List;

@Repository
public interface repoaulas extends JpaRepository<aulas, Long> {
    @Query("SELECT r FROM repoaulasEntity r WHERE r.someField = ?1")
    List<aulas> findBySomeField(String someField);
}

