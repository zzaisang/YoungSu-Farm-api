package com.yongsu.farm.repository.product;

import com.yongsu.farm.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/02/05
 */
public interface ProductRepository extends JpaRepository<Product,Long> {
}
