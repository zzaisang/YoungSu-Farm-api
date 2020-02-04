package com.yongsu.farm.domain.product;

import com.yongsu.farm.domain.common.YesNo;
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
@ToString(exclude = "productList")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private YesNo useYn;

    private OffsetDateTime createdAt;

    @OneToMany(mappedBy = "productCategory",cascade = CascadeType.PERSIST)
    private List<Product> productList = new ArrayList<>();

    @Builder
    public ProductCategory(String name, YesNo useYn, OffsetDateTime createdAt) {
        this.name = name;
        this.useYn = useYn;
        this.createdAt = createdAt;
    }
}
