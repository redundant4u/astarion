package com.redundant4u.auth.application;

import com.redundant4u.auth.domain.MemberServiceClient;
import com.redundant4u.auth.presentation.dto.LoginRequest;
import com.redundant4u.auth.presentation.dto.LoginResponse;
import com.redundant4u.auth.presentation.dto.RegisterRequest;
import com.redundant4u.member.FindMemberIdByAccountAndPassword;
import com.redundant4u.member.MemberInternal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final MemberServiceClient memberServiceClient;

  private final JwtTokenProvider jwtTokenProvider;

  public MemberInternal register(RegisterRequest req) {
    MemberInternal member = new MemberInternal(null, req.getAccount(), req.getPassword(), req.getEmail());
    Long memberId = memberServiceClient.register(member);

    return new MemberInternal(memberId, req.getAccount(), req.getPassword(), req.getEmail());
  }

  public LoginResponse login(LoginRequest req) {
    FindMemberIdByAccountAndPassword request = new FindMemberIdByAccountAndPassword(
        req.getAccount(),
        req.getPassword());

    MemberInternal member = memberServiceClient.findMemberIdByAccountAndPassword(request);
    String accessToken = jwtTokenProvider.createAccessToken(member.getId());

    return LoginResponse.of(accessToken);
  }
}
