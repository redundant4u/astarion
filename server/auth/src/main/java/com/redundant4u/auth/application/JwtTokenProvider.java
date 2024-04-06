package com.redundant4u.auth.application;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

  private final Key secret;

  public JwtTokenProvider(@Value("${spring.jwt.secret}") String secret) {
    this.secret = Keys.hmacShaKeyFor(secret.getBytes());
  }

  public String createAccessToken(Long memberId) {
    String memberIdString = String.valueOf(memberId);
    return Jwts.builder().claim("memberId", memberIdString).signWith(secret).compact();
  }
}
