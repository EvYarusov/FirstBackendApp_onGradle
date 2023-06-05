package com.example.ticketShop.place;

import com.example.ticketShop.event.EventDTO;
import com.example.ticketShop.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("places")
public class PlaceController
{
    private EventService eventService;
    private PlaceService placeService;

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @Autowired
    public void setPlaceService(PlaceService placeService)
    {
        this.placeService = placeService;
    }

    @PostMapping
    public int createPlace(@RequestBody NewPlaceDTO newPlaceDTO)
    {
        return placeService.createNewPlace(newPlaceDTO);
    }

    @GetMapping(value = "/{placeId}")
    public PlaceDTO getPlace(@PathVariable int placeId)
    {
        return placeService.getPlaceById(placeId);
    }

    @GetMapping(value = "/{placeId}/events")
    public List<EventDTO> getEventsByPlace(@PathVariable int placeId)
    {
        return eventService.getEventsByPlaceId(placeId);
    }
}
