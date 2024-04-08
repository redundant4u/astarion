package com.redundant4u.auth.presentation;

import com.redundant4u.auth.application.AuthService;
import com.redundant4u.auth.presentation.dto.LoginRequest;
import com.redundant4u.auth.presentation.dto.LoginResponse;
import com.redundant4u.auth.presentation.dto.RegisterRequest;
import com.redundant4u.member.MemberInternal;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
  public ResponseEntity<LoginResponse> login(@RequestBody @Valid final LoginRequest request) {
    LoginResponse response = authService.login(request);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @PostMapping("register")
  public ResponseEntity<MemberInternal> register(@RequestBody @Valid final RegisterRequest request) {
    MemberInternal member = authService.register(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(member);
  }
}
