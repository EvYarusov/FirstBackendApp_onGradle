package com.example.ticketShop.artist;

import com.example.ticketShop.genre.Genre;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Artist {

    @GeneratedValue(strategy = GenerationType.IDENTITY) //mysql: auto_increment
    @Id
    private int id;

    @NotNull
    private String name;

    @NotNull
    @ManyToOne
    private Genre genre;
}
