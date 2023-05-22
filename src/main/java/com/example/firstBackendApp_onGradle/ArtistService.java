package com.example.firstBackendApp_onGradle;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistService {

    static final ArrayList<ArtistDTO> ARTISTS = new ArrayList<ArtistDTO>() {{
        add(new ArtistDTO("Vanessa-Mae Vanakorn Nicholson", "violin techno-acoustic fusion"));
        add(new ArtistDTO("Robert Nesta Marley", "reggae"));
        add(new ArtistDTO("Kurt Donald Cobain", "alternative rock"));
        add(new ArtistDTO("Marshall Bruce Mathers III", "hip hop music"));
    }};

    public List<ArtistDTO> getAllArtists(String genre) {
        List<ArtistDTO> resultArtistDTOS = ARTISTS;

        if (!genre.equals("all")) {
            resultArtistDTOS = ARTISTS.stream().filter(e -> e.getGenre().equals(genre)).collect(Collectors.toList());
        }
        return resultArtistDTOS;
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

    public int addNewArtist(ArtistDTO newArtistDTO) {

        //TODO: add real entering artist in database
        ARTISTS.add(newArtistDTO);
        int artistId = ARTISTS.indexOf(newArtistDTO);

        return artistId;
    }

    public List<ArtistDTO> updateArtistById(int artistId, ArtistDTO newArtistDTO) {

        //TODO: add real update artist in database
        ARTISTS.remove(artistId);
        ARTISTS.add(artistId, newArtistDTO);

        return ARTISTS;
    }
}
