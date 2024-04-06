package com.redundant4u.auth.application;

import com.redundant4u.auth.domain.MemberServiceClient;
import com.redundant4u.auth.presentation.dto.LoginRequest;
import com.redundant4u.auth.presentation.dto.LoginResponse;
import com.redundant4u.member.FindMemberIdByAccountAndPassword;
import com.redundant4u.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final MemberServiceClient memberServiceClient;

  private final JwtTokenProvider jwtTokenProvider;

  public LoginResponse login(LoginRequest req) {
    FindMemberIdByAccountAndPassword request = new FindMemberIdByAccountAndPassword(
        req.getAccount(), req.getPassword()
    );
    Member member = memberServiceClient.findMemberIdByAccountAndPassword(request);

    if (member == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member is not existed");
    }

    String accessToken = jwtTokenProvider.createAccessToken(member.getId());
    System.out.println(accessToken);

    return LoginResponse.of(accessToken);
  }
}
