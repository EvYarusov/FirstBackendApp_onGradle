package com.example.firstBackendApp_onGradle.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EventService {

    private EventRepository eventRepository;

    @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    static final ArrayList<EventDTO> EVENTS = new ArrayList<EventDTO>() {{
        add(new EventDTO("Violin concert", "Prague"));
        add(new EventDTO("Jazz concert", "Berlin"));
        add(new EventDTO("Art exhibition", "London"));
        add(new EventDTO("Opera", "London"));
    }};

    public int createNewEvent(EventDTO eventDTO) {

        String title = eventDTO.getTitle();
        String city = eventDTO.getCity();

        Event event = new Event();
        event.setTitle(title);
        event.setCity(city);

        int id = eventRepository.save(event).getId();

        return id;
    }

    public List<EventDTO> getEvents(String city) {

        Iterable<Event> allEvents = eventRepository.findAll();

        List<EventDTO> result = new ArrayList<>();
        for (Event event : allEvents)
        {
            if (city.equalsIgnoreCase("all") ^ event.getCity().equalsIgnoreCase(city))
            {
                EventDTO eventDTO = new EventDTO(event.getTitle(), event.getCity());
                result.add(eventDTO);
            }
        }
        return result;

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

}
