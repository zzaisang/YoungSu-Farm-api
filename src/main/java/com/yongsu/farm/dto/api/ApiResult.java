package com.yongsu.farm.dto.api;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/02/01
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResult<T> {

    @JsonProperty("c")
    private Code code = Code.ERROR;

    @JsonProperty("m")
    private String message;

    @JsonProperty("d")
    private T data;

    @JsonProperty("ts")
    private long timestamp = 0;

    @JsonIgnore
    private HttpStatus httpStatus;

    @Builder
    public ApiResult(Code code, String message, T data, long timestamp, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = timestamp;
        this.httpStatus = httpStatus;
    }

    @JsonIgnore
    public boolean isSucceeded() {
        return code == Code.SUCCESS;
    }

    @JsonIgnore
    public boolean isMessageExist() {
        return (message != null && message.length() > 0);
    }

    public <U> ApiResult<U> map(Function<? super T, U> mapper) {
        Objects.requireNonNull(mapper);
        if (isSucceeded()) {
            return ApiResult.ok(mapper.apply(data));
        } else {
            return ApiResult.fail(code);
        }
    }

    public ApiResult<T> filter(Predicate<T> predicate) {
        return predicate.test(data) ? this : ApiResult.fail(code);
    }

    /**
     * @param code 결과 코드
     * @return 결과 객체
     */
    public ApiResult<T> code(@NotNull Code code) {
        this.code = code;
        return this;
    }

    /**
     * @param data 결과 데이터
     * @return 결과 객체
     */
    public ApiResult<T> data(T data) {
        this.data = data;
        return this;
    }

    /**
     * @param message 결과 메시지
     * @return 결과 객체
     */
    public ApiResult<T> message(String message) {
        this.message = message;
        return this;
    }

    /**
     * @param httpStatus HTTP 상태값
     * @return 결과 객체
     */
    public ApiResult<T> httpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    public ResponseEntity createResponseEntity() {
        return ResponseEntity.status(httpStatus).body(this);
    }

    /**
     * 성공 객체를 생성한다.
     *
     * @return 성공 객체
     */
    public static <T> ApiResult<T> ok() {
        return ok(null, null);
    }

    /**
     * 성공 객체를 생성한다.
     *
     * @param data 데이터 객체
     * @return 성공 객체
     */
    public static <T> ApiResult<T> ok(T data) {
        return ok(data, null);
    }

    /**
     * 성공 객체를 생성한다.
     *
     * @param data    결과 데이터
     * @param message 성공 메시지
     * @return 결과 객체
     */
    public static <T> ApiResult<T> ok(T data, String message) {
        return with(data).code(Code.SUCCESS).message(message).httpStatus(HttpStatus.OK);
    }

    public static <T> ApiResult<T> badRequest() {
        return with((T) null).code(Code.BAD_REQUEST).message(null).httpStatus(HttpStatus.BAD_REQUEST);
    }

    public static <T> ApiResult<T> badRequest(String message) {
        return with((T) null).code(Code.BAD_REQUEST).message(message).httpStatus(HttpStatus.BAD_REQUEST);
    }

    public static <T> ApiResult<T> illegalState() {
        return with((T) null).code(Code.ILLEGAL_STATE).message(null).httpStatus(HttpStatus.BAD_REQUEST);
    }

    public static <T> ApiResult<T> illegalState(String message) {
        return with((T) null).code(Code.ILLEGAL_STATE).message(message).httpStatus(HttpStatus.BAD_REQUEST);
    }

    public static <T> ApiResult<T> unauthenticate() {
        return with((T) null).code(Code.UNAUTHENTICATED).message(null).httpStatus(HttpStatus.UNAUTHORIZED);
    }

    public static <T> ApiResult<T> unauthenticate(String message) {
        return with((T) null).code(Code.UNAUTHENTICATED).message(message).httpStatus(HttpStatus.UNAUTHORIZED);
    }

    public static <T> ApiResult<T> unauthorize() {
        return with((T) null).code(Code.UNAUTHORIZED).message(null).httpStatus(HttpStatus.FORBIDDEN);
    }

    public static <T> ApiResult<T> unauthorize(String message) {
        return with((T) null).code(Code.UNAUTHORIZED).message(message).httpStatus(HttpStatus.FORBIDDEN);
    }

    public static <T> ApiResult<T> notFound() {
        return with((T) null).code(Code.NOT_FOUND).message(null).httpStatus(HttpStatus.NOT_FOUND);
    }

    public static <T> ApiResult<T> notFound(String message) {
        return with((T) null).code(Code.NOT_FOUND).message(message).httpStatus(HttpStatus.NOT_FOUND);
    }

    public static <T> ApiResult<T> error() {
        return with((T) null).code(Code.ERROR).message(null).httpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static <T> ApiResult<T> error(String message) {
        return with((T) null).code(Code.ERROR).message(message).httpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * 실패 객체를 생성한다.
     *
     * @param code 에러 코드
     * @return 결과 객체
     */
    public static <T> ApiResult<T> fail(@NotNull Code code) {
        return with((T) null).code(code).httpStatus(code.getHttpStatus());
    }

    public static <T> ApiResult<T> fail(@NotNull Code code, T data) {
        return with(data).code(code).httpStatus(code.getHttpStatus());
    }

    /**
     * 실패 객체를 생성한다.
     *
     * @param code    에러 코드
     * @param message 에러 메시지
     * @return 결과 객체
     */
    public static <T> ApiResult<T> fail(@NotNull Code code, String message) {
        return with((T) null).code(code).message(message).httpStatus(code.getHttpStatus());
    }

    /**
     * 실패 객체를 생성한다.
     *
     * @param code       에러 코드
     * @param message    에러 메시지
     * @param httpStatus HTTP 상태코드
     * @return 결과 객체
     */
    public static <T> ApiResult<T> fail(Code code, String message, HttpStatus httpStatus) {
        return with((T) null).code(code).message(message).httpStatus(httpStatus);
    }

    /**
     * 객체를 생성한다.
     *
     * @param data 결과 데이터
     * @return 결과 객체
     */
    private static <T> ApiResult<T> with(T data) {
        ApiResult<T> response = new ApiResult<>();
        response.data = data;
        response.timestamp = System.currentTimeMillis();

        return response;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
