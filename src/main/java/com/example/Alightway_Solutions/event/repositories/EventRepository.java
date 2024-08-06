package com.example.Alightway_Solutions.event.repositories;

import com.example.Alightway_Solutions.event.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {
    EventEntity findByEventId(Long eventId);
}
