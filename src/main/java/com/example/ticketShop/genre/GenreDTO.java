package com.example.ticketShop.genre;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenreDTO
{
    @Schema(description = "Genre Id.",
            example = "1", required = true)
    @NotNull
    private int id;

    @Schema(description = "Name of the genre.",
            example = "genre", required = true)
    @NotBlank
    @Size(max = 30)
    private String name;

}
