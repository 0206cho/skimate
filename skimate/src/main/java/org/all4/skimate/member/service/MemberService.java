package org.all4.skimate.member.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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


    @Transactional
    public void memberUpdate(String memberId, MemberDto memberDto){
        Member member = memberRepository.findByMemberId(memberId).orElseThrow(() -> new IllegalArgumentException("해당 회원은 존재하지 않습니다."));

        member.updateMemberInfo(memberDto);
    }
}
