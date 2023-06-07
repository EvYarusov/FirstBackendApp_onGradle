package com.example.ticketShop.genre;

import com.example.ticketShop.artist.Artist;
import com.example.ticketShop.place.Place;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "genres")
public class Genre
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //mysql: auto_increment
    private int id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "genre")
    private List<Artist> artists;

}
