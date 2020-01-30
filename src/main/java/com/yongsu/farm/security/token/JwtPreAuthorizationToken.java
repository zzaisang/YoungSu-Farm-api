package com.yongsu.farm.security.token;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/01/30
 */
public class JwtPreAuthorizationToken extends UsernamePasswordAuthenticationToken {
    public JwtPreAuthorizationToken(String token) {
        super(token, token.length());
    }
}
