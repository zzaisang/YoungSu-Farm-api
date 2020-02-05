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
public enum PackageVolumeType {

    G(0,"그램"),
    KG(1,"킬로그램");

    private int id;
    private String name;

    private static Map<Integer, PackageVolumeType> tables = Stream.of(values()).collect(Collectors.toMap(PackageVolumeType::getId, Function.identity()));

    public static PackageVolumeType valueOfId(int key) {
        return tables.get(key);
    }

    @Component
    public static class PackageVolumeTypeConverter implements Converter<Integer, PackageVolumeType> {
        public PackageVolumeType convert(Integer source) {
            return PackageVolumeType.valueOfId(source);
        }
    }
}
