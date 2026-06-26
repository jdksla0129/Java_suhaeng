package suhaeng.demo.domain.tomato.dto.request;

import suhaeng.demo.domain.tomato.enumeration.Dust;
import suhaeng.demo.domain.tomato.enumeration.Weather;

public record CreateTomatoRequest(
        String title,
        int date,
        String time,
        String content,
         int wateringCount,
         String fruit,
         Weather weather,
         int temperature,
         int leafCount,
         boolean pruned,
         Dust dustConcentration
) {
}