package com.redundant4u.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberInternal {

  private Long id;

  private String account;

  private String password;

  private String email;
}
