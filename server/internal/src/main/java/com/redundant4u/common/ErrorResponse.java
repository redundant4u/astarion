package com.redundant4u.common;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
@Builder
public class ErrorResponse {

  private final String type;
  private final String message;

  public static ResponseEntity<ErrorResponse> from(HttpException httpException) {
    return ResponseEntity
        .status(httpException.getHttpStatus())
        .body(
            ErrorResponse.builder()
                .type(httpException.getType())
                .message(httpException.getMessage())
                .build());
  }
}
