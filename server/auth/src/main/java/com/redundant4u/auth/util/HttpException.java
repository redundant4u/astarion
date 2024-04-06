package com.redundant4u.auth.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class HttpException {

  private final ObjectMapper objectMapper;

  @ExceptionHandler(FeignException.class)
  public ResponseEntity feignExceptionHandler(FeignException feignException)
      throws JsonProcessingException {
    String responseJson = feignException.contentUTF8();
    Map<String, String> responseMap = objectMapper.readValue(responseJson, Map.class);

    return ResponseEntity.status(feignException.status()).body(responseMap);
  }
}
