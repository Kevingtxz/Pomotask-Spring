package com.pomotask.pomotask.auth.user;

import com.pomotask.pomotask.auth.user.dto.UserMapper;
import com.pomotask.pomotask.auth.user.dto.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "me")
public class UserResource {


    @Autowired
    private UserService service;
    @Autowired
    private UserMapper mapper;


    @GetMapping
    public ResponseEntity<UserView> findById(
            @AuthenticationPrincipal OAuth2User principal) {
        Integer id = principal.getAttribute("userId");
        UserModel obj = this.service.findById(id);
        UserView view = this.mapper.toView(obj);
        return ResponseEntity.ok().body(view);
    }

}
