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
public enum OrderStatus {

    ORDER(0,"주문"),
    USER_CANCEL(1,"회원 취소"),
    ADMIN_CANCEL(2,"관리자 취소"),
    ORDER_CONFIRM(3,"주문 확정"),
    PREPARING_PRODUCT(4,"상품 준비중"),
    DELIVERING(5,"배송중"),
    DELIVERY_END(6,"배송완료"),
    RECEIPT_CONFIRMED(7,"수령확인");

    private int id;
    private String name;

    private static Map<Integer, OrderStatus> tables = Stream.of(values()).collect(Collectors.toMap(OrderStatus::getId, Function.identity()));

    public static OrderStatus valueOfId(int key) {
        return tables.get(key);
    }

    @Component
    public static class OrderStateConverter implements Converter<Integer, OrderStatus> {
        public OrderStatus convert(Integer source) {
            return OrderStatus.valueOfId(source);
        }
    }
    
}
