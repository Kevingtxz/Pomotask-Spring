package com.pomotask.pomotask.auth.auth;

import com.pomotask.pomotask.security.oauth2.AuthPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.pomotask.pomotask.util.VersionUtil.API_VERSION_FOR_URL;

@RestController
@RequestMapping(value = API_VERSION_FOR_URL + "/auth")
public class AuthResource {


    @Autowired
    private AuthService service;


    @GetMapping
    public ResponseEntity<AuthPrincipal> getPrincipal(
            @AuthenticationPrincipal AuthPrincipal principal) {
        return ResponseEntity.ok().body(principal);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteByEmail(
            @AuthenticationPrincipal AuthPrincipal principal) {
        String email = principal.getAttribute("email");
        service.deleteByEmail(email);
        return ResponseEntity.noContent().build();
    }

}
