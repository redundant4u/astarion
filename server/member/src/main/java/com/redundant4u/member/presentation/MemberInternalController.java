package com.redundant4u.member.presentation;

import com.redundant4u.member.FindMemberIdByAccountAndPassword;
import com.redundant4u.member.application.MemberService;
import com.redundant4u.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberInternalController {

  private final MemberService memberService;

  @PostMapping
  public Member findMemberIdByIdAndEmail(@RequestBody FindMemberIdByAccountAndPassword request) {
    return memberService.findMemberIdByIdAndEmail(request.getAccount(), request.getPassword());
  }
}
