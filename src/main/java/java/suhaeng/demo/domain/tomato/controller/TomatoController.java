package java.suhaeng.demo.domain.tomato.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.suhaeng.demo.domain.tomato.service.TomatoService;

@RestController
@RequestMapping("/api/tomatoes")
@RequiredArgsConstructor
public class TomatoController {

    private final TomatoService tomatoService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTomato(@PathVariable Long id) {
        tomatoService.deleteTomato(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/pruned")
    public ResponseEntity<Void> patchPruned(@PathVariable Long id, @RequestParam boolean pruned) {
        tomatoService.updatePruningStatus(id, pruned);
        return ResponseEntity.ok().build();
    }
}