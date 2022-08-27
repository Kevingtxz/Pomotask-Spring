package com.pomotask.pomotask.security.exception;

import org.springframework.security.core.AuthenticationException;

public class AuthenticationProcessingException extends AuthenticationException {


    public AuthenticationProcessingException(String msg, Throwable t) {
        super(msg, t);
    }

    public AuthenticationProcessingException(String msg) {
        super(msg);
    }

}
