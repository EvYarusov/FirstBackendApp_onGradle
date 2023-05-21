package com.example.firstBackendApp_onGradle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ArtistsController {
    static final ArrayList<Artist> artists = new ArrayList<Artist>(){{
        add(new Artist("Vanessa-Mae Vanakorn Nicholson", "violin techno-acoustic fusion"));
        add(new Artist("Robert Nesta Marley", "reggae"));
        add(new Artist("Kurt Donald Cobain", "alternative rock"));
        add(new Artist("Marshall Bruce Mathers III", "hip hop music"));
    }};

    @RequestMapping(value = "/artists", method = RequestMethod.GET)
    public String listArtists(@RequestParam(value = "genre", required = false, defaultValue = "all") String genre, Model model)
    {
        List<Artist> resultArtists = artists;
        if (!genre.equals("all")) {
            resultArtists = artists.stream().filter(e -> e.getGenre().equals(genre)).collect(Collectors.toList());
        }
        model.addAttribute("artists", resultArtists);
        return "artistsView";
    }
}
