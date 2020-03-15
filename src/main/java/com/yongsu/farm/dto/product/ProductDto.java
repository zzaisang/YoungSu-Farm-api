package com.yongsu.farm.dto.product;

import com.yongsu.farm.domain.product.ProductState;
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
public class ProductDto {

    private String productName;

    private ProductState productState;

    private int price;

    private int maxPurchaseCnt;

    @Builder
    public ProductDto(String productName, ProductState productState, int price, int maxPurchaseCnt) {
        this.productName = productName;
        this.productState = productState;
        this.price = price;
        this.maxPurchaseCnt = maxPurchaseCnt;
    }
}
