package com.yongsu.farm.domain.product;

import lombok.*;

import javax.persistence.*;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/02/05
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ProductStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int initStock;

    private int stock;

    @OneToOne
    private Product product;

    @Builder
    public ProductStock(int initStock, int stock) {
        this.initStock = initStock;
        this.stock = stock;
    }
}
