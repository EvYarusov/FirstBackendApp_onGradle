package com.example.firstBackendApp_onGradle;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
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
