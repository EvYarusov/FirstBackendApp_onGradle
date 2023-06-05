package com.example.ticketShop.artist;

import com.example.ticketShop.event.EventDTO;
import com.example.ticketShop.event.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "artists")
@Tag(name = "Artists", description = "Working with artists")
public class ArtistController
{
    private EventService eventService;
    private ArtistService artistService;

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @Autowired
    public void setArtistService(ArtistService artistService)
    {
        this.artistService = artistService;
    }

    @Operation(summary = "Get all artists.", description = "Get all artists filtered by genre.")
    @GetMapping
    public List<ArtistDTO> listArtists(@RequestParam(
            value = "genre", required = false, defaultValue = "all") String genre)
    {
        return artistService.getArtists(genre);
    }

    @Operation(summary = "Get artist by ID.",
            description = "Get specific artist by entering artist ID.")
    @GetMapping(value = "/{artistId}")
    public ArtistDTO getArtist(@PathVariable int artistId)
    {
        return artistService.getArtistById(artistId);
    }

    @Operation(summary = "Delete artist by ID.",
            description = "Delete specific artist by entering artist ID.")
    @DeleteMapping(value = "/{artistId}")
    public ArtistDTO deleteArtist(@PathVariable int artistId)
    {
        return artistService.deleteArtistById(artistId);
    }

    @Operation(summary = "Add new artist.")
    @PostMapping
    public int createArtist(@RequestBody NewArtistDTO newArtistDTO)
    {
        return artistService.createNewArtist(newArtistDTO);
    }

    @Operation(summary = "Update artist fields.",
            description = "Update artist fields by entering new values.")
    @PutMapping(value = "/{artistId}")
    public void updateArtist(@PathVariable int artistId,
                                        @RequestBody NewArtistDTO newArtistDTO)
    {
        artistService.updateArtistById(artistId, newArtistDTO);
    }

    @GetMapping(value = "/{artistId}/events")
    public List<EventDTO> getEventsByArtist(@PathVariable int artistId)
    {
        return eventService.getEventsByArtistId(artistId);
    }
}
