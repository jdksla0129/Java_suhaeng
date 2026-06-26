package suhaeng.demo.domain.tomato.dto.response;

import suhaeng.demo.domain.tomato.entity.Tomato;
import suhaeng.demo.domain.tomato.enumeration.Weather;

public record TomatoRecordResponse(
        Long id,
        String title,
        int date,
        String time,
        String content,
        int wateringCount,
        int fruit,
        Weather weather,
        int temperature,
        int leafCount,
        boolean pruned
) {
    public static TomatoRecordResponse from(Tomato tomato) {
        return new TomatoRecordResponse(
                tomato.getId(),
                tomato.getTitle(),
                tomato.getDate(),
                tomato.getTime(),
                tomato.getContent(),
                tomato.getWateringCount(),
                tomato.getFruit(),
                tomato.getWeather(),
                tomato.getTemperature(),
                tomato.getLeafCount(),
                tomato.isPruned()
        );
    }
}