package com.example.ticketShop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity // Now class mapped to database table
@Table (name = "events_table")
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
