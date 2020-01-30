package com.yongsu.farm.security.account;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/01/30
 */
public class AccountContext extends User {

    public AccountContext(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public AccountContext(String username, String password, String role) {
        super(username, password, Arrays.asList(new SimpleGrantedAuthority(role)));
    }
}
