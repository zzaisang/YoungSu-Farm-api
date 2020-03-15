package com.yongsu.farm.service.product.impl;

import com.yongsu.farm.domain.product.Product;
import com.yongsu.farm.domain.product.ProductStock;
import com.yongsu.farm.service.product.ProductStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/03/14
 */
@Service
@RequiredArgsConstructor
public class ProductStockServiceImpl implements ProductStockService {

    @Override
    @Transactional
    public int getProductStockCnt(Product product) {
        return Optional.ofNullable(product.getProductStockList())
                .map(ProductStock::getStock)
                .orElse(0);
    }
}
