package com.redundant4u.member.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.redundant4u.member.application.MemberService;
import com.redundant4u.member.domain.Member;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberSerivce;

    @GetMapping("/{memberId}")
    public Member findMemberById(@PathVariable Long memberId) {
        return memberSerivce.findMemberById(memberId);
    }
}
