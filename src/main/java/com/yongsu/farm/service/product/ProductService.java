package com.yongsu.farm.service.product;

import com.yongsu.farm.dto.api.CodeResult;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/02/05
 */
public interface ProductService {

    CodeResult getProductCategoryList();

    CodeResult getRecommendList();
}
