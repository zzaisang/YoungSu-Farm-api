package com.yongsu.farm.service.product.impl;

import com.yongsu.farm.domain.common.YesNo;
import com.yongsu.farm.domain.product.RecommendedProduct;
import com.yongsu.farm.dto.api.Code;
import com.yongsu.farm.dto.api.CodeResult;
import com.yongsu.farm.dto.product.ProductInfoDto;
import com.yongsu.farm.repository.product.RecommendedProductRepository;
import com.yongsu.farm.service.product.ProductService;
import com.yongsu.farm.service.product.RecommendedProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/03/14
 */
@Service
@RequiredArgsConstructor
public class RecommendedProductServiceImpl implements RecommendedProductService {

    private final ProductService productService;

    private final RecommendedProductRepository recommendedProductRepository;

    @Override
    @Transactional(readOnly = true)
    public CodeResult getRecommendList() {
        final List<RecommendedProduct> recommendedProductList = recommendedProductRepository.findAllByUseYn(YesNo.YES);
        final List<ProductInfoDto> productInfoDtoList = new ArrayList<>();

        for (RecommendedProduct recommendedProduct : recommendedProductList) {
            final long productId = recommendedProduct.getProductId();
            final CodeResult codeResult = productService.getSaleAbleProductInfoDto(productId);
            if(codeResult.isSucceeded()) productInfoDtoList.add((ProductInfoDto)codeResult.getData());
        }

        return new CodeResult(Code.SUCCESS,productInfoDtoList);
    }
}
