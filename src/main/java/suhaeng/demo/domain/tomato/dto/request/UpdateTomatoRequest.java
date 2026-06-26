package suhaeng.demo.domain.tomato.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import suhaeng.demo.domain.tomato.enumeration.Dust;
import suhaeng.demo.domain.tomato.enumeration.Weather;

public record UpdateTomatoRequest(
        @NotBlank
        String title,
        @NotBlank
        String content,
        @NotNull
        int wateringCount,
        @NotNull
        int leafCount,
        @NotNull
        boolean pruned,
        @NotNull
        int date,
        @NotBlank
        String time,
        @NotBlank
        int fruit,
        @NotNull
        Weather weather,
        @NotNull
        int temperature,
        @NotNull
        Dust dustConcentration
) { }
