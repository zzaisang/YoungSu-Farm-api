package com.yongsu.farm.domain.product;

import com.yongsu.farm.domain.common.YesNo;
import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020-02-12
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ProductImage {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private YesNo representYn;

    private String name;

    private String url;

    private OffsetDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",nullable = false,updatable = false)
    private Product product;

    @Builder
    public ProductImage(YesNo representYn, String name, String url, OffsetDateTime createdAt) {
        this.representYn = representYn;
        this.name = name;
        this.url = url;
        this.createdAt = createdAt;
    }
}
