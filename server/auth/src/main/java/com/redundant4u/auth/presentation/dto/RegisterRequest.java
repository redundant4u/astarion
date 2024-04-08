package com.redundant4u.auth.presentation.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegisterRequest {

    @NotNull
    private String account;

    @NotNull
    private String password;

    @NotNull
    private String email;
}
