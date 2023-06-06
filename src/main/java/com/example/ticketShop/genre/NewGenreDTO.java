package com.example.ticketShop.genre;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewGenreDTO
{
    @Schema(description = "Name of the genre.",
            example = "genre", required = true)
    @NotBlank
    @Size(max = 30)
    private String name;

}
