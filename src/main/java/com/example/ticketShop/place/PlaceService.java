package com.example.ticketShop.place;

import com.example.ticketShop.artist.Artist;
import com.example.ticketShop.artist.ArtistRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService
{
    private static final ModelMapper modelMapper = new ModelMapper();
    private ArtistRepository artistRepository;
    private PlaceRepository placeRepository;

    @Autowired
    public void setArtistRepository(ArtistRepository artistRepository)
    {
        this.artistRepository = artistRepository;
    }
    @Autowired
    public void setPlaceRepository(PlaceRepository placeRepository)
    {
        this.placeRepository = placeRepository;
    }

    public int createNewPlace(NewPlaceDTO newPlaceDTO)
    {
        Place place = modelMapper.map(newPlaceDTO, Place.class);

        int id = placeRepository.save(place).getId();

        return id;
    }

    public PlaceDTO getPlaceById(int placeId)
    {
        //TODO add the handling of exception
        Optional<Place> placeOptional = placeRepository.findById(placeId);

        Place place = placeOptional.get();

        PlaceDTO placeDTO = modelMapper.map(place, PlaceDTO.class);

        return placeDTO;
    }

    public List<PlaceDTO> getPlacesByArtistId(int artistId)
    {
        //TODO add the handling of exception
        Artist artist = artistRepository.findById(artistId).get();

        List<Place> placeList = artist.getPlaces();

        List<PlaceDTO> placeDTOList = modelMapper.map(
                placeList, new TypeToken<List<PlaceDTO>>() {
                }.getType()
        );
        return placeDTOList;
    }

    public List<PlaceDTO> getPlacesByCityName(String city)
    {
        List<Place> placeList = placeRepository.findPlacesByCity(city);

        List<PlaceDTO> placeDTOList = modelMapper.map(
                placeList, new TypeToken<List<PlaceDTO>>() {
                }.getType()
        );
        return placeDTOList;
    }

    public List<PlaceDTO> getPlacesByCityAndAddress(String city, String address)
    {
        List<Place> placeList = placeRepository
                .findPlacesByCityAndAddress(city, address);

        List<PlaceDTO> placeDTOList = modelMapper.map(
                placeList, new TypeToken<List<PlaceDTO>>() {
                }.getType()
        );
        return placeDTOList;
    }

}
