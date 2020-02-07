package com.yongsu.farm.exception;

import com.yongsu.farm.dto.api.Code;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/02/07
 */
@Getter @Setter
public class BusinessException extends RuntimeException{

    private Code code;

    public BusinessException(){}

    public BusinessException(Code code) {
        super(code.getDefaultMessageCode());
        this.code = code;
    }

    public BusinessException(Code code,String message) {
        super(message);
        this.code = code;
    }

}
