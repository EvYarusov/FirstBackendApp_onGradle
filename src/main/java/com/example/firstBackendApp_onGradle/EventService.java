package com.example.firstBackendApp_onGradle;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EventService {

    static final ArrayList<EventDTO> EVENTS = new ArrayList<EventDTO>() {{
        add(new EventDTO("Violin concert", "Prague"));
        add(new EventDTO("Jazz concert", "Berlin"));
        add(new EventDTO("Art exhibition", "London"));
        add(new EventDTO("Opera", "London"));
    }};

    public List<EventDTO> getAllEvents(String city) {

        List<EventDTO> resultEventDTOS = EVENTS;

        if (!city.equals("all")) {
            resultEventDTOS = EVENTS.stream()
                    .filter(e -> e.getCity().equals(city)).collect(Collectors.toList());
        }

        return resultEventDTOS;
    }

    public EventDTO getEventById(int eventId) {

        EventDTO eventDTO = EVENTS.get(eventId);

        return eventDTO;
    }

    public EventDTO deleteEventById(int eventId) {

        //TODO: add real remove
        EventDTO eventDTO = EVENTS.get(eventId);

        return eventDTO;
    }

    public EventDTO updateEventById(int eventId, EventDTO newEventDTO) {

        EventDTO eventDTO = EVENTS.get(eventId);
        //TODO: update event in database
        eventDTO = newEventDTO; // useless. just for example

        return eventDTO;
    }

    public EventDTO createNewEvent(EventDTO eventDTO) {

        // TODO save to database
        return eventDTO;
    }
}
