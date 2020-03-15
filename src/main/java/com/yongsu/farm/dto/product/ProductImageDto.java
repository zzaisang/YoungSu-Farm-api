package com.yongsu.farm.dto.product;

import com.yongsu.farm.domain.product.ProductImagePosition;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/03/14
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductImageDto {

    private ProductImagePosition position;

    private int listOrder;

    private String name;

    private String url;

    @Builder
    public ProductImageDto(ProductImagePosition position, int listOrder, String name, String url) {
        this.position = position;
        this.listOrder = listOrder;
        this.name = name;
        this.url = url;
    }
}
