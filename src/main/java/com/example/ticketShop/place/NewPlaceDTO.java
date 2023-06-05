package com.example.ticketShop.place;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewPlaceDTO
{
    private String name;
    private String address;
    private String city;
}
