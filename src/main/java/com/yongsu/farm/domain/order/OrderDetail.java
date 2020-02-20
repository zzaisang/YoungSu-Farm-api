package com.yongsu.farm.domain.order;

import com.yongsu.farm.domain.product.Product;
import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/02/20
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"product","order"})
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int count;

    private OffsetDateTime modifiedAt;

    private OffsetDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",nullable = false,updatable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id",nullable = false,updatable = false)
    private Order order;

    @Builder
    public OrderDetail(int count, OffsetDateTime modifiedAt, OffsetDateTime createdAt) {
        this.count = count;
        this.modifiedAt = modifiedAt;
        this.createdAt = createdAt;
    }
}
