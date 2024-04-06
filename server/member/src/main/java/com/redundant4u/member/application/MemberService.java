package com.redundant4u.member.application;

import com.redundant4u.common.ErrorCode;
import com.redundant4u.common.HttpException;
import com.redundant4u.member.domain.Member;
import com.redundant4u.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  public Member findMemberIdByIdAndEmail(
      final String account,
      final String password
  ) {
    return memberRepository.findByAccountAndPassword(account, password)
        .orElseThrow(() -> new HttpException(ErrorCode.MEMBER_NOT_FOUND));
  }
}
