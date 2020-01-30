package com.yongsu.farm.security.jwt;

import com.yongsu.farm.security.account.AccountContext;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/01/30
 */
public interface JwtDecode {

    AccountContext decodeToken(String token);

    AccountContext decodeRefreshToken(String token);
}
