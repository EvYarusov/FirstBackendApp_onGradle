package com.example.firstBackendApp_onGradle.artists;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ArtistController {

    static final ArrayList<ArtistDTO> ARTIST_DTOS = new ArrayList<ArtistDTO>(){{
        add(new ArtistDTO("Vanessa-Mae Vanakorn Nicholson", "violin techno-acoustic fusion"));
        add(new ArtistDTO("Robert Nesta Marley", "reggae"));
        add(new ArtistDTO("Kurt Donald Cobain", "alternative rock"));
        add(new ArtistDTO("Marshall Bruce Mathers III", "hip hop music"));
    }};

    @RequestMapping(value = "/artists", method = RequestMethod.GET)
    public String listArtists(@RequestParam(value = "genre", required = false, defaultValue = "all") String genre, Model model)
    {
        List<ArtistDTO> resultArtistDTOS = ARTIST_DTOS;
        if (!genre.equals("all")) {
            resultArtistDTOS = ARTIST_DTOS.stream().filter(e -> e.getGenre().equals(genre)).collect(Collectors.toList());
        }
        model.addAttribute("artists", resultArtistDTOS);
        return "artistsView";
    }
}
