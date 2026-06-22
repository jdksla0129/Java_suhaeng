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

    private String title;
    private String content;
    private int wateringCount;
    private int leafCount;
    private boolean pruned;

    @Builder
    public Tomato(String content, int wateringCount, int leafCount, boolean pruned) {
        this.title = LocalDate.now().toString();
        this.content = content;
        this.wateringCount = wateringCount;
        this.leafCount = leafCount;
        this.pruned = pruned;
    }

    public void updatePruned(boolean pruned) {
        this.pruned = pruned;
    }
}