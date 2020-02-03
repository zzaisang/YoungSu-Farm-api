package com.yongsu.farm.security.jwt.impl;

import com.yongsu.farm.security.jwt.HeaderTokenExtractor;
import com.yongsu.farm.security.jwt.exception.InvalidJwtException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020-02-04
 */
@Component
public class HeaderTokenExtractorImpl implements HeaderTokenExtractor {

    public static final String HEADER_PREFIX = "Bearer";

    @Override
    public String extract(String header) {

        if (StringUtils.isEmpty(header) || header.length() < HEADER_PREFIX.length()) {
            throw new InvalidJwtException("올바른 토큰 정보가 아닙니다.");
        }

        return header.substring(HEADER_PREFIX.length());
    }
}
