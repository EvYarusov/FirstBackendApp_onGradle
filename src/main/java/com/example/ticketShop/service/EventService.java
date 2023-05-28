package com.example.ticketShop.service;

import com.example.ticketShop.entity.Event;
import com.example.ticketShop.dto.EventDTO;
import com.example.ticketShop.repository.EventRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EventService
{
    private static final ModelMapper modelMapper = new ModelMapper();

    private EventRepository eventRepository;

    @Autowired
    public void setEventRepository(EventRepository eventRepository)
    {
        this.eventRepository = eventRepository;
    }

    public int createNewEvent(EventDTO eventDTO)
    {
        // Put data from eventDTO to Event(entity) for DB
        // 1 argument: eventDTO - source(источник)
        // 2 argument: destination object class. В объект какого класса положить данные
        Event event = modelMapper.map(eventDTO, Event.class);

        int id = eventRepository.save(event).getId();

        return id;
    }

    public List<EventDTO> getEvents(String city)
    {
        Iterable<Event> allEvents = eventRepository.findAll();

        List<EventDTO> resultList = new ArrayList<>();
        for (Event event : allEvents)
        {
            if (city.equalsIgnoreCase("all") ^
                    event.getCity().equalsIgnoreCase(city))
            {
                EventDTO eventDTO = modelMapper.map(event,EventDTO.class);
                resultList.add(eventDTO);
            }
        }
        return resultList;
    }

    public EventDTO getEventById(int eventId)
    {
        Optional<Event> eventOptional = eventRepository.findById(eventId);

        Event event = eventOptional.get(); // Exception if data not found
        EventDTO eventDTO = modelMapper.map(event,EventDTO.class);

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
        return eventDTO;
    }

    public EventDTO deleteEventById(int eventId)
    {
        EventDTO eventDTO = getEventById(eventId);

        eventRepository.deleteById(eventId);

        return eventDTO;
    }

    public void updateEventById(int eventId, EventDTO newEventDTO)
    {
        //TODO add the handling of exception
        Event event = eventRepository.findById(eventId).get();

        event.setTitle(newEventDTO.getTitle());
        event.setCity(newEventDTO.getCity());

        eventRepository.save(event);
    }

}
