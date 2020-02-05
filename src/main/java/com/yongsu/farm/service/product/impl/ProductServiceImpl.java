package com.yongsu.farm.service.product.impl;

import com.yongsu.farm.dto.api.Code;
import com.yongsu.farm.dto.api.CodeResult;
import com.yongsu.farm.mapper.product.ProductMapper;
import com.yongsu.farm.repository.product.ProductCategoryRepository;
import com.yongsu.farm.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/02/05
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductCategoryRepository productCategoryRepository;

    @Override
    @Transactional
    public CodeResult getProductCategoryList() {
        return new CodeResult(Code.SUCCESS, ProductMapper.makeCategoryDtoList(productCategoryRepository.findAll()));
    }
}
