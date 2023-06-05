package com.example.ticketShop.artist;

import com.example.ticketShop.genre.Genre;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class NewArtistDTO
{
    @Schema(description = "Name of the artist.",
            example = "Bob Dylan", required = true)
    @NotBlank
    @Size(max = 30)
    private String name;

    @NotNull
    private int genreId;

}
