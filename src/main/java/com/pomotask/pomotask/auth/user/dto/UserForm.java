package com.pomotask.pomotask.auth.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class UserForm {

    private Integer id;
    @NotNull
    private String email;

}