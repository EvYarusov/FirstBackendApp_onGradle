package com.example.firstBackendApp_onGradle.artists;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "rest-api-artists")
@Tag(name = "Artists", description = "Working with artists")
public class ArtistRestApiController {

    private ArtistService artistService;

    @Autowired
    public void setArtistService(ArtistService artistService) {
        this.artistService = artistService;
    }

    @Operation(summary = "Get all artists.", description = "Get all artists filtered by genre.")
    @GetMapping
    public List<ArtistDTO> listArtists(@RequestParam(
            value = "genre", required = false, defaultValue = "all") String genre) {

        return artistService.getArtists(genre);
    }

    @Operation(summary = "Get artist by ID.",
            description = "Get specific artist by entering artist ID.")
    @GetMapping(value = "/{artistId}")
    public ArtistDTO getArtist(@PathVariable int artistId) {

        return artistService.getArtistById(artistId);
    }

    @Operation(summary = "Delete artist by ID.",
            description = "Delete specific artist by entering artist ID.")
    @DeleteMapping(value = "/{artistId}")
    public ArtistDTO deleteArtist(@PathVariable int artistId) {

        return artistService.deleteArtistById(artistId);
    }

    @Operation(summary = "Add new artist.")
    @PostMapping
    public int addArtist(@RequestBody ArtistDTO newArtistDTO) {

        return artistService.addNewArtist(newArtistDTO);
    }

    @Operation(summary = "Update artist fields.",
            description = "Update artist fields by entering new values.")
    @PutMapping(value = "/{artistId}")
    public List<ArtistDTO> updateArtist(@PathVariable int artistId,
                                        @RequestBody ArtistDTO newArtistDTO) {

        return artistService.updateArtistById(artistId, newArtistDTO);
    }
}
