package com.redundant4u.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
  MEMBER_NOT_FOUND("MEMBER_NOT_FOUND", "Member not found", HttpStatus.NOT_FOUND),
  MEMBER_ALREADY_EXISTS("MEMBER_ALREADY_EXISTS", "Member already exists", HttpStatus.CONFLICT);

  private final String type;
  private final String message;
  private final HttpStatus httpStatus;

  ErrorCode(String type, String message, HttpStatus httpStatus) {
    this.type = type;
    this.message = message;
    this.httpStatus = httpStatus;
  }
}
