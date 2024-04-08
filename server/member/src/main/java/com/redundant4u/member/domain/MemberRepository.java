package com.redundant4u.member.domain;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

  Optional<Member> findByAccountOrEmail(String account, String email);

  Optional<Member> findByAccountAndPassword(String account, String password);
}
