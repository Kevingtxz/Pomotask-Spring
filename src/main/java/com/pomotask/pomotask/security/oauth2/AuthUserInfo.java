package com.pomotask.pomotask.security.oauth2;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class AuthUserInfo {


    private Map<String, Object> attributes;


    public String getEmail() {
        return (String) this.attributes.get("email");
    }

}
