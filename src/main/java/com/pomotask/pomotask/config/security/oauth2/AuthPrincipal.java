package com.pomotask.pomotask.config.security.oauth2;

import com.pomotask.pomotask.auth.auth_user.AuthModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.*;

@Getter
@Setter
public class AuthPrincipal implements OAuth2User {


    private Integer userId;
    private String email;
    private Collection<? extends GrantedAuthority> authorities;
    private Map<String, Object> attributes;


    public AuthPrincipal(AuthModel auth, Map<String, Object> attributes) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        auth.getProfileRoles()
                .stream()
                .forEach(item -> authorities.add(
                        new SimpleGrantedAuthority(item.getText())));
        this.setAttributes(attributes);
        this.userId = auth.getUser().getId();
        this.email = auth.getEmail();
    }


    @Override
    public String getName() {
        return String.valueOf(userId);
    }

}