package com.pomotask.pomotask.auth.auth_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "auth")
public class AuthResource {


    @Autowired
    private AuthService service;


    @GetMapping
    public ResponseEntity<OAuth2User> findOrInsertByEmailProfile(
            @AuthenticationPrincipal OAuth2User principal) {
        String email = principal.getAttribute("email");
        this.service.findOrInsertByEmail(email);
        return ResponseEntity.ok().body(principal);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteByEmail(
            @AuthenticationPrincipal OAuth2User principal) {
        String email = principal.getAttribute("email");
        service.deleteByEmail(email);
        return ResponseEntity.noContent().build();
    }

}
