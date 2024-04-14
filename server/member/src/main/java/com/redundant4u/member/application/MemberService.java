package com.redundant4u.member.application;

import org.springframework.stereotype.Service;

import com.redundant4u.common.ErrorCode;
import com.redundant4u.common.HttpException;
import com.redundant4u.member.domain.Member;
import com.redundant4u.member.domain.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member findMemberById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> new HttpException(ErrorCode.MEMBER_NOT_FOUND));
    }
}
