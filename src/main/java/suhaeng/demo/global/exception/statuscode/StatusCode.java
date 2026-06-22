package suhaeng.demo.global.exception.statuscode;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import suhaeng.demo.global.common.ApiResponse;
import suhaeng.demo.global.common.ErrorResponse;
import java.util.Map;

public interface StatusCode {
    HttpStatus getHttpStatus();
    String getCode();
    String getMessage();

    default ResponseEntity<ApiResponse<Void>> toEntity() {
        ErrorResponse error = ErrorResponse.of(getCode(), getMessage());
        return ResponseEntity
                .status(getHttpStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(ApiResponse.error(getHttpStatus(), error));
    }

    default ResponseEntity<ApiResponse<Void>> toEntity(String message) {
        ErrorResponse error = ErrorResponse.of(getCode(), message);
        return ResponseEntity
                .status(getHttpStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(ApiResponse.error(getHttpStatus(), error));
    }

    default ResponseEntity<ApiResponse<Void>> toEntity(String message, Map<String, String> details) {
        ErrorResponse error = ErrorResponse.of(getCode(), message, details);
        return ResponseEntity
                .status(getHttpStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(ApiResponse.error(getHttpStatus(), error));
    }
}