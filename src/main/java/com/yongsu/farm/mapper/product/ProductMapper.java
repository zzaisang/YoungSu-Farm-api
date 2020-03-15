package com.yongsu.farm.mapper.product;

import com.yongsu.farm.domain.product.Product;
import com.yongsu.farm.dto.product.ProductDto;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/02/05
 */
public class ProductMapper {

    private ProductMapper() {
    }

    public static ProductDto makeProductDto(Product product){
        return ProductDto.builder()
                .productName(product.getName())
                .productState(product.getState())
                .price(product.getPrice())
                .maxPurchaseCnt(product.getMaxPurchaseCnt())
                .build();
    }

}
