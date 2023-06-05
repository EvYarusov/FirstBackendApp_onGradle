package com.example.ticketShop.artist;

import com.example.ticketShop.event.Event;
import com.example.ticketShop.genre.Genre;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "artists")
public class Artist
{
    @GeneratedValue(strategy = GenerationType.IDENTITY) //mysql: auto_increment
    @Id
    private int id;

    @NotNull
    @Column(name = "artist_name")
    private String name;

    @NotNull
    @ManyToOne
    private Genre genre;

    @OneToMany(mappedBy = "artist")
    private List<Event> events;
}
