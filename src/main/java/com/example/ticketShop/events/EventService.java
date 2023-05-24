package com.example.ticketShop.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EventService {

    private EventRepository eventRepository;

    @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    /*static final ArrayList<EventDTO> EVENTS = new ArrayList<EventDTO>() {{
        add(new EventDTO("Violin concert", "Prague"));
        add(new EventDTO("Jazz concert", "Berlin"));
        add(new EventDTO("Art exhibition", "London"));
        add(new EventDTO("Opera", "London"));
    }};*/

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

    public EventDTO getEventById(int eventId)
    {
        EventDTO eventDTO = new EventDTO();

        Optional<Event> eventOptional = eventRepository.findById(eventId);
        // Optional has 2 states:
        // 1. I`m empty. I have no value.
        // 2. Has value

        Event event = eventOptional.get(); // Exception if data not found
        eventDTO.setTitle(event.getTitle());
        eventDTO.setCity(event.getCity());
        return eventDTO;

        //TODO finish the handling of exception
        /*if (eventOptional.isPresent())
        {
            Event event = eventOptional.get();
            eventDTO.setTitle(event.getTitle());
            eventDTO.setCity(event.getCity());
            return eventDTO;
        }
        else
        {
            return eventOptional.;
        }*/
    }

    public EventDTO deleteEventById(int eventId) {

        EventDTO eventDTO = getEventById(eventId);

        eventRepository.deleteById(eventId);

        return eventDTO;
    }

    public void updateEventById(int eventId, EventDTO newEventDTO) {

        //TODO add the handling of exception
        Event event = eventRepository.findById(eventId).get();

        event.setTitle(newEventDTO.getTitle());
        event.setCity(newEventDTO.getCity());

        eventRepository.save(event);
    }

}
