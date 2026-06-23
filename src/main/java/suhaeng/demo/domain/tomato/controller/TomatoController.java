package suhaeng.demo.domain.tomato.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import suhaeng.demo.domain.tomato.dto.request.UpdateTomatoRequest;
import suhaeng.demo.domain.tomato.service.TomatoService;
import suhaeng.demo.global.common.ApiResponse;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TomatoController {
    private final TomatoService tomatoService;

    @GetMapping("/get/tomato-record")
    public ApiResponse<Object> getTomatoRecord() {
        log.info("get tomato-record");
        return ApiResponse.ok("토마토 기록지를 불러오는데 성공하셨습니다!");
    }

    @PostMapping("/post/tomato-state/{date}")
    public ApiResponse<Object> postTomatoState(@PathVariable("date") int date) {
        log.info("post tomato-state || " + date);

        //        return ApiResponse.created(,"오늘의 토마토 상태를 기록하셨습니다!");
        return ApiResponse.ok("데이터 등록에 성공하셨습니다!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTomato(@PathVariable Long id) {
        tomatoService.deleteTomato(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ApiResponse<Boolean> updateTomato(@PathVariable("id") Long id, @RequestBody UpdateTomatoRequest request) {
        return tomatoService.updateTomato(id, request);
    }

    @PatchMapping("/{id}/pruned")
    public ResponseEntity<Void> patchPruned(@PathVariable Long id, @RequestParam boolean pruned) {
        tomatoService.updatePruningStatus(id, pruned);
        return ResponseEntity.ok().build();
    }
}
