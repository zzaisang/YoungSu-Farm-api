package com.yongsu.farm.service.policy.impl;

import com.yongsu.farm.domain.product.Product;
import com.yongsu.farm.dto.policy.PackagePolicyDto;
import com.yongsu.farm.mapper.policy.PackagePolicyMapper;
import com.yongsu.farm.service.policy.PackagePolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/03/14
 */
@Service
@RequiredArgsConstructor
public class PackagePolicyServiceImpl implements PackagePolicyService {

    @Override
    @Transactional
    public PackagePolicyDto getPackagePolicyDto(Product product) {
        return PackagePolicyMapper.makePackagePolicyDto(product.getPackagePolicy());
    }
}
