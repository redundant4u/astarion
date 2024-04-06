package com.redundant4u.auth.presentation.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequest {
    @NotNull
    private String account;

    @NotNull
    private String password;
}
