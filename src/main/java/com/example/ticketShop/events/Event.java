package com.example.ticketShop.events;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity // Now class mapped to database table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @GeneratedValue
    @Id
    private int id;

    private String title;

    private String city;
}
