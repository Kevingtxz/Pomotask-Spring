package com.pomotask.pomotask.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RestMethod {


    CREATE("CREATE"),
    READ( "READ"),
    UPDATE( "UPDATE"),
    DELETE("DELETE"),
    PATCH("PATCH");


    private String text;

}
