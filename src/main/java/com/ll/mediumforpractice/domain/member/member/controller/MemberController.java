package com.ll.mediumforpractice.domain.member.member.controller;

import com.ll.mediumforpractice.domain.member.member.entity.Member;
import com.ll.mediumforpractice.domain.member.member.service.MemberService;
import com.ll.mediumforpractice.global.rq.Rq;
import com.ll.mediumforpractice.global.rsData.RsData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final Rq rq;

    @GetMapping("/join")
    public String showJoin() {
        return "domain/member/member/join";
    }

    @Getter
    @Setter
    public static class JoinForm {
        @NotBlank
        public String username;
        @NotBlank
        public String password;
    }

    @PostMapping("/join")
    public String join(@Valid JoinForm joinForm) {
        RsData<Member> joinRs = memberService.join(joinForm.getUsername(), joinForm.getPassword());

        if (joinRs.isFail()) {
            return rq.historyBack(joinRs.getMsg());
        }

        return rq.redirect(
                "/",
                joinRs.getMsg()
        );
    }
}
