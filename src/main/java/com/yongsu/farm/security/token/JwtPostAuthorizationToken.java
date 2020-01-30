package com.yongsu.farm.security.token;

import com.yongsu.farm.security.account.AccountContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/01/30
 */
public class JwtPostAuthorizationToken extends UsernamePasswordAuthenticationToken {

    public JwtPostAuthorizationToken(String userName, String credentials, Collection<? extends GrantedAuthority> authorities) {
        super(userName, credentials, authorities);
    }

    public static JwtPostAuthorizationToken fromAccountContext(AccountContext accountContext) {
        return new JwtPostAuthorizationToken(accountContext.getUsername(), accountContext.getPassword(), accountContext.getAuthorities());
    }

}
