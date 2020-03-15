package com.yongsu.farm.repository.product;

import com.yongsu.farm.domain.common.YesNo;
import com.yongsu.farm.domain.product.RecommendedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020-02-24
 */
public interface RecommendedProductRepository extends JpaRepository<RecommendedProduct,Integer> {

    List<RecommendedProduct> findAllByUseYn(YesNo yesNo);
}
