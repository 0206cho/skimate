package org.all4.skimate.member.controller;


import lombok.RequiredArgsConstructor;
import org.all4.skimate.member.domain.MemberDto;
import org.all4.skimate.member.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/sign-up")
    public String signUp(@RequestBody MemberDto memberDto) throws Exception {
        memberService.signUp(memberDto);
        return "ok";
    }

    @GetMapping("/jwt-test")
    public String jwtTest(){
        return "jwtOk";
    }
}
