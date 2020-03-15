package com.yongsu.farm.mapper.product;

import com.yongsu.farm.domain.product.ProductCategory;
import com.yongsu.farm.dto.product.ProductCategoryDto;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/03/14
 */
public class ProductCategoryMapper {
    private ProductCategoryMapper() {
    }

    public static ProductCategoryDto makeCategoryDto(ProductCategory productCategory) {

        return ProductCategoryDto
                        .builder()
                        .productCategoryId(productCategory.getId())
                        .name(productCategory.getName())
                        .build();
    }
}
