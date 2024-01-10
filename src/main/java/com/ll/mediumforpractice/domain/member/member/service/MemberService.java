package com.ll.mediumforpractice.domain.member.member.service;

import com.ll.mediumforpractice.domain.member.member.entity.Member;
import com.ll.mediumforpractice.domain.member.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Member join(String username, String password) {
        if (findByUsername(username).isPresent()) {
            return null;
        }

        Member member = new Member(username, password);
        memberRepository.save(member);

        return member;
    }

    public Optional<Member> findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }
}