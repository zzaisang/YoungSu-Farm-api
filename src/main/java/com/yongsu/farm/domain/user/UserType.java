package com.yongsu.farm.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020-03-15
 */
@Getter
@AllArgsConstructor
public enum UserType {

    NON_USER(0,"비회원"),
    KAKAO(1,"카카오"),
    GOOGLE(2,"구글"),
    NAVER(3,"네이버");

    private int id;
    private String name;

    private static Map<Integer, UserType> tables = Stream.of(values()).collect(Collectors.toMap(UserType::getId, Function.identity()));

    public static UserType valueOfId(int key) {
        return tables.get(key);
    }

    @Component
    public static class UserTypeConverter implements Converter<Integer, UserType> {
        public UserType convert(Integer source) {
            return UserType.valueOfId(source);
        }
    }
}
