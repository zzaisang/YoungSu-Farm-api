package com.yongsu.farm.repository.product.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yongsu.farm.domain.product.QRecommendedProduct;
import com.yongsu.farm.repository.product.RecommendedProductRepositoryCustom;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/03/05
 */
@Repository
public class RecommendedProductRepositoryCustomImpl extends QuerydslRepositorySupport implements RecommendedProductRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public RecommendedProductRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        super(RecommendedProductRepositoryCustomImpl.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public int getCount() {

        final QRecommendedProduct qRecommendedProduct = QRecommendedProduct.recommendedProduct;

        return 0;
    }
}
