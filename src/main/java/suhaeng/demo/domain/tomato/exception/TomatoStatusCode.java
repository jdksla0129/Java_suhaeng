package suhaeng.demo.domain.tomato.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import suhaeng.demo.global.exception.statuscode.StatusCode;

@Getter
@RequiredArgsConstructor
public enum TomatoStatusCode implements StatusCode {
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
