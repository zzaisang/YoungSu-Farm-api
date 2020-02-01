package com.yongsu.farm.dto.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/02/01
 */
@Getter
@AllArgsConstructor
public enum Code {

    // 공통
    SUCCESS(0, HttpStatus.OK, null),
    BAD_REQUEST(1, HttpStatus.BAD_REQUEST, "common.error.bad_request"),
    ILLEGAL_STATE(2, HttpStatus.BAD_REQUEST, "common.error.illegal_state"),
    UNAUTHENTICATED(3, HttpStatus.UNAUTHORIZED, null),
    UNAUTHORIZED(4, HttpStatus.FORBIDDEN, null),
    NOT_FOUND(5, HttpStatus.NOT_FOUND, null),
    CONFLICT(6, HttpStatus.CONFLICT, null),
    TIMEOUT(900, HttpStatus.REQUEST_TIMEOUT, null),
    ERROR(999, HttpStatus.INTERNAL_SERVER_ERROR, "common.error.server_fault");

    private static final Map<Integer, Code> table;

    static {
        table = new HashMap<>();

        for (Code code : values()) {
            table.put(code.id, code);
        }
    }

    private int id;

    private HttpStatus httpStatus;

    private String defaultMessageCode;

    @JsonCreator
    public static Code create(String value) {
        return table.get(Integer.parseInt(value));
    }

    @Component
    public static class CodeConverter implements Converter<String, Code> {

        @Override
        public Code convert(String source) {
            return Code.create(source);
        }
    }
}
