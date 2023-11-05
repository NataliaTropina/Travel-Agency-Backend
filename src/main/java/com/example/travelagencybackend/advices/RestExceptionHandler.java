package com.example.travelagencybackend.advices;

import com.example.travelagencybackend.dto.StandardResponseDto;
import com.example.travelagencybackend.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<StandardResponseDto> handleNotFound(NotFoundException ex) {
        log.error(ex.toString());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(StandardResponseDto.builder()
                        .message(ex.getMessage())
                        //.status(HttpStatus.NOT_FOUND.value())
                        .build());
    }
}
