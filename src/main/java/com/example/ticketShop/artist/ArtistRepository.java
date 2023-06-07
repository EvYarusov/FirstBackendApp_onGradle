package com.example.ticketShop.artist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer>
{
    @Query("SELECT ar FROM Artist ar INNER JOIN ar.genre g WHERE g.name = :genreName")
    List<Artist> findArtistsFilteredByGenreName(@Param("genreName") String genreName);
}
