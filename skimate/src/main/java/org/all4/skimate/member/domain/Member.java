package org.all4.skimate.member.domain;

import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Builder
@Table(name = "member")
@AllArgsConstructor
public class Member {

    @Id
    private String memberId;

    private String memberName;

    private String memberPw;

    private String memberPhone;

    private String memberAddress;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private String socialId;

    private String refreshToken;

    public void authorizeUser(){
        this.role = Role.USER;
    }

    public void passwordEncode(PasswordEncoder passwordEncoder){
        this.memberPw = passwordEncoder.encode(this.memberPw);
    }

    public void updateRefreshToken(String updateRefreshToken){
        this.refreshToken = updateRefreshToken;
    }

}
