package com.ms.dr.repository;

import com.ms.dr.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByDateTimeAfter(LocalDateTime dateTime);
}

