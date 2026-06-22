package suhaeng.demo.domain.tomato.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import suhaeng.demo.domain.tomato.dto.request.UpdateTomatoRequest;
import suhaeng.demo.domain.tomato.service.TomatoService;
import suhaeng.demo.global.common.ApiResponse;

@RestController
@RequestMapping("/tomato")
@RequiredArgsConstructor
@Slf4j
public class TomatoController {
    private final TomatoService tomatoService;

    @PutMapping("/{id}")
    public ApiResponse<Boolean> updateTomato(@PathVariable("id") Long id, @RequestBody UpdateTomatoRequest request) {
        return tomatoService.updateTomato(id, request);
    }
}
