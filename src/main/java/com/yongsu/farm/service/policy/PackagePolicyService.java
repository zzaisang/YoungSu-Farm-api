package com.yongsu.farm.service.policy;

import com.yongsu.farm.domain.product.Product;
import com.yongsu.farm.dto.policy.PackagePolicyDto;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/03/14
 */
public interface PackagePolicyService {

    PackagePolicyDto getPackagePolicyDto(Product product);
}
