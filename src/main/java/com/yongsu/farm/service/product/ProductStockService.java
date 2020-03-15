package com.yongsu.farm.service.product;

import com.yongsu.farm.domain.product.Product;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/03/14
 */
public interface ProductStockService {

    int getProductStockCnt(Product product);
}
