package com.example.ticketShop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Artist {

    @GeneratedValue // jakarta.persistence
    @Id             // jakarta.persistence
    private int id;

    private String name;

    private String genre;
}
