package org.all4.skimate.oauth2.oauthInfo;


import lombok.Getter;
import org.all4.skimate.member.domain.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

import java.util.Collection;
import java.util.Map;

@Getter
public class CustomOAuth2User extends DefaultOAuth2User {
    private String userId;
    private Role role;

    public CustomOAuth2User(Collection<? extends GrantedAuthority> authorities, Map<String, Object> attributes, String nameAttributeKey
    ,String userId, Role role) {
        super(authorities, attributes, nameAttributeKey);
        this.userId = userId;
        this.role = role;
    }
}
