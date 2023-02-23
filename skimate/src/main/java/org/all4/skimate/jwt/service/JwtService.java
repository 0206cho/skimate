package org.all4.skimate.jwt.service;



import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.all4.skimate.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Getter
@Slf4j
public class JwtService {

    @Value("${jwt.secretKey}")
    private String secretKey;

    @Value("${jwt.access.expiration}")
    private Long accessTokenExpirationPeriod;
    @Value("${jwt.refresh.expiration}")
    private Long refreshTokenExpirationPeriod;
    @Value("${jwt.access.header}")
    private String accessHeader;
    @Value("${jwt.refresh.header}")
    private String refreshHeader;

    private static final String ACCESS_TOKEN_SUBJECT = "AccessToken";
    private static final String REFRESH_TOKEN_SUBJECT = "RefreshToken";
    private static final String ID_CLAIM = "memberId";
    private static final String BEARER = "Bearer ";

    private final MemberRepository memberRepository;

    public String createAccessToken(String memberId){
        log.info("토큰생성");
        Date now = new Date();

        return JWT.create()
                .withSubject(ACCESS_TOKEN_SUBJECT)
                .withExpiresAt(new Date(now.getTime() + accessTokenExpirationPeriod))
                .withClaim(ID_CLAIM, memberId)
                .sign(Algorithm.HMAC512(secretKey));
    }

    public String createRefreshToken(){
        Date now = new Date();

        return JWT.create()
                .withSubject(REFRESH_TOKEN_SUBJECT)
                .withExpiresAt(new Date(now.getTime() + refreshTokenExpirationPeriod))
                .sign(Algorithm.HMAC512(secretKey));
    }

    public void sendAccessToken(HttpServletResponse response, String accessToken){
        response.setStatus(HttpServletResponse.SC_OK);

        response.setHeader(accessHeader, accessToken);
    }

    public void sendAccessTokenAndRefreshToken(HttpServletResponse response, String accessToken, String refreshToken){

        response.setStatus(HttpServletResponse.SC_OK);

        setAccessTokenHeader(response, accessToken);
        setRefreshTokenHeader(response, refreshToken);
        log.info("Access Token, Refresh Token 헤더 설정");
    }

    public Optional<String> extractRefreshToken(HttpServletRequest request){
        log.info("extractRefreshToken 호출");
        return Optional.ofNullable(request.getHeader(refreshHeader))
                .filter(refreshToken -> refreshToken.startsWith(BEARER))
                .map(refreshToken->refreshToken.replace(BEARER, ""));
    }

    public Optional<String> extractAccessToken(HttpServletRequest request){
        log.info("extractAccessToken 호출");
        return Optional.ofNullable(request.getHeader(accessHeader))
                .filter(refreshToken -> refreshToken.startsWith(BEARER))
                .map(refreshToken -> refreshToken.replace(BEARER, ""));


    }

    public Optional<String> extractMemberId(String accessToken){
        try{
            log.info("memberId 추출작업");
            return Optional.ofNullable(JWT.require(Algorithm.HMAC512(secretKey))
                    .build()
                    .verify(accessToken)
                    .getClaim(ID_CLAIM)
                    .asString());


        }catch (Exception e){
            return Optional.empty();
        }
    }

    public void setAccessTokenHeader(HttpServletResponse response, String accessToken) {
        response.setHeader(accessHeader, accessToken);
    }

    public void setRefreshTokenHeader(HttpServletResponse response, String refreshToken) {
        response.setHeader(refreshHeader, refreshToken);
    }

    public void updateRefreshToken(String memberId, String refreshToken){
        memberRepository.findByMemberId(memberId)
                .ifPresentOrElse(member -> member.updateRefreshToken(refreshToken)
                , ()->new Exception("일치하는 회원이 없습니다."));

    }

    public boolean isTokenValid(String token){
        try{
            log.info("토큰 검증");
            JWT.require(Algorithm.HMAC512(secretKey)).build().verify(token);
            return true;
        }catch (Exception e){
            log.error("유효하지 않은 토큰입니다. {}", e.getMessage());
            return false;
        }
    }

    public String getTokenMemberId(HttpServletRequest request) {
        String accessToken = extractAccessToken(request).orElseThrow(() -> new IllegalArgumentException("토큰이없습니다."));
        String memberId = extractMemberId(accessToken).orElseThrow(() -> new IllegalArgumentException("해당아이디 존재하지 않습니다,"));
        return memberId;
    }


}
