package org.all4.skimate.member.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.all4.skimate.jwt.service.JwtService;
import org.all4.skimate.member.domain.Member;
import org.all4.skimate.member.domain.MemberDto;
import org.all4.skimate.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
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
        String memberId = getTokenMemberId(request);

        Member byTokenMember = memberService.findByTokenMember(memberId);
        return byTokenMember.getMemberId();
    }


    @PostMapping("/memberInfoUpdate")
    public String memberInfoUpdate(@RequestBody MemberDto memberDto, HttpServletRequest request){
        String tokenMemberId = getTokenMemberId(request);
        memberService.memberUpdate(tokenMemberId, memberDto);
        log.info("회원 수정");
        return "ok";
    }


    private String getTokenMemberId(HttpServletRequest request) {
        String accessToken = jwtService.extractAccessToken(request).orElseThrow(() -> new IllegalArgumentException("토큰이없습니다."));
        String memberId = jwtService.extractMemberId(accessToken).orElseThrow(() -> new IllegalArgumentException("해당아이디 존재하지 않습니다,"));
        return memberId;
    }

}
