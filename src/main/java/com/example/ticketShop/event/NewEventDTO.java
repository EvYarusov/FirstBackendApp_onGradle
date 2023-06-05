package com.example.ticketShop.event;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewEventDTO
{
    @NotNull
    private String title;
    @NotNull
    private int placeId;
    @NotNull
    private int artistId;
}
