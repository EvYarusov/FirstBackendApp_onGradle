package com.example.firstBackendApp_onGradle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ArtistsRestApiController {
    static ArrayList<Artist> artists = new ArrayList<Artist>() {{
        add(new Artist("Vanessa-Mae Vanakorn Nicholson", "violin techno-acoustic fusion"));
        add(new Artist("Robert Nesta Marley", "reggae"));
        add(new Artist("Kurt Donald Cobain", "alternative rock"));
        add(new Artist("Marshall Bruce Mathers III", "hip hop music"));
    }};

    @GetMapping(value = "/rest-api-artists")
    public List<Artist> listArtists(@RequestParam(value = "genre", required = false, defaultValue = "all") String genre) {

        List<Artist> resultArtists = artists;

        if (!genre.equals("all")) {
            resultArtists = artists.stream().filter(e -> e.getGenre().equals(genre)).collect(Collectors.toList());
        }

        return resultArtists;
    }

    @GetMapping(value = "/rest-api-artists/{artistId}")
    public Artist getArtist(@PathVariable int artistId) {

        Artist artist = artists.get(artistId);

        return artist;
    }

    @DeleteMapping(value = "/rest-api-artists/{artistId}")
    public Artist deleteArtist(@PathVariable int artistId) {

        Artist artist = artists.get(artistId);
        artists.remove(artistId);

        return artist;
    }

    @PostMapping(value = "/rest-api-artists")
    public int addArtist(@RequestBody Artist newArtist) {

        //TODO: add real entering artist in database
        artists.add(newArtist);
        int artistId = artists.indexOf(newArtist);

        return artistId;
    }

    @PutMapping(value = "/rest-api-artists/{artistId}")
    public List<Artist> updateArtist(@PathVariable int artistId, @RequestBody Artist newArtist) {

        //TODO: add real update artist in database
        artists.remove(artistId);
        artists.add(artistId, newArtist);

        return artists;
    }
}
