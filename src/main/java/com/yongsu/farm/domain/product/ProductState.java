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
public enum ProductState {

    SALE(0,"판매중"),
    BEFORE_SALE(1,"판매준비중"),
    FADE_OUT(2,"상품 미 노출"),
    SOLD_OUT(3,"재고 없음");

    private int id;
    private String name;

    private static Map<Integer, ProductState> tables = Stream.of(values()).collect(Collectors.toMap(ProductState::getId, Function.identity()));

    public static ProductState valueOfId(int key) {
        return tables.get(key);
    }

    @Component
    public static class ProductStateConverter implements Converter<Integer, ProductState> {
        public ProductState convert(Integer source) {
            return ProductState.valueOfId(source);
        }
    }
}
