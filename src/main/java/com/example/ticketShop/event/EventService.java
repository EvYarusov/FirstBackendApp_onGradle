package com.example.ticketShop.event;

import com.example.ticketShop.artist.Artist;
import com.example.ticketShop.artist.ArtistRepository;
import com.example.ticketShop.place.Place;
import com.example.ticketShop.place.PlaceRepository;
import com.example.ticketShop.place.PlaceService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EventService
{
    private static final ModelMapper modelMapper = new ModelMapper();

    private ArtistRepository artistRepository;
    private PlaceRepository placeRepository;

    private EventRepository eventRepository;

    @Autowired
    public void setArtistRepository(ArtistRepository artistRepository)
    {
        this.artistRepository = artistRepository;
    }

    @Autowired
    public void setPlaceRepository(PlaceRepository placeRepository)
    {
        this.placeRepository = placeRepository;
    }

    @Autowired
    public void setEventRepository(EventRepository eventRepository)
    {
        this.eventRepository = eventRepository;
    }

    public int createNewEvent(NewEventDTO newEventDTO)
    {
        int placeID = newEventDTO.getPlaceId();
        Place place = placeRepository.findById(placeID).get();

        int artistId = newEventDTO.getArtistId();
        Artist artist = artistRepository.findById(artistId).get();

        Event event = new Event();
        event.setTitle(newEventDTO.getTitle());
        event.setPlace(place);
        event.setArtist(artist);

        int id = eventRepository.save(event).getId();

        return id;
    }

    public List<EventDTO> getEvents(String cityFilter)
    {
        List<Event> allEvents = eventRepository.findAll();

        List<EventDTO> resultList = modelMapper.map(
                allEvents, new TypeToken<List<EventDTO>>(){}.getType()
        );

        return resultList;
    }

    public EventDTO getEventById(int eventId)
    {
        Optional<Event> eventOptional = eventRepository.findById(eventId);

        Event event = eventOptional.get(); // Exception if data not found
        EventDTO eventDTO = modelMapper.map(event, EventDTO.class);

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

    public void updateEventById(int eventId, NewEventDTO newEventDTO)
    {
        //TODO add the handling of exception
        Event event = eventRepository.findById(eventId).get();
        event.setTitle(newEventDTO.getTitle());

        int placeId = newEventDTO.getPlaceId();
        Place place = placeRepository.findById(placeId).get();

        int artistId = newEventDTO.getArtistId();
        Artist artist = artistRepository.findById(artistId).get();

        event.setPlace(place);
        event.setArtist(artist);

        eventRepository.save(event);
    }

    public List<EventDTO> getEventsByPlaceId(int placeId)
    {
        Place place = placeRepository.findById(placeId).get();

        List<Event> eventsList = place.getEvents();

        List<EventDTO> eventDtoList = modelMapper.map(
                eventsList, new TypeToken<List<EventDTO>>(){}.getType()
        );

        return eventDtoList;
    }

    public List<EventDTO> getEventsByArtistId(int artistId)
    {
        Artist artist = artistRepository.findById(artistId).get();

        List<Event> eventList = artist.getEvents();

        List<EventDTO> eventDTOList = modelMapper.map(
                eventList, new TypeToken<List<EventDTO>>(){}.getType()
        );
        return eventDTOList;
    }
}
