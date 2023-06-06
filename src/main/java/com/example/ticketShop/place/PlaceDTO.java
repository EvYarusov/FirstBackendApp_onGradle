package com.example.ticketShop.place;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaceDTO
{
    @Schema(description = "Place Id.",
            example = "1", required = true)
    @NotNull
    private int id;

    @Schema(description = "Name of the place.",
            example = "place", required = true)
    @NotBlank
    @Size(max = 30)
    private String name;

    @Schema(description = "Address.",
            example = "street", required = true)
    @NotBlank
    @Size(max = 30)
    private String address;

    @Schema(description = "City.",
            example = "city", required = true)
    @NotBlank
    @Size(max = 30)
    private String city;
}
