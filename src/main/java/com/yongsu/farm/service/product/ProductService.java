package com.yongsu.farm.service.product;

import com.yongsu.farm.domain.product.Product;
import com.yongsu.farm.dto.api.CodeResult;
import com.yongsu.farm.dto.product.ProductDto;
import com.yongsu.farm.dto.product.ProductInfoDto;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/02/05
 */
public interface ProductService {

    CodeResult<ProductInfoDto> getSaleAbleProductInfoDto(long productId);

    ProductDto getProductDto(Product product);
}
