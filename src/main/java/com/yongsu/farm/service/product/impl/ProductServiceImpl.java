package com.yongsu.farm.service.product.impl;

import com.yongsu.farm.domain.product.Product;
import com.yongsu.farm.dto.api.Code;
import com.yongsu.farm.dto.api.CodeResult;
import com.yongsu.farm.dto.policy.PackagePolicyDto;
import com.yongsu.farm.dto.product.ProductCategoryDto;
import com.yongsu.farm.dto.product.ProductDto;
import com.yongsu.farm.dto.product.ProductImageDto;
import com.yongsu.farm.dto.product.ProductInfoDto;
import com.yongsu.farm.exception.BusinessException;
import com.yongsu.farm.mapper.product.ProductMapper;
import com.yongsu.farm.repository.product.ProductRepository;
import com.yongsu.farm.service.policy.PackagePolicyService;
import com.yongsu.farm.service.product.ProductCategoryService;
import com.yongsu.farm.service.product.ProductImageService;
import com.yongsu.farm.service.product.ProductService;
import com.yongsu.farm.service.product.ProductStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/02/05
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductStockService productStockService;
    private final ProductImageService productImageService;
    private final PackagePolicyService packagePolicyService;
    private final ProductCategoryService productCategoryService;

    private final ProductRepository productRepository;

    @Override
    @Transactional
    public CodeResult<ProductInfoDto> getSaleAbleProductInfoDto(long productId) {

        final Product product = getProduct(productId);

        if(productStockService.getProductStockCnt(product) <= 0){
            return new CodeResult(Code.BAD_REQUEST,"해당상품의 잔고가 존재하지 않습니다.");
        }

        final List<ProductImageDto> productImageDtoList = productImageService.getProductImageDtoList(product);
        final PackagePolicyDto packagePolicyDto = packagePolicyService.getPackagePolicyDto(product);
        final ProductCategoryDto productCategoryDto = productCategoryService.getProductCategoryDto(product);
        final ProductDto productDto = getProductDto(product);
        final ProductInfoDto productInfoDto = ProductInfoDto.builder()
                .productDto(productDto)
                .packagePolicyDto(packagePolicyDto)
                .productCategoryDto(productCategoryDto)
                .productImageDtoList(productImageDtoList)
                .build();

        return new CodeResult(Code.SUCCESS,productInfoDto);
    }

    @Override
    public ProductDto getProductDto(Product product) {
        return ProductMapper.makeProductDto(product);
    }

    private Product getProduct(long productId){
        return productRepository.findById(productId)
                .orElseThrow(() -> new BusinessException(Code.BAD_REQUEST,"해당 상품번호가 존재하지 않습니다."));
    }


}
