package com.redundant4u.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class HttpException extends RuntimeException {

  private final String type;
  private final String message;
  private final HttpStatus httpStatus;

  public HttpException(ErrorCode errorCode) {
    super(errorCode.getMessage());

    this.type = errorCode.getType();
    this.message = errorCode.getMessage();
    this.httpStatus = errorCode.getHttpStatus();
  }
}
