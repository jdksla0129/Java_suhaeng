package java.suhaeng.demo.domain.tomato.dto.response;

public record CreateTomatoResponse(
        String title,
        int date,
        String time,
        String content,
        int wateringCount,
        String fruit,
        String weather,
        int temperature,
        int leafCount,
        boolean pruned
) {

}