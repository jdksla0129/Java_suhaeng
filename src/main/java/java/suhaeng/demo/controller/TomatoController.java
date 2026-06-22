package java.suhaeng.demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TomatoController {
    @GetMapping("/get/tomato-record")
    public Object getTomatoRecord() {
        log.info("get tomato-record");
        return "get: tomato-record";
    }

    @PostMapping("/post/tomato-state/{date}")
    public String postTomatoState(@PathVariable("date") int date) {
        log.info("post tomato-state || " + date);
        return "post: tomato-state";
    }
}
