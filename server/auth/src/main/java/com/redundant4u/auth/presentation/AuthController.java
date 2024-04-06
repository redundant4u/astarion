package com.redundant4u.auth.presentation;

import com.redundant4u.auth.application.AuthService;
import com.redundant4u.auth.presentation.dto.LoginRequest;
import com.redundant4u.auth.presentation.dto.LoginResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class AuthController {

  private final AuthService authService;

  @PostMapping
  public ResponseEntity<LoginResponse> login(@RequestBody @Valid final LoginRequest req) {
    LoginResponse res = authService.login(req);
    return ResponseEntity.ok(res);
  }
}