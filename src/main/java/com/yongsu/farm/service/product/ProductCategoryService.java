package com.yongsu.farm.service.product;

import com.yongsu.farm.domain.product.Product;
import com.yongsu.farm.dto.api.CodeResult;
import com.yongsu.farm.dto.product.ProductCategoryDto;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/03/14
 */
public interface ProductCategoryService {

    CodeResult getProductCategoryList();

    ProductCategoryDto getProductCategoryDto(Product product);
}
