package com.example.ticketShop.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
// CrudRepository<entity class, type of primary id>
// CrudRepository -> PagingAndSortingRepository -> JpaRepository
public interface EventRepository extends JpaRepository<Event, Integer>
{
    // SELECT event.id, event.name, event.place_id, event.artist_ref_id
    // FROM event
    // INNER JOIN place ON event.place_id = place.id
    // WHERE place.city = 'London'
    @Query("SELECT e FROM Event e INNER JOIN e.place p WHERE p.city = :city")
    List<Event> findEventsFilteredByCity(@Param("city") String city);

    @Query("SELECT ev FROM Event ev INNER JOIN ev.artist ar INNER JOIN ar.genre ge WHERE ge.name = :genreName")
    List<Event> findEventsFilteredByGenreName(@Param("genreName") String genreName);
}
