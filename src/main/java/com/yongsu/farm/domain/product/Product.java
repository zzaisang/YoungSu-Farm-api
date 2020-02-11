package com.yongsu.farm.domain.product;

import com.yongsu.farm.domain.policy.PackagePolicy;
import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020-02-04
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"productCategory","packagePolicy","productStock"})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ProductState state;

    private int price;

    private int maxPurchaseCnt;

    private OffsetDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id",nullable = false,updatable = false)
    private ProductCategory productCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "package_policy_id",nullable = false,updatable = false)
    private PackagePolicy packagePolicy;

    @OneToOne(mappedBy = "product")
    private ProductStock productStockList;

    @OneToMany(mappedBy = "product",cascade = CascadeType.PERSIST)
    private List<ProductImage> productImageList = new ArrayList<>();

    @Builder
    public Product(String name, ProductState state, int price, int maxPurchaseCnt, OffsetDateTime createdAt) {
        this.name = name;
        this.state = state;
        this.price = price;
        this.maxPurchaseCnt = maxPurchaseCnt;
        this.createdAt = createdAt;
    }
}
