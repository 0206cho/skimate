package org.all4.skimate.oauth2.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.all4.skimate.jwt.service.JwtService;
import org.all4.skimate.member.repository.MemberRepository;
import org.all4.skimate.member.domain.Role;
import org.all4.skimate.oauth2.oauthInfo.CustomOAuth2User;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
@Component
@RequiredArgsConstructor
public class OAuth2LoginSuccessHandler implements AuthenticationSuccessHandler {
    private final JwtService jwtService;
    private final MemberRepository memberRepository;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        log.info("소셜 로그인 성공!!!!");
        try{
            CustomOAuth2User oAuth2User=(CustomOAuth2User) authentication.getPrincipal();

            if(oAuth2User.getRole() == Role.GUEST){
                String accessToken = jwtService.createAccessToken(oAuth2User.getUserId());
                response.addHeader(jwtService.getAccessHeader(), "Bearer " + accessToken);
                response.sendRedirect("http://localhost:3000/oauth/redirect?token="+accessToken+"&role="+oAuth2User.getRole()); //회원가입시 추가적으로 필요한 정보를 입력하게끔 해당 페이지로 이동시켜서 나머지 회원가입을 진해하도록 하는 로직
                jwtService.sendAccessTokenAndRefreshToken(response, accessToken, null);
//                Member member = memberRepository.findByMemberId(oAuth2User.getUserId()).orElseThrow(() -> new IllegalArgumentException("해당아이디 없습니다."));
//                member.authorizeUser();
            } else {
                loginSuccess(response, oAuth2User);
            }
        }catch (Exception e){
            throw  e;
        }
    }

    private void loginSuccess(HttpServletResponse response, CustomOAuth2User oAuth2User) throws IOException {
        String accessToken = jwtService.createAccessToken(oAuth2User.getUserId());
        String refreshToken = jwtService.createRefreshToken();
        response.addHeader(jwtService.getAccessHeader(), "Bearer" + accessToken);
        response.addHeader(jwtService.getRefreshHeader(), "Bearer" + refreshToken);
        response.sendRedirect("http://localhost:3000/oauth/redirect?token="+accessToken+"&role="+oAuth2User.getRole());

        jwtService.sendAccessTokenAndRefreshToken(response, accessToken, refreshToken);
        jwtService.updateRefreshToken(oAuth2User.getUserId(), refreshToken);

    }
}
