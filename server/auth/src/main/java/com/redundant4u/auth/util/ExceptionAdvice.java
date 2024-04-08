package com.redundant4u.auth.util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redundant4u.common.ErrorResponse;
import com.redundant4u.common.HttpException;

import feign.FeignException;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionAdvice {

    private final ObjectMapper objectMapper;

    @ExceptionHandler(HttpException.class)
    public ResponseEntity httpExceptionHandler(HttpException exception) {
        return ErrorResponse.from(exception);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity feignExceptionHandler(FeignException feignException)
            throws JsonProcessingException {
        String responseJson = feignException.contentUTF8();
        Map<String, String> responseMap = objectMapper.readValue(responseJson, Map.class);

        return ResponseEntity.status(feignException.status()).body(responseMap);
    }
}
