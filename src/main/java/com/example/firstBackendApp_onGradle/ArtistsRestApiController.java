package com.example.firstBackendApp_onGradle;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "rest-api-artists")
public class ArtistsRestApiController {
    static ArrayList<Artist> artists = new ArrayList<Artist>() {{
        add(new Artist("Vanessa-Mae Vanakorn Nicholson", "violin techno-acoustic fusion"));
        add(new Artist("Robert Nesta Marley", "reggae"));
        add(new Artist("Kurt Donald Cobain", "alternative rock"));
        add(new Artist("Marshall Bruce Mathers III", "hip hop music"));
    }};

    @Operation(summary = "Get all artists.", description = "Get all artists filtered by genre.")
    @GetMapping
    public List<Artist> listArtists(@RequestParam(value = "genre", required = false, defaultValue = "all") String genre) {

        List<Artist> resultArtists = artists;

        if (!genre.equals("all")) {
            resultArtists = artists.stream().filter(e -> e.getGenre().equals(genre)).collect(Collectors.toList());
        }

        return resultArtists;
    }

    @Operation(summary = "Get artist by ID.", description = "Get specific artist by entering artist ID.")
    @GetMapping(value = "/{artistId}")
    public Artist getArtist(@PathVariable int artistId) {

        Artist artist = artists.get(artistId);

        return artist;
    }

    @Operation(summary = "Delete artist by ID.", description = "Delete specific artist by entering artist ID.")
    @DeleteMapping(value = "/{artistId}")
    public Artist deleteArtist(@PathVariable int artistId) {

        Artist artist = artists.get(artistId);
        artists.remove(artistId);

        return artist;
    }

    @Operation(summary = "Add new artist.")
    @PostMapping
    public int addArtist(@RequestBody Artist newArtist) {

        //TODO: add real entering artist in database
        artists.add(newArtist);
        int artistId = artists.indexOf(newArtist);

        return artistId;
    }

    @Operation(summary = "Update artist fields.", description = "Update artist fields by entering new values.")
    @PutMapping(value = "/{artistId}")
    public List<Artist> updateArtist(@PathVariable int artistId, @RequestBody Artist newArtist) {

        //TODO: add real update artist in database
        artists.remove(artistId);
        artists.add(artistId, newArtist);

        return artists;
    }
}
