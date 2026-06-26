package suhaeng.demo.domain.tomato.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import suhaeng.demo.domain.tomato.dto.request.UpdateTomatoRequest;
import suhaeng.demo.domain.tomato.dto.request.CreateTomatoRequest;
import suhaeng.demo.domain.tomato.dto.response.TomatoRecordResponse;
import suhaeng.demo.domain.tomato.service.TomatoService;
import suhaeng.demo.global.common.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/tomato")
@RequiredArgsConstructor
@Slf4j
public class TomatoController {
    private final TomatoService tomatoService;

    @GetMapping("/get/tomato-record")
    public ApiResponse<List<TomatoRecordResponse>> getTomatoRecord() {
        return tomatoService.getTomatoRecord();
    }

    @PostMapping("/post/tomato-state/{date}")
    public ApiResponse<Boolean> postTomatoState(
            @RequestBody CreateTomatoRequest request
    ) {
        return tomatoService.createTomatoState(request);
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
