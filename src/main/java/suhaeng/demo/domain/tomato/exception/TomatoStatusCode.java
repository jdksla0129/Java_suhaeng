package suhaeng.demo.domain.tomato.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import suhaeng.demo.global.exception.statuscode.StatusCode;

@Getter
@RequiredArgsConstructor
public enum TomatoStatusCode implements StatusCode {
    TOMATO_NOT_FOUND(HttpStatus.NOT_FOUND, "Tomato_not_found", "일지를 찾을 수 없습니다.")
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
