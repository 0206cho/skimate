package org.all4.skimate.login.service;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.all4.skimate.member.domain.Member;
import org.all4.skimate.member.repository.MemberRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
@Slf4j
public class LoginService implements UserDetailsService {

    private final MemberRepository memberRepository;


    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        log.info("json 로그인실행!!!!");
        Member member = memberRepository.findByMemberId(memberId)
                .orElseThrow(() -> new UsernameNotFoundException("해당 아이디 존재하지 않아요"));

        log.info("사용자 비밀번호 : {}" , member.getMemberPw());

        UserDetails build = User.builder()
                .username(member.getMemberId())
                .password(member.getMemberPw())
                .roles(member.getRole().name())
                .build();

        return build;
    }
}
