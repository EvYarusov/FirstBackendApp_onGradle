package com.example.ticketShop.event;

import com.example.ticketShop.artist.Artist;
import com.example.ticketShop.place.Place;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity // Now class mapped to database table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "events")
public class Event {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @NotNull
    private String title;

    // Owner - who hold id for another table
    @NotNull
    @ManyToOne
    private Place place; // column place_id --> place.id

    @NotNull
    @ManyToOne
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    private Artist artist;
}
