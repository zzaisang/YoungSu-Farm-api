package com.yongsu.farm.domain.product;

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
 * @since 2020-02-04
 */
@Getter
@AllArgsConstructor
public enum ProductUnitType {

    APPLE_TYPE(0,"과");
    
    private int id;
    private String name;

    private static Map<Integer, ProductUnitType> tables = Stream.of(values()).collect(Collectors.toMap(ProductUnitType::getId, Function.identity()));

    public static ProductUnitType valueOfId(int key) {
        return tables.get(key);
    }

    @Component
    public static class ProductUnitTypeConverter implements Converter<Integer, ProductUnitType> {
        public ProductUnitType convert(Integer source) {
            return ProductUnitType.valueOfId(source);
        }
    }
}
