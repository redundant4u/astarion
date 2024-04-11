package com.redundant4u.member;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FindMemberIdByAccountAndPassword {

  @NotNull
  private String account;

  @NotNull
  private String password;
}
