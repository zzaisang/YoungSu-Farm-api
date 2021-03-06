package com.yongsu.farm.domain.product;

import com.yongsu.farm.domain.common.YesNo;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.OffsetDateTime;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/02/20
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class RecommendedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private YesNo useYn;

    private long productId;

    private int listOrder;

    private OffsetDateTime createdAt;

    @Builder
    public RecommendedProduct(long productId, OffsetDateTime createdAt) {
        this.productId = productId;
        this.createdAt = createdAt;
    }
}
