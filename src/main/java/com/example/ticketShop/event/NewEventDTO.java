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
    @Schema(description = "Title of the event.",
            example = "Concert", required = true)
    @NotBlank
    @Size(max = 50)
    @NotNull
    private String title;

    @Schema(description = "Place Id from the table places.",
            example = "1", required = true)
    @NotNull
    private int placeId;

    @Schema(description = "Artist Id from the table artists.",
            example = "1", required = true)
    @NotNull
    private int artistId;
}
