package com.example.ticketShop.event;

import com.example.ticketShop.place.PlaceDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EventDTO {

    @Schema(description = "Name of the event",
            example = "Concert",
            required = true)
    @NotBlank
    @Size(max = 50)
    private String title;

    private PlaceDTO place;

}
