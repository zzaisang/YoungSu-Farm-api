package com.yongsu.farm.domain.policy;

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
 * @since 2020/02/05
 */
@Getter
@AllArgsConstructor
public enum PackageType {

    BOX(0,"박스");

    private int id;
    private String name;

    private static Map<Integer, PackageType> tables = Stream.of(values()).collect(Collectors.toMap(PackageType::getId, Function.identity()));

    public static PackageType valueOfId(int key) {
        return tables.get(key);
    }

    @Component
    public static class PackageTypeConverter implements Converter<Integer, PackageType> {
        public PackageType convert(Integer source) {
            return PackageType.valueOfId(source);
        }
    }
    
}
