package com.yongsu.farm.advice.global;

import com.yongsu.farm.dto.api.ApiResult;
import com.yongsu.farm.dto.api.Code;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/01/30
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionAdvice {

    /**
     * 프로젝트 내 Exception 처리 하는 handler
     *
     * */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResult> globalExceptionHandler(Exception e) {

        log.error("{}",e);

        final HttpStatus httpStatus = getHttpStatusByException(e);
        final Code code = Code.BAD_REQUEST.equals(httpStatus) ? Code.BAD_REQUEST : Code.ERROR;

        final ApiResult apiResult = ApiResult.builder()
                .httpStatus(httpStatus)
                .code(code)
                .message(e.getMessage())
                .timestamp(System.currentTimeMillis())
                .build();

        return new ResponseEntity<>(apiResult,httpStatus);
    }

    private HttpStatus getHttpStatusByException(Exception e) {
        if (e instanceof IllegalArgumentException || e instanceof IllegalStateException) {
            return HttpStatus.BAD_REQUEST;
        } else
            return HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
