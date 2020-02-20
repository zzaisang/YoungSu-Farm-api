package com.yongsu.farm.domain.order;

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
 * @since 2020/02/20
 */
@Getter
@AllArgsConstructor
public enum OrderType {

    NON_MEMBER_ORDER(0,"비회원 주문"),
    MEMBER_ORDER(1,"회원 주문");

    private int id;
    private String name;

    private static Map<Integer, OrderType> tables = Stream.of(values()).collect(Collectors.toMap(OrderType::getId, Function.identity()));

    public static OrderType valueOfId(int key) {
        return tables.get(key);
    }

    @Component
    public static class OrderTypeConverter implements Converter<Integer, OrderType> {
        public OrderType convert(Integer source) {
            return OrderType.valueOfId(source);
        }
    }
}
