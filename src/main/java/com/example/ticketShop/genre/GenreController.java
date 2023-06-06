package com.example.ticketShop.genre;

import com.example.ticketShop.artist.ArtistDTO;
import com.example.ticketShop.artist.ArtistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("genres")
@Tag(name = "Genres", description = "Working with genres")
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

    @Operation(summary = "Add new genre.")
    @PostMapping
    public int createGenre(@RequestBody NewGenreDTO newGenreDTO)
    {
        return genreService.createNewGenre(newGenreDTO);
    }

    @Operation(summary = "Get genre by ID.",
            description = "Get specific genre by entering genre ID.")
    @GetMapping(value = "/{genreId}")
    public GenreDTO getGenre(@PathVariable int genreId)
    {
        return genreService.getGenreById(genreId);
    }

    @Operation(summary = "Get artists by genre ID.",
            description = "Get all artists filtered by genre ID.")
    @GetMapping(value = "/{genreId}/artists")
    public List<ArtistDTO> getArtistsByGenre(@PathVariable int genreId)
    {
        return artistService.getArtistsByGenreId(genreId);
    }

}
