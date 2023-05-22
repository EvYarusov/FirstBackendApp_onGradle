package com.example.firstBackendApp_onGradle;

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
class ArtistDTO {

    @Schema(description = "Name of the artist.",
            example = "Bob Robson", required = true)
    @NotBlank
    @Size(max = 30)
    private String name;


    @Schema(description = "The genre in which the artists perform.",
            example = "rock", required = true)
    @NotBlank
    @Size(max = 30)
    private String genre;

}
