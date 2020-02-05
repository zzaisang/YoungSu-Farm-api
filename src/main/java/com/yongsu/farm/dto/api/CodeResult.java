package com.yongsu.farm.dto.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.util.Optional;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/02/05
 */
@Getter
public class CodeResult<T> {

    private final Code code;

    private final T data;

    private final String message;

    public CodeResult(Code code) {
        this(code, null, Optional.ofNullable(code.getDefaultMessageCode()).orElse(""));
    }

    public CodeResult(Code code, T data) {
        this(code, data, null);
    }

    public CodeResult(Code code, String message){
        this.code = code;
        this.data = null;
        this.message = message;
    }

    public CodeResult(Code code, T data, String message) {
        super();
        this.code = code;
        this.data = data;
        this.message = message;
    }

    @JsonIgnore
    public boolean isSucceeded() {
        return code == Code.SUCCESS;
    }
}
