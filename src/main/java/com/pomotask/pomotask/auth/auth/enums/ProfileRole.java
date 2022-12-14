package com.pomotask.pomotask.auth.auth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProfileRole {


    ADMIN(1, "ROLE_ADMIN"),
    USER(2, "ROLE_USER");


    private int cod;
    private String text;


    public static ProfileRole toEnum(Integer cod) {
        if (cod == null) return null;
        for (ProfileRole paymentState : ProfileRole.values())
            if (cod.equals(paymentState.getCod()))
                return paymentState;
        throw new IllegalStateException("Id inválido: " + cod);
    }

}
