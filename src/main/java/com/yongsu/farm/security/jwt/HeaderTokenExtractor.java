package com.yongsu.farm.security.jwt;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020-02-04
 */
public interface HeaderTokenExtractor {
    String extract(String header);
}
