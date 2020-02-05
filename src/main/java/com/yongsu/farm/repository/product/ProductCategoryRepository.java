package com.yongsu.farm.repository.product;

import com.yongsu.farm.domain.product.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/02/05
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
}
