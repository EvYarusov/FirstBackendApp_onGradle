package com.example.ticketShop.place;

import com.example.ticketShop.artist.ArtistDTO;
import com.example.ticketShop.artist.ArtistService;
import com.example.ticketShop.event.EventDTO;
import com.example.ticketShop.event.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("places")
@Tag(name = "Places", description = "Working with places")
public class PlaceController
{
    private ArtistService artistService;
    private EventService eventService;
    private PlaceService placeService;

    @Autowired
    public void setArtistService(ArtistService artistService)
    {
        this.artistService = artistService;
    }
    @Autowired
    public void setEventService(EventService eventService)
    {
        this.eventService = eventService;
    }
    @Autowired
    public void setPlaceService(PlaceService placeService)
    {
        this.placeService = placeService;
    }

    @Operation(summary = "Add new place.")
    @PostMapping
    public int createPlace(@RequestBody NewPlaceDTO newPlaceDTO)
    {
        return placeService.createNewPlace(newPlaceDTO);
    }

    @Operation(summary = "Get place by ID.",
            description = "Get specific place by entering place ID.")
    @GetMapping(value = "/{placeId}")
    public PlaceDTO getPlace(@PathVariable int placeId)
    {
        return placeService.getPlaceById(placeId);
    }

    @Operation(summary = "Get events by place ID.",
            description = "Get all events filtered by place ID.")
    @GetMapping(value = "/{placeId}/events")
    public List<EventDTO> getEventsByPlace(@PathVariable int placeId)
    {
        return eventService.getEventsByPlaceId(placeId);
    }

    @Operation(summary = "Get artists by place ID.",
            description = "Get all artists filtered by place ID.")
    @GetMapping(value = "/{placeId}/artists")
    public List<ArtistDTO> getArtistsByPlace(@PathVariable int placeId)
    {
        return artistService.getArtistsByPlaceId(placeId);
    }

    @GetMapping(value = "/by_city/{city}")
    public List<PlaceDTO> getPlacesByCity(@PathVariable String city)
    {
        return placeService.getPlacesByCityName(city);
    }

    @GetMapping(value = "/by_city/{city}/by_address/{address}")
    public List<PlaceDTO> getPlacesByCityAndAddress(
            @PathVariable String city, @PathVariable String address)
    {
        return placeService.getPlacesByCityAndAddress(city, address);
    }
}
