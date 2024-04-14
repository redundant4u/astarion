package com.redundant4u.member.application;

import com.redundant4u.common.ErrorCode;
import com.redundant4u.common.HttpException;
import com.redundant4u.member.MemberInternal;
import com.redundant4u.member.domain.Member;
import com.redundant4u.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberInternalService {
  private final MemberRepository memberRepository;

  public Long register(final MemberInternal request) {
    memberRepository.findByAccountOrEmail(request.getAccount(), request.getEmail())
        .orElseThrow(() -> new HttpException(ErrorCode.MEMBER_ALREADY_EXISTS));

    Member member = Member.builder()
        .account(request.getAccount())
        .password(request.getPassword())
        .email(request.getEmail())
        .build();
    memberRepository.save(member);

    return member.getId();
  }

  public Member findMemberByAccountAndPassword(final String account, final String password) {
    return memberRepository.findByAccountAndPassword(account, password)
        .orElseThrow(() -> new HttpException(ErrorCode.MEMBER_NOT_FOUND));
  }
}
