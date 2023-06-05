package com.example.ticketShop.genre;

import com.example.ticketShop.artist.ArtistDTO;
import com.example.ticketShop.artist.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("genres")
public class GenreController
{
    private ArtistService artistService;
    private GenreService genreService;

    @Autowired
    public void setArtistService(ArtistService artistService)
    {
        this.artistService = artistService;
    }

    @Autowired
    public void setGenreService(GenreService genreService)
    {
        this.genreService = genreService;
    }

    @PostMapping
    public int createGenre(@RequestBody NewGenreDTO newGenreDTO)
    {
        return genreService.createNewGenre(newGenreDTO);
    }

    @GetMapping(value = "/{genreId}")
    public GenreDTO getGenre(@PathVariable int genreId)
    {
        return genreService.getGenreById(genreId);
    }

    @GetMapping(value = "/{genreId}/artists")
    public List<ArtistDTO> getArtistsByGenre(@PathVariable int genreId)
    {
        return artistService.getArtistsByGenreId(genreId);
    }

}
