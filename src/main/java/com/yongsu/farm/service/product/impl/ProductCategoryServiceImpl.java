package com.yongsu.farm.service.product.impl;

import com.yongsu.farm.domain.product.Product;
import com.yongsu.farm.dto.api.Code;
import com.yongsu.farm.dto.api.CodeResult;
import com.yongsu.farm.dto.product.ProductCategoryDto;
import com.yongsu.farm.exception.BusinessException;
import com.yongsu.farm.mapper.product.ProductCategoryMapper;
import com.yongsu.farm.repository.product.ProductCategoryRepository;
import com.yongsu.farm.service.product.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/03/14
 */
@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    @Override
    @Transactional(readOnly = true)
    public CodeResult getProductCategoryList() {

        final List<ProductCategoryDto> productCategoryDtoList = productCategoryRepository.findAll()
                .stream()
                .map(v -> ProductCategoryMapper.makeCategoryDto(v))
                .collect(Collectors.toList());

        return new CodeResult(Code.SUCCESS,productCategoryDtoList);
    }

    @Override
    @Transactional
    public ProductCategoryDto getProductCategoryDto(Product product) {
        return Optional.ofNullable(product.getProductCategory())
                .map(v -> ProductCategoryMapper.makeCategoryDto(v))
                .orElseThrow(() -> new BusinessException(Code.BAD_REQUEST,"상품 카테고리가 존재하지 않습니다."));
    }
}
