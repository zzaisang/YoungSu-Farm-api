package com.yongsu.farm.advice.business;

import com.yongsu.farm.dto.api.ApiResult;
import com.yongsu.farm.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/02/07
 */
@Slf4j
@ControllerAdvice
@Order(1)
public class BusinessExceptionAdvice {

    /**
     * 예상할 수 있는 Business Exception 을 처리하는 ExceptionHandler
     **/
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResult> BusinessExceptionHandler(BusinessException e) {
        log.error("{}", e);
        return ApiResult.fail(e.getCode(),e.getMessage()).createResponseEntity();
    }

}
