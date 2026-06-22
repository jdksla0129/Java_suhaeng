package java.suhaeng.demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import suhaeng.demo.global.common.ApiResponse;

@RestController
@Slf4j
public class TomatoController {
    @GetMapping("/get/tomato-record")
    public ApiResponse<Object> getTomatoRecord() {
        log.info("get tomato-record");
        return ApiResponse.ok("토마토 기록지를 불러오는데 성공하셨습니다!");
    }

    @PostMapping("/post/tomato-state/{date}")
    public ApiResponse<Object> postTomatoState(@PathVariable("date") int date) {
        log.info("post tomato-state || " + date);

        return ApiResponse.ok("데이터 등록에 성공하셨습니다!");
    }
}
