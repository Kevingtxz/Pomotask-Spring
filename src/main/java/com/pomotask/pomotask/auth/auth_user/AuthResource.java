package com.pomotask.pomotask.auth.auth_user;

import com.pomotask.pomotask.config.security.oauth2.AuthPrincipal;
import com.pomotask.pomotask.config.security.oauth2.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.pomotask.pomotask.util.Version.API_VERSION_FOR_URL;

@RestController
@RequestMapping(value = API_VERSION_FOR_URL + "auth")
public class AuthResource {


    @Autowired
    private AuthService service;


    @GetMapping
    public ResponseEntity<Integer> findOrInsertByEmailProfile(
            @AuthenticationPrincipal(expression = "userId") Integer userId) {
        return ResponseEntity.ok().body(userId);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteByEmail(
            @CurrentUser AuthPrincipal principal) {
        String email = principal.getAttribute("email");
        service.deleteByEmail(email);
        return ResponseEntity.noContent().build();
    }

}
