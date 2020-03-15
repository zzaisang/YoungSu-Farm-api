package com.yongsu.farm.dto.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yongsu.farm.dto.policy.PackagePolicyDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/03/14
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductInfoDto {

    private ProductDto productDto;

    private ProductCategoryDto productCategoryDto;

    private PackagePolicyDto packagePolicyDto;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ProductImageDto> productImageDtoList;

    @Builder
    public ProductInfoDto(ProductDto productDto, ProductCategoryDto productCategoryDto, PackagePolicyDto packagePolicyDto, List<ProductImageDto> productImageDtoList) {
        this.productDto = productDto;
        this.productCategoryDto = productCategoryDto;
        this.packagePolicyDto = packagePolicyDto;
        this.productImageDtoList = productImageDtoList;
    }
}
