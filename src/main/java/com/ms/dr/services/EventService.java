package com.ms.dr.services;

import com.ms.dr.exception.ResourceNotFoundException;
import com.ms.dr.model.Event;
import com.ms.dr.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    public Event updateEvent(Long id, Event eventDetails) {
        Event event = getEventById(id);
        event.setDateTime(eventDetails.getDateTime());
        event.setVenue(eventDetails.getVenue());
        event.setNumbCase(eventDetails.getNumbCase());
        event.setShortTitle(eventDetails.getShortTitle());
        event.setDescription(eventDetails.getDescription());
        event.setRequirements(eventDetails.getRequirements());
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        Event event = getEventById(id);
        eventRepository.delete(event);
    }

    public List<Event> findUpcomingEvents(LocalDateTime dateTime) {
        return eventRepository.findByDateTimeAfter(dateTime);
    }
}

