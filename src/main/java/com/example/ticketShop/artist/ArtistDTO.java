package com.example.ticketShop.artist;

import com.example.ticketShop.genre.GenreDTO;
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
public class ArtistDTO
{
    @Schema(description = "Name of the artist.",
            example = "Bob Dylan", required = true)
    @NotBlank
    @Size(max = 30)
    private String name;

    private GenreDTO genre;

}
