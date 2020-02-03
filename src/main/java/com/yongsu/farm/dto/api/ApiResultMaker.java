package com.yongsu.farm.dto.api;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020-02-04
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResultMaker {

    public static ApiResult ok() {return ApiResult.ok(null,"성공하였습니다.");}

    public static <T> ApiResult<T> ok(T body) {return ApiResult.ok(body,"성공하였습니다.");}

    public static ApiResult unauthenticated() {return ApiResult.fail(Code.UNAUTHENTICATED,"권한이 없습니다.");}

    public static ApiResult unauthorized() {return ApiResult.fail(Code.UNAUTHORIZED,"잘못된 인증 정보입니다.");}
}
