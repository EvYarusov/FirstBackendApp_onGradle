package com.example.ticketShop.artist;

import com.example.ticketShop.genre.Genre;
import com.example.ticketShop.genre.GenreRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.internal.bytebuddy.description.method.MethodDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ArtistService
{
    private static final ModelMapper modelMapper = new ModelMapper();

    private GenreRepository genreRepository;

    private ArtistRepository artistRepository;

    @Autowired
    public void setGenreRepository(GenreRepository genreRepository)
    {
        this.genreRepository = genreRepository;
    }

    @Autowired
    public void setArtistRepository(ArtistRepository artistRepository)
    {
        this.artistRepository = artistRepository;
    }

    public int createNewArtist(NewArtistDTO newArtistDTO)
    {
        int genreId = newArtistDTO.getGenreId();

        //TODO add the handling of exception
        Genre genre = genreRepository.findById(genreId).get();

        Artist artist = new Artist();

        artist.setName(newArtistDTO.getName());
        artist.setGenre(genre);

        int id = artistRepository.save(artist).getId();

        return id;
    }

    public List<ArtistDTO> getArtists(String genreFilter)
    {
        //TODO add the genreFilter
        List<Artist> allArtists = artistRepository.findAll();

        List<ArtistDTO> resultList = modelMapper.map(
                allArtists, new TypeToken<List<ArtistDTO>>(){}.getType()
        );

        return resultList;
    }

    public ArtistDTO getArtistById(int artistId)
    {
        //TODO add the handling of exception
        Artist artist = artistRepository.findById(artistId).get();

        ArtistDTO artistDTO = modelMapper.map(artist, ArtistDTO.class);

        return artistDTO;
    }

    public ArtistDTO deleteArtistById(int artistId)
    {
        ArtistDTO artistDTO = getArtistById(artistId);

        artistRepository.deleteById(artistId);

        return artistDTO;
    }

    public void updateArtistById(int artistId, NewArtistDTO newArtistDTO)
    {
        //TODO add the handling of exception
        Artist artist = artistRepository.findById(artistId).get();

        artist.setName(newArtistDTO.getName());

        int genreId = newArtistDTO.getGenreId();
        Genre genre = genreRepository.findById(genreId).get();

        artist.setGenre(genre);

        artistRepository.save(artist);
    }

    public List<ArtistDTO> getArtistsByGenreId(int genreId)
    {
        Genre genre = genreRepository.findById(genreId).get();

        List<Artist> artistList = genre.getArtists();

        List<ArtistDTO> artistDTOList = modelMapper.map(
                artistList, new TypeToken<List<ArtistDTO>>(){}.getType()
        );
        return artistDTOList;
    }
}
