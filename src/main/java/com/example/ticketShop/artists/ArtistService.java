package com.example.ticketShop.artists;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ArtistService
{
    private static final ModelMapper modelMapper = new ModelMapper();

    private ArtistRepository artistRepository;

    @Autowired
    public void setArtistRepository(ArtistRepository artistRepository)
    {
        this.artistRepository = artistRepository;
    }

    public int addNewArtist(ArtistDTO newArtistDTO)
    {
        Artist artist = modelMapper.map(newArtistDTO, Artist.class);

        int id = artistRepository.save(artist).getId();

        return id;
    }

    public List<ArtistDTO> getArtists(String genre)
    {
        Iterable<Artist> allArtists = artistRepository.findAll();

        List<ArtistDTO> resultList = new ArrayList<>();
        for (Artist artist : allArtists)
        {
            if(artist.getGenre()
                    .equalsIgnoreCase(genre) ^ genre
                    .equalsIgnoreCase("all"))
            {
                ArtistDTO artistDTO = modelMapper.map(artist, ArtistDTO.class);
                resultList.add(artistDTO);
            }
        }

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

    public void updateArtistById(int artistId, ArtistDTO newArtistDTO)
    {
        //TODO add the handling of exception
        Artist artist = artistRepository.findById(artistId).get();

        artist.setName(newArtistDTO.getName());
        artist.setGenre(newArtistDTO.getGenre());

        artistRepository.save(artist);
    }

}
