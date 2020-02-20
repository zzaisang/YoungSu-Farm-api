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
public enum DeliveryRequestType {

    DOOR(0,"문 앞"),
    SELF_COLLECTION_DOOR(1,"직접 받고 부재 시 문 앞"),
    SECURITY_OFFICE(2,"경비실"),
    COURIER_BOX(3,"택배함"),
    OTHER(4,"기타");

    private int id;
    private String name;

    private static Map<Integer, DeliveryRequestType> tables = Stream.of(values()).collect(Collectors.toMap(DeliveryRequestType::getId, Function.identity()));

    public static DeliveryRequestType valueOfId(int key) {
        return tables.get(key);
    }

    @Component
    public static class DeliveryRequestTypeConverter implements Converter<Integer, DeliveryRequestType> {
        public DeliveryRequestType convert(Integer source) {
            return DeliveryRequestType.valueOfId(source);
        }
    }
}
