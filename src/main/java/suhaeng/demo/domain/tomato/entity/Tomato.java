package suhaeng.demo.domain.tomato.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import suhaeng.demo.domain.tomato.dto.request.UpdateTomatoRequest;
import suhaeng.demo.domain.tomato.enumeration.Dust;
import suhaeng.demo.domain.tomato.enumeration.Weather;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tomato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;          // 일지 제목
    private int date;              // 일지를 쓴 날짜
    private String time;           // 일지를 쓴 시간
    private String content;        // 일지 내용
    private int wateringCount;     // 물 준 횟수
    private String fruit;          // 열매 수
    private Weather weather;       // 기상 상태
    private int temperature;       // 온도
    private int leafCount;         // 잎사귀 갯수
    private boolean pruned;        // 가지치기 여부
    private Dust dustConcentration; // 미세먼지 농도

    @Builder
    public Tomato(String content, int wateringCount, int leafCount, boolean pruned, int date, String time, String fruit, Weather weather, int temperature, Dust dustConcentration) {
        this.title = LocalDate.now().toString();
        this.content = content;
        this.wateringCount = wateringCount;
        this.leafCount = leafCount;
        this.pruned = pruned;
        this.date = date;
        this.time = time;
        this.fruit = fruit;
        this.weather = weather;
        this.temperature = temperature;
        this.dustConcentration = dustConcentration;
    }

    public void updateTomato(UpdateTomatoRequest request) {
        this.content = request.content();
        this.wateringCount = request.wateringCount();
        this.leafCount = request.leafCount();
        this.pruned = request.pruned();
        this.date = request.date();
        this.time = request.time();
        this.fruit = request.fruit();
        this.weather = request.weather();
        this.temperature = request.temperature();
        this.dustConcentration = request.dustConcentration();
    }

    public void updatePruned(boolean pruned) {
        this.pruned = pruned;
    }
}
