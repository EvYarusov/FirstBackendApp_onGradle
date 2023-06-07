package com.example.ticketShop.place;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer>
{
    List<Place> findPlacesByCity (String city);

    List<Place> findPlacesByCityAndAddress (String city, String address);

}
