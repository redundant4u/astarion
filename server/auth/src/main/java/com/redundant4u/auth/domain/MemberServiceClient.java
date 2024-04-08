package com.redundant4u.auth.domain;

import com.redundant4u.member.FindMemberIdByAccountAndPassword;
import com.redundant4u.member.MemberInternal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "member", url = "http://localhost:8081/internal")
public interface MemberServiceClient {
  @PostMapping()
  Long register(@RequestBody MemberInternal member);

  @PostMapping("/findMemberByAccountAndPassword")
  MemberInternal findMemberIdByAccountAndPassword(@RequestBody FindMemberIdByAccountAndPassword request);
}
