package com.yongsu.farm.mapper.product;

import com.yongsu.farm.domain.product.ProductImage;
import com.yongsu.farm.dto.product.ProductImageDto;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/03/14
 */
public class ProductImageMapper {

    private ProductImageMapper() {
    }

    public static ProductImageDto makeProductImageDto(ProductImage productImage) {
        return ProductImageDto.builder()
                .position(productImage.getPosition())
                .listOrder(productImage.getListOrder())
                .name(productImage.getName())
                .url(productImage.getUrl())
                .build();
    }
}
