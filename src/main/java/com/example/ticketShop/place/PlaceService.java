package com.example.ticketShop.place;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaceService
{
    private static final ModelMapper modelMapper = new ModelMapper();
    private PlaceRepository placeRepository;

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

    public PlaceDTO getPlaceById(int placeId) {

        //TODO add the handling of exception
        Optional<Place> placeOptional = placeRepository.findById(placeId);

        Place place = placeOptional.get();

        PlaceDTO placeDTO = modelMapper.map(place, PlaceDTO.class);

        return placeDTO;
    }
}
