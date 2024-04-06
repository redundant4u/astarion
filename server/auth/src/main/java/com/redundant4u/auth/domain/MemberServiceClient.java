package com.redundant4u.auth.domain;

import com.redundant4u.member.FindMemberIdByAccountAndPassword;
import com.redundant4u.member.Member;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "member", url = "http://localhost:8081")
public interface MemberServiceClient {

  @PostMapping()
  Member findMemberIdByAccountAndPassword(
      @RequestBody FindMemberIdByAccountAndPassword request
  );
}