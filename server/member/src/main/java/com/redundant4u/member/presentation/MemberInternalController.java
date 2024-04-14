package com.redundant4u.member.presentation;

import com.redundant4u.member.FindMemberIdByAccountAndPassword;
import com.redundant4u.member.MemberInternal;
import com.redundant4u.member.application.MemberInternalService;
import com.redundant4u.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internal")
@RequiredArgsConstructor
public class MemberInternalController {
  private final MemberInternalService memberInternalService;

  @PostMapping()
  public Long register(@RequestBody MemberInternal request) {
    return memberInternalService.register(request);
  }

  @PostMapping("/findMemberByAccountAndPassword")
  public Member findMemberByAccountAndPassword(@RequestBody FindMemberIdByAccountAndPassword request) {
    return memberInternalService.findMemberByAccountAndPassword(request.getAccount(), request.getPassword());
  }
}
