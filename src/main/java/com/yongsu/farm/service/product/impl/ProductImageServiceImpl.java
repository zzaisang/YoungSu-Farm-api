package com.yongsu.farm.service.product.impl;

import com.yongsu.farm.domain.product.Product;
import com.yongsu.farm.dto.product.ProductImageDto;
import com.yongsu.farm.mapper.product.ProductImageMapper;
import com.yongsu.farm.service.product.ProductImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/03/14
 */
@Service
@RequiredArgsConstructor
public class ProductImageServiceImpl implements ProductImageService {

    @Override
    @Transactional
    public List<ProductImageDto> getProductImageDtoList(Product product) {

        return product.getProductImageList()
                .stream()
                .filter(v -> v.getRepresentYn().isYes())
                .map(v -> ProductImageMapper.makeProductImageDto(v))
                .collect(Collectors.toList());
    }
}
