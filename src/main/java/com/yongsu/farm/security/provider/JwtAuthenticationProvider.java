package com.yongsu.farm.security.provider;

import com.yongsu.farm.security.account.AccountContext;
import com.yongsu.farm.security.jwt.JwtDecode;
import com.yongsu.farm.security.token.JwtPostAuthorizationToken;
import com.yongsu.farm.security.token.JwtPreAuthorizationToken;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/01/30
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private final JwtDecode jwtDecode;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        final String token = (String) authentication.getPrincipal();

        final AccountContext accountContext = jwtDecode.decodeToken(token);

        return JwtPostAuthorizationToken.fromAccountContext(accountContext);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtPreAuthorizationToken.class.isAssignableFrom(authentication);
    }
}
