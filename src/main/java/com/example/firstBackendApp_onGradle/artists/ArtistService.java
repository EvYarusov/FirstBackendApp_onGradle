package com.example.firstBackendApp_onGradle.artists;

import com.example.firstBackendApp_onGradle.events.Event;
import com.example.firstBackendApp_onGradle.events.EventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistService {

    private ArtistRepository artistRepository;

    @Autowired
    public void setArtistRepository(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    static final ArrayList<ArtistDTO> ARTISTS = new ArrayList<ArtistDTO>() {{
        add(new ArtistDTO("Vanessa-Mae Vanakorn Nicholson", "violin techno-acoustic fusion"));
        add(new ArtistDTO("Robert Nesta Marley", "reggae"));
        add(new ArtistDTO("Kurt Donald Cobain", "alternative rock"));
        add(new ArtistDTO("Marshall Bruce Mathers III", "hip hop music"));
    }};

    public int addNewArtist(ArtistDTO newArtistDTO) {

        String name = newArtistDTO.getName();
        String genre = newArtistDTO.getGenre();

        Artist artist = new Artist();
        artist.setName(name);
        artist.setGenre(genre);

        int id = artistRepository.save(artist).getId();

        return id;
    }

    public List<ArtistDTO> getArtists(String genre) {

        Iterable<Artist> allArtists = artistRepository.findAll();

        List<ArtistDTO> result = new ArrayList<>();
        for (Artist artist : allArtists)
        {
            if(artist.getGenre().equalsIgnoreCase(genre) ^ genre.equalsIgnoreCase("all"))
            {
            ArtistDTO artistDTO = new ArtistDTO(artist.getName(), artist.getGenre());
            result.add(artistDTO);
            }
        }
        return result;

    }

    public ArtistDTO getArtistById(int artistId) {

        ArtistDTO artistDTO = ARTISTS.get(artistId);

        return artistDTO;
    }

    public ArtistDTO deleteArtistById(int artistId) {

        ArtistDTO artistDTO = ARTISTS.get(artistId);
        ARTISTS.remove(artistId);

        return artistDTO;
    }

    public List<ArtistDTO> updateArtistById(int artistId, ArtistDTO newArtistDTO) {

        //TODO: add real update artist in database
        ARTISTS.remove(artistId);
        ARTISTS.add(artistId, newArtistDTO);

        return ARTISTS;
    }
}
