package com.yongsu.farm.domain.product;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020-02-04
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"productCategory"})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ProductState state;

    @Enumerated(EnumType.STRING)
    private ProductUnitType unitType;

    private int unitCnt;

    private OffsetDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id",nullable = false,updatable = false)
    private ProductCategory productCategory;

    @Builder
    public Product(String name, ProductState state, ProductUnitType unitType, int unitCnt, OffsetDateTime createdAt) {
        this.name = name;
        this.state = state;
        this.unitType = unitType;
        this.unitCnt = unitCnt;
        this.createdAt = createdAt;
    }
}
