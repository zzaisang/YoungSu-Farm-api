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
 * @since 2020/03/14
 */
@Getter
@AllArgsConstructor
public enum ProductImagePosition {

    THUMBNAIL(0,"썸네일 이미지"),
    DETAIL(1,"판매 준비 중");

    private int id;
    private String name;

    private static Map<Integer, ProductImagePosition> tables = Stream.of(values()).collect(Collectors.toMap(ProductImagePosition::getId, Function.identity()));

    public static ProductImagePosition valueOfId(int key) {
        return tables.get(key);
    }

    @Component
    public static class ProductImagePositionConverter implements Converter<Integer, ProductImagePosition> {
        public ProductImagePosition convert(Integer source) {
            return ProductImagePosition.valueOfId(source);
        }
    }
}
