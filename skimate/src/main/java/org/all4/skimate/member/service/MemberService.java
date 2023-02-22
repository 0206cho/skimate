package org.all4.skimate.member.service;


import lombok.RequiredArgsConstructor;
import org.all4.skimate.member.domain.MemberDto;
import org.all4.skimate.member.repository.MemberRepository;
import org.all4.skimate.member.domain.Member;
import org.all4.skimate.member.domain.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(MemberDto memberDto) throws Exception {
        if(memberRepository.findByMemberId(memberDto.getMemberId()).isPresent()){
            throw new Exception("이미 존재하는 아이디입니다.");
        }

        Member member = Member.builder()
                .memberId(memberDto.getMemberId())
                .memberPw(memberDto.getMemberPw())
                .memberAddress(memberDto.getMemberAddress())
                .memberName(memberDto.getMemberName())
                .memberPhone(memberDto.getMemberPhone())
                .role(Role.USER)
                .build();


        member.passwordEncode(passwordEncoder);
        memberRepository.save(member);
    }

    public Member findByTokenMember(String memberId){
        Member member = memberRepository.findByMemberId(memberId).orElseThrow(() -> new IllegalArgumentException("xxxx"));
        return member;
    }
}
