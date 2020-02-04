package com.yongsu.farm.domain.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.yongsu.farm.util.NumberUtil;
import lombok.Getter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020-02-04
 */
@Getter
public enum YesNo {

    NO("아니오"),
    YES("예");

    private int id;
    private String name;

    YesNo(String name) {
        this.name = name;
    }

    public boolean isYes() {
        return YES == this;
    }

    public boolean isNo() {
        return NO == this;
    }

    @JsonCreator
    public static YesNo create(Object value) {
        return NumberUtil.toInt(value, NO.ordinal()) == 1 ? YES : NO;
    }

    @Component
    public static class CodeConverter implements Converter<String, YesNo> {

        @Override
        public YesNo convert(String source) {
            return YesNo.create(source);
        }
    }
}
