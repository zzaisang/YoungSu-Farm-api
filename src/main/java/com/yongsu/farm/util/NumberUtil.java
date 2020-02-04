package com.yongsu.farm.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020-02-04
 */
@Component
@Slf4j
public class NumberUtil {

    private NumberUtil() {}

    public static int toInt(@NotNull Object src, int defaultValue) {
        if (src == null) {
            return defaultValue;
        } else {
            if (src instanceof String) {
                try {
                    return Integer.parseInt((String)src);
                } catch (Exception var3) {
                    log.warn(var3.getMessage(), var3);
                }
            } else if (src instanceof Number) {
                return ((Number)src).intValue();
            }

            return defaultValue;
        }
    }

    public static double toDouble(@NotNull Object src, double defaultValue) {
        if (src == null) {
            return defaultValue;
        } else {
            if (src instanceof String) {
                try {
                    return Double.parseDouble((String)src);
                } catch (Exception var4) {
                    log.warn(var4.getMessage(), var4);
                }
            } else if (src instanceof Number) {
                return ((Number)src).doubleValue();
            }

            return defaultValue;
        }
    }
}
