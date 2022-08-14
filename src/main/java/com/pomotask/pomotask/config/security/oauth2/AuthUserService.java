package com.pomotask.pomotask.config.security.oauth2;

import com.pomotask.pomotask.auth.auth.AuthModel;
import com.pomotask.pomotask.auth.auth.AuthService;
import com.pomotask.pomotask.config.security.exception.AuthenticationProcessingException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class AuthUserService extends DefaultOAuth2UserService {


    @Autowired
    private AuthService authService;


    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);

        try {
            return processOAuth2User(oAuth2UserRequest, oAuth2User);
        } catch (AuthenticationException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }

    }

    private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
        AuthUserInfo auth2UserInfo = new AuthUserInfo(oAuth2User.getAttributes());
        if(StringUtils.isEmpty(auth2UserInfo.getEmail()))
            throw new AuthenticationProcessingException("Email not found");
        AuthModel auth = authService
                .findOrInsertByEmail(auth2UserInfo.getEmail());
        return new AuthPrincipal(auth, oAuth2User.getAttributes());
    }

}
