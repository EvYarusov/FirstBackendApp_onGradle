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
public class Event {

    @Schema(description = "Name of the event",
            example = "Concert",
            required = true)
    @NotBlank
    @Size(max = 50)
    private String name;

    @Schema(description = "Location of the event",
            example = "Berlin",
            required = true)
    @NotBlank
    @Size(max = 30)
    private String city;

}
