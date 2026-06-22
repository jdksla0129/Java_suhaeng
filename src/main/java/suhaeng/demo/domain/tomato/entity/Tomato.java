package suhaeng.demo.domain.tomato.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tomato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;        // 일지 제목
    private String content;      //일지 내용
    private int wateringCount;   //물 준 횟수
    private int leafCount;       // 잎사귀 갯수
    private boolean pruned;      // 가지치기 여부

    @Builder
    public Tomato(String content, int wateringCount, int leafCount, boolean pruned) {
        this.title = LocalDate.now().toString();
        this.content = content;
        this.wateringCount = wateringCount;
        this.leafCount = leafCount;
        this.pruned = pruned;
    }
}
