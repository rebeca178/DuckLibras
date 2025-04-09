package com.ducklibras.api.models.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Date;
import java.util.List;

public interface eventsrepo extends JpaRepository<EventsEntity, Long> {

    @Query("SELECT e FROM EventsEntity e WHERE e.eventName = ?1")
    List<EventsEntity> findByEventName(String eventName);

    boolean existsByInitDateAndEndDateAndInstituteId(Date initDate, Date endDate, Long instituteId);
}
