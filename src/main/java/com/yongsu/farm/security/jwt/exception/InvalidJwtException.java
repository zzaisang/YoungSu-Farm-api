package com.yongsu.farm.security.jwt.exception;

import org.springframework.security.authentication.InternalAuthenticationServiceException;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/01/30
 */
public class InvalidJwtException extends InternalAuthenticationServiceException {

    public InvalidJwtException(String message) {
        super(message);
    }
}
