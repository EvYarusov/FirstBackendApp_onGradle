package com.example.ticketShop.place;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewPlaceDTO
{
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
