package com.pomotask.pomotask.auth.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserView {

    private Integer id;
    private String email;
    private Long createdAt;

}
