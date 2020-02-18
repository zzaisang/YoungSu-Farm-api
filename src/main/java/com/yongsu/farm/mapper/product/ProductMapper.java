package com.yongsu.farm.mapper.product;

import com.yongsu.farm.domain.product.ProductCategory;
import com.yongsu.farm.dto.product.ProductCategoryDto;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/02/05
 */
public class ProductMapper {

    private ProductMapper() {
    }

    public static List<ProductCategoryDto> makeCategoryDtoList(List<ProductCategory> productCategoryList) {

        return productCategoryList
                .stream()
                .map(v ->
                        ProductCategoryDto
                                .builder()
                                .productCategoryId(v.getId())
                                .name(v.getName())
                                .build()
                ).collect(Collectors.toList());
    }
}
