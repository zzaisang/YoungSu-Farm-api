package com.yongsu.farm.dto.product;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/02/05
 */
@Getter @NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductCategoryDto {

    private int productCategoryId;

    private String name;

    @Builder
    public ProductCategoryDto(int productCategoryId, String name) {
        this.productCategoryId = productCategoryId;
        this.name = name;
    }
}
