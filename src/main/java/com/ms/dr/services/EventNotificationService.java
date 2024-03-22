package com.ms.dr.services;

import com.ms.dr.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate; // Import added
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventNotificationService {

    @Autowired
    private EventService eventService;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate; // Autowired instance

    @Scheduled(fixedRate = 60000) // Check every minute
    public void checkUpcomingEventsAndNotify() {
        LocalDateTime now = LocalDateTime.now();
        List<Event> upcomingEvents = eventService.findUpcomingEvents(now);

        for (Event event : upcomingEvents) {
            // Prepare the notification message
            String message = "Upcoming event: " + event.getShortTitle() + " at " + event.getDateTime();

            // Send the notification to the dashboard
            simpMessagingTemplate.convertAndSend("/topic/upcomingEvents", message);
        }
    }
}
