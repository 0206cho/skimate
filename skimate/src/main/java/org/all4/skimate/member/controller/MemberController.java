package org.all4.skimate.member.controller;


import lombok.RequiredArgsConstructor;
import org.all4.skimate.jwt.service.JwtService;
import org.all4.skimate.member.domain.Member;
import org.all4.skimate.member.domain.MemberDto;
import org.all4.skimate.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    private final JwtService jwtService;

    @PostMapping("/sign-up")
    public String signUp(@RequestBody MemberDto memberDto) throws Exception {
        memberService.signUp(memberDto);
        return "ok";
    }

    @GetMapping("/jwt-test")
    public String jwtTest(HttpServletRequest request){
        String accessToken = jwtService.extractAccessToken(request).orElseThrow(() -> new IllegalArgumentException("토큰이없습니다."));
        String memberId = jwtService.extractMemberId(accessToken).orElseThrow(() -> new IllegalArgumentException("해당아이디 존재하지 않습니다,"));

        Member byTokenMember = memberService.findByTokenMember(memberId);
        return byTokenMember.getMemberId();
    }

}
